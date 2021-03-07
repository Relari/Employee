package com.pe.relari.employee.business.util;

import com.pe.relari.employee.business.model.api.EmployeeDetail;
import com.pe.relari.employee.business.model.api.EmployeePerson;
import com.pe.relari.employee.business.model.api.EmployeeRequest;
import com.pe.relari.employee.business.model.business.Employee;
import com.pe.relari.employee.business.model.entity.EmployeeEntity;

public class EmployeeMapper {

  public EmployeeRequest employeeRequest() {

    EmployeePerson employeePerson = EmployeePerson.builder()
            .firstName(EmployeeTestConstant.nombre)
            .lastNameFather(EmployeeTestConstant.apellidoPaterno)
            .lastNameMother(EmployeeTestConstant.apellidoMaterno)
            .sex(EmployeeTestConstant.sexo)
            .build();

    EmployeeDetail employeeDetail = new EmployeeDetail(
            EmployeeTestConstant.cargo, EmployeeTestConstant.salario);

    return new EmployeeRequest(employeePerson, employeeDetail);
  }

  public Employee employee() {
    return Employee.builder()
        .idEmployee(EmployeeTestConstant.idEmployee)
        .firstName(EmployeeTestConstant.nombre)
        .lastNameFather(EmployeeTestConstant.apellidoPaterno)
        .lastNameMother(EmployeeTestConstant.apellidoMaterno)
        .sex(EmployeeTestConstant.sexo)
        .position(EmployeeTestConstant.cargo)
        .salary(EmployeeTestConstant.salario)
        .isActive(EmployeeTestConstant.isActive)
        .build();
  }

  public EmployeeEntity employeeEntity() {
    return EmployeeEntity.builder()
        .id(EmployeeTestConstant.idEmployee)
        .firstName(EmployeeTestConstant.nombre)
        .lastNameFather(EmployeeTestConstant.apellidoPaterno)
        .lastNameMother(EmployeeTestConstant.apellidoMaterno)
        .sex(EmployeeTestConstant.sexo)
        .position(EmployeeTestConstant.cargo)
        .salary(EmployeeTestConstant.salario)
        .isActive(EmployeeTestConstant.isActive)
        .build();
  }
}
