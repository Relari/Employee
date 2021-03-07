package com.pe.relari.employee.business.dao.impl;

import java.util.Collections;
import java.util.Optional;

import com.pe.relari.employee.business.exception.ErrorCategory;
import com.pe.relari.employee.business.exception.ExceptionFactory;
import com.pe.relari.employee.business.dao.repository.EmployeeRepository;
import com.pe.relari.employee.business.model.business.Employee;
import com.pe.relari.employee.business.util.EmployeeMapper;
import com.pe.relari.employee.config.ApplicationProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.reactivex.observers.TestObserver;

@ExtendWith(MockitoExtension.class)
class EmployeeDaoTest {

  @Mock
  private EmployeeRepository employeeRepository;

  @Mock
  private ApplicationProperties applicationProperties;

  @InjectMocks
  private EmployeeDaoImpl employeeDao;

  private final EmployeeMapper employeeMapper = new EmployeeMapper();

  @Test
  void whenFindAllThenReturnListEmployees() {

    Mockito.when(employeeRepository.findAll())
        .thenReturn(Collections.singletonList(employeeMapper.employeeEntity()));

    TestObserver<Employee> testObserver = employeeDao.findAll().test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenFindByIdThenReturnEmployee() {

    Mockito.when(employeeRepository.findById(Mockito.anyInt()))
        .thenReturn(Optional.of(employeeMapper.employeeEntity()));

    TestObserver<Employee> testObserver = employeeDao.findById(1).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenSaveEmployeeThenReturnEmployee() {

    Mockito.when(employeeRepository.save(Mockito.any()))
        .thenReturn(employeeMapper.employeeEntity());

    TestObserver<Void> testObserver = employeeDao.save(employeeMapper.employee()).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenFindByIdThenReturnEmpty() {

    Mockito.when(employeeRepository.findById(Mockito.anyInt()))
            .thenReturn(Optional.empty());

    TestObserver<Employee> testObserver = employeeDao.findById(1).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertNotComplete().assertNoValues();

  }

  @Test
  void whenSaveEmployeeThenReturnError() {

    Mockito.when(employeeRepository.save(Mockito.any()))
            .thenReturn(employeeException());

    TestObserver<Void> testObserver = employeeDao.save(employeeMapper.employee()).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertNotComplete().assertNoValues();

  }

  private RuntimeException employeeException() {
    return ExceptionFactory.builder()
            .errorCategory(ErrorCategory.INTERNAL_ERROR)
            .message("Failed to save an employee.")
            .throwable(new Throwable())
            .build()
            .getException();
  }

}
