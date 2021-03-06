package com.pe.relari.employee.business.service.impl;

import com.pe.relari.employee.business.dao.EmployeeDao;
import com.pe.relari.employee.business.exception.ExceptionFactory;
import com.pe.relari.employee.business.model.business.Employee;
import com.pe.relari.employee.business.util.EmployeeMapper;
import com.pe.relari.employee.business.util.EmployeeTestConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

  @Mock
  private EmployeeDao employeeDao;

  @InjectMocks
  private EmployeeServiceImpl employeeService;

  private final EmployeeMapper employeeMapper = new EmployeeMapper();

  @Test
  void whenFindAllThenReturnListEmployees() {

    Mockito.when(employeeDao.findAll())
        .thenReturn(Observable.just(employeeMapper.employee()));

    TestObserver<Employee> testObserver = employeeService.findAll().test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenSaveEmployeeThenReturnSuccessful() {

    Mockito.when(employeeDao.save(Mockito.any()))
        .thenReturn(Completable.complete());

    TestObserver<Void> testObserver =
        employeeService.save(employeeMapper.employee()).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenFindByIdThenReturnEmployee() {
    Mockito.when(employeeDao.findById(Mockito.anyInt()))
        .thenReturn(Single.just(employeeMapper.employee()));

    TestObserver<Employee> testObserver = employeeService.findById(1).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
        .assertValue(employeeDto -> employeeDto.getIdEmployee().equals(EmployeeTestConstant.idEmployee))
        .assertValue(employeeDto -> employeeDto.getFirstName().equals(EmployeeTestConstant.nombre))
        .assertValue(employeeDto -> employeeDto.getLastNameFather().equals(EmployeeTestConstant.apellidoPaterno))
        .assertValue(employeeDto -> employeeDto.getLastNameMother().equals(EmployeeTestConstant.apellidoMaterno))
        .assertValue(employeeDto -> employeeDto.getSex().equals(EmployeeTestConstant.sexo))
        .assertValue(employeeDto -> employeeDto.getPosition().equals(EmployeeTestConstant.cargo))
        .assertValue(employeeDto -> employeeDto.getSalary().equals(EmployeeTestConstant.salario))
        .assertValue(employeeDto -> employeeDto.getIsActive().equals(EmployeeTestConstant.isActive));

  }
  
  @Test
  void whenFindByIdThenReturnError() {

    Mockito.when(employeeDao.findById(Mockito.anyInt()))
        .thenReturn(Single.error(this::employeeException));

    TestObserver<Employee> testObserver = employeeService.findById(1).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertNotComplete().assertNoValues();

  }

  @Test
  void whenSaveEmployeeThenReturnError() {

    Mockito.when(employeeDao.save(Mockito.any()))
        .thenReturn(Completable.error(this::employeeException));

    TestObserver<Void> testObserver = employeeService.save(employeeMapper.employee()).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertNotComplete().assertNoValues();

  }

  private RuntimeException employeeException() {
    return ExceptionFactory.builder()
            .message("Failed to save an employee.")
            .throwable(new Throwable())
            .build()
            .getException();
  }

}
