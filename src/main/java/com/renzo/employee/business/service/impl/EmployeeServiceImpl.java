package com.renzo.employee.business.service.impl;

import com.renzo.employee.business.dao.EmployeeDao;
import com.renzo.employee.business.model.business.Employee;
import com.renzo.employee.business.service.EmployeeService;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

/**
 * <b>Class:</b> EmployeeServiceImpl.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Service
@AllArgsConstructor
class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeDao employeeDao;

  @Override
  public Observable<Employee> findAll() {
    return employeeDao.findAll();
  }

  @Override
  public Completable save(Employee employee) {
    return employeeDao.save(employee);
  }

  @Override
  public Single<Employee> findById(Integer id) {
    return employeeDao.findById(id);
  }
  
}
