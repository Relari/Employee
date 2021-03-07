package com.pe.relari.employee.controller;

import com.pe.relari.employee.business.model.api.PersonResponse;
import com.pe.relari.employee.business.service.EmployeeService;
import com.pe.relari.employee.business.util.EmployeeTestConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pe.relari.employee.business.util.EmployeeMapper;

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

  private final EmployeeMapper employeeMapper = new EmployeeMapper();

  @Test
  void whenFindAllThenReturnListEmployees() {

    Mockito.when(employeeService.findAll())
        .thenReturn(Observable.just(employeeMapper.employee()));

    TestObserver<PersonResponse> testObserver = employeeController.listOfEmployees().test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
        .assertValue(personResponse -> personResponse.getFirstName().equals(EmployeeTestConstant.nombre))
        .assertValue(personResponse -> personResponse.getLastNameFather().equals(EmployeeTestConstant.apellidoPaterno))
        .assertValue(personResponse -> personResponse.getLastNameMother().equals(EmployeeTestConstant.apellidoMaterno))
        .assertValue(personResponse -> personResponse.getSex().equals(EmployeeTestConstant.sexo));

  }

  @Test
  void whenSaveEmployeeThenReturnSuccessful() {
    Mockito.when(employeeService.save(Mockito.any()))
        .thenReturn(Completable.complete());

    TestObserver<Void> testObserver =
        employeeController.save(employeeMapper.employeeRequest()).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenFindByIdThenReturnEmployee() {
    Mockito.when(employeeService.findById(Mockito.anyInt()))
        .thenReturn(Single.just(employeeMapper.employee()));

    TestObserver<PersonResponse> testObserver = employeeController.findEmployeeById(1).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
        .assertValue(personResponse -> personResponse.getFirstName().equals(EmployeeTestConstant.nombre))
        .assertValue(personResponse -> personResponse.getLastNameFather().equals(EmployeeTestConstant.apellidoPaterno))
        .assertValue(personResponse -> personResponse.getLastNameMother().equals(EmployeeTestConstant.apellidoMaterno));

  }

}
