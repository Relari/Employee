package com.renzo.employee.business.service.impl;

import com.renzo.employee.business.dao.EmployeeDao;
import com.renzo.employee.business.model.dto.EmployeeDto;
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

  private EmployeeDao employeeDao;

  @Override
  public Observable<EmployeeDto> findAll() {

    return employeeDao.findAll();
  }

  @Override
  public Completable saveEmployee(EmployeeDto employeeDto) {
    return employeeDao.saveEmployee(addStatusToEmployeeDto(employeeDto));
  }

  @Override
  public Single<EmployeeDto> findById(Integer id) {
    return employeeDao.findById(id);
  }
  
  private EmployeeDto addStatusToEmployeeDto(EmployeeDto employeeDto) {
    employeeDto.setIsActive(Boolean.TRUE);
    return employeeDto;
  }
  
}
