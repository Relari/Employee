package com.renzo.employee.business.dao.impl;

import com.renzo.employee.business.dao.EmployeeDao;
import com.renzo.employee.business.dao.repository.EmployeeRepository;
import com.renzo.employee.business.model.dto.EmployeeDto;
import com.renzo.employee.business.model.entity.EmployeeEntity;
import com.renzo.employee.config.ApplicationProperties;
import com.renzo.employee.config.exception.EmployeeException;
import com.renzo.employee.config.exception.EmployeeNotFoundException;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

/**
 * <b>Class:</b> EmployeeDaoImpl.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Slf4j
@Component
@AllArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

  private EmployeeRepository employeeRepository;

  private ApplicationProperties applicationProperties;

  @Override
  public Observable<EmployeeDto> findAll() {
    return Observable.fromCallable(() -> employeeRepository.findAll())
        .flatMapIterable(employeeEntities -> employeeEntities)
        .map(this::buildEmployee)
        .doOnNext(employeeDto -> log.trace(employeeDto.toString()))
        .doOnSubscribe(disposable -> log.debug("Starting to list the employees."))
        .doOnComplete(() -> log.info("The list of employees is completely ready."))
        .subscribeOn(Schedulers.io());
  }

  @Override
  public Completable saveEmployee(EmployeeDto employeeDto) {
    return Single.fromCallable(() -> buildEmployeeEntity(employeeDto))
        .map(employeeRepository::save)
        .onErrorResumeNext(throwable ->
                Single.error(new EmployeeException(applicationProperties.getGetEmployee(), throwable)))
        .doOnSubscribe(disposable -> log.debug("Starting to save the employee."))
        .doOnError(throwable -> log.error("An error occurred while saving the employee.", throwable))
        .ignoreElement()
        .doOnComplete(() -> log.info("The employee was successfully saved."))
        .subscribeOn(Schedulers.io());
  }

  @Override
  public Single<EmployeeDto> findById(Integer id) {
    return Single.fromCallable(() -> employeeRepository.findById(id).get())
        .map(this::buildEmployee)
        .onErrorResumeNext(throwable ->
                Single.error(new EmployeeNotFoundException(applicationProperties.getGetEmployee(), throwable)))
        .doOnSubscribe(disposable -> log.debug("Consulting the employee with id " + id))
        .doOnError(throwable -> log.error("Employee not found - id " + id,
            throwable))
        .doOnSuccess(employee -> log.info("The employee was found with the id" + id))
        .subscribeOn(Schedulers.io());
  }

  private EmployeeDto buildEmployee(EmployeeEntity employeeEntity) {
    return EmployeeDto.builder()
        .idEmployee(employeeEntity.getId())
        .nombre(employeeEntity.getNombre())
        .apellidoPaterno(employeeEntity.getApellidoPaterno())
        .apellidoMaterno(employeeEntity.getApellidoMaterno())
        .sexo(employeeEntity.getSexo())
        .cargo(employeeEntity.getCargo())
        .sueldo(employeeEntity.getSueldo())
        .isActive(employeeEntity.getIsActive())
        .build();
  }

  private EmployeeEntity buildEmployeeEntity(EmployeeDto employeeDto) {
    return EmployeeEntity.builder()
        .nombre(employeeDto.getNombre())
        .apellidoPaterno(employeeDto.getApellidoPaterno())
        .apellidoMaterno(employeeDto.getApellidoMaterno())
        .sexo(employeeDto.getSexo())
        .cargo(employeeDto.getCargo())
        .sueldo(employeeDto.getSueldo())
        .isActive(employeeDto.getIsActive())
        .build();
  }
}
