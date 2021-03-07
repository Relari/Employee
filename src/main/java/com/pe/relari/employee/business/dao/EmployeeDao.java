package com.pe.relari.employee.business.dao;

import com.pe.relari.employee.business.model.business.Employee;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * <b>Interface:</b> EmployeeDao.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

public interface EmployeeDao {

  Observable<Employee> findAll();

  Completable save(Employee employee);

  Single<Employee> findById(Integer id);
}
