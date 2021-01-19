package com.renzo.employee.business.dao.impl;

import com.renzo.employee.business.dao.EmployeeDao;
import com.renzo.employee.business.dao.repository.EmployeeRepository;
import com.renzo.employee.business.exception.ErrorCategory;
import com.renzo.employee.business.model.business.Employee;
import com.renzo.employee.business.model.entity.EmployeeEntity;
import com.renzo.employee.config.ApplicationProperties;
import com.renzo.employee.business.exception.ExceptionFactory;

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
class EmployeeDaoImpl implements EmployeeDao {

  private final EmployeeRepository employeeRepository;

  private final ApplicationProperties applicationProperties;

  @Override
  public Observable<Employee> findAll() {
    return Observable.fromCallable(employeeRepository::findAll)
        .subscribeOn(Schedulers.io())
        .flatMapIterable(employeeEntities -> employeeEntities)
        .map(this::mapEmployee)
        .doOnNext(employeeDto -> log.trace(employeeDto.toString()))
        .doOnSubscribe(disposable -> log.debug("Starting to list the employees."))
        .doOnComplete(() -> log.info("The list of employees is completely ready."));
  }

  @Override
  public Completable save(Employee employee) {
    return Single.fromCallable(() -> mapEmployeeEntity(employee))
        .map(employeeRepository::save)
        .subscribeOn(Schedulers.io())
        .onErrorResumeNext(throwable ->
                Single.error(ExceptionFactory.builder()
                        .message(applicationProperties.getCreateEmployee())
                        .errorCategory(ErrorCategory.INTERNAL_ERROR)
                        .throwable(throwable)
                        .build()
                        .getException()))
        .doOnSubscribe(disposable -> log.debug("Starting to save the employee."))
        .doOnError(throwable -> log.error("An error occurred while saving the employee.", throwable))
        .ignoreElement()
        .doOnComplete(() -> log.info("The employee was successfully saved."));
  }

  @Override
  public Single<Employee> findById(Integer id) {

    return Single.fromCallable(() -> findBy(id))
        .subscribeOn(Schedulers.io())
        .map(this::mapEmployee)
        .doOnSubscribe(disposable -> log.debug("Consulting the employee with id " + id))
        .doOnError(throwable -> log.error("Employee not found - id " + id,
            throwable))
        .doOnSuccess(employee -> log.info("The employee was found with the id" + id));
  }

  private EmployeeEntity findBy(Integer id) {
    return employeeRepository.findById(id)
            .orElseThrow(() -> ExceptionFactory.builder()
                    .message(applicationProperties.getGetEmployee())
                    .errorCategory(ErrorCategory.NOT_FOUND)
                    .build()
                    .getException());
  }

  private Employee mapEmployee(EmployeeEntity employeeEntity) {
    return Employee.builder()
        .idEmployee(employeeEntity.getId())
        .firstName(employeeEntity.getFirstName())
        .lastNameFather(employeeEntity.getLastNameFather())
        .lastNameMother(employeeEntity.getLastNameMother())
        .sex(employeeEntity.getSex())
        .position(employeeEntity.getPosition())
        .salary(employeeEntity.getSalary())
        .isActive(employeeEntity.getIsActive())
        .build();
  }

  private EmployeeEntity mapEmployeeEntity(Employee employee) {
    return EmployeeEntity.builder()
        .firstName(employee.getFirstName())
        .lastNameFather(employee.getLastNameFather())
        .lastNameMother(employee.getLastNameMother())
        .sex(employee.getSex())
        .position(employee.getPosition())
        .salary(employee.getSalary())
        .isActive(employee.getIsActive())
        .build();
  }
}
