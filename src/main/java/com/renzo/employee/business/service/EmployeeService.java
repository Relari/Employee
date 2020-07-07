package com.renzo.employee.business.service;

import com.renzo.employee.business.model.dto.EmployeeDto;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * <b>Interface:</b> EmployeeService.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

public interface EmployeeService {

  Observable<EmployeeDto> findAll();

  Completable saveEmployee(EmployeeDto employeeDto);

  Single<EmployeeDto> findById(Integer id);
}
