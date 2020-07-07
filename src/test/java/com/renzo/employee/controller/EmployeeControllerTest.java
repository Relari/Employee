package com.renzo.employee.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.renzo.employee.business.model.api.response.PersonResponse;
import com.renzo.employee.business.model.dto.EmployeeDto;
import com.renzo.employee.business.service.EmployeeService;
import com.renzo.employee.business.util.EmployeeMapper;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

  @Mock
  private EmployeeService employeeService;

  @InjectMocks
  private EmployeeController employeeController;

  private EmployeeMapper employeeMapper = new EmployeeMapper();

  @Test
  void whenFindAllThenReturnListEmployees() {

    Mockito.when(employeeService.findAll())
        .thenReturn(Observable.just(employeeMapper.employeeDto()));

    TestObserver<PersonResponse> testObserver = employeeController.listOfEmployees().test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenSaveEmployeeThenReturnSuccessful() {
    Mockito.when(employeeService.saveEmployee(Mockito.any())).thenReturn(Completable.complete());

    TestObserver<Void> testObserver =
        employeeController.saveEmployee(employeeMapper.employeeRequest()).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenFindByIdThenReturnEmployee() {
    Mockito.when(employeeService.findById(Mockito.anyInt()))
        .thenReturn(Single.just(employeeMapper.employeeDto()));

    TestObserver<EmployeeDto> testObserver = employeeController.findEmployeeById(1).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

}
