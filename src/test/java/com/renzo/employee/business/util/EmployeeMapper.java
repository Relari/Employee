package com.renzo.employee.business.util;

import com.renzo.employee.business.model.api.request.EmployeeDetail;
import com.renzo.employee.business.model.api.request.EmployeePerson;
import com.renzo.employee.business.model.api.request.EmployeeRequest;
import com.renzo.employee.business.model.business.Employee;
import com.renzo.employee.business.model.entity.EmployeeEntity;

public class EmployeeMapper {

  public EmployeeRequest employeeRequest() {

    EmployeePerson employeePerson = EmployeePerson.builder()
            .nombre(EmployeeTestConstant.nombre)
            .apellidoPaterno(EmployeeTestConstant.apellidoPaterno)
            .apellidoMaterno(EmployeeTestConstant.apellidoMaterno)
            .sexo(EmployeeTestConstant.sexo)
            .build();

    EmployeeDetail employeeDetail = new EmployeeDetail(
            EmployeeTestConstant.cargo, EmployeeTestConstant.salario);

    return new EmployeeRequest(employeePerson, employeeDetail);
  }

  public Employee employee() {
    return Employee.builder()
        .idEmployee(EmployeeTestConstant.idEmployee)
        .nombre(EmployeeTestConstant.nombre)
        .apellidoPaterno(EmployeeTestConstant.apellidoPaterno)
        .apellidoMaterno(EmployeeTestConstant.apellidoMaterno)
        .sexo(EmployeeTestConstant.sexo)
        .cargo(EmployeeTestConstant.cargo)
        .sueldo(EmployeeTestConstant.salario)
        .isActive(EmployeeTestConstant.isActive)
        .build();
  }

  public EmployeeEntity employeeEntity() {
    return EmployeeEntity.builder()
        .id(EmployeeTestConstant.idEmployee)
        .nombre(EmployeeTestConstant.nombre)
        .apellidoPaterno(EmployeeTestConstant.apellidoPaterno)
        .apellidoMaterno(EmployeeTestConstant.apellidoMaterno)
        .sexo(EmployeeTestConstant.sexo)
        .cargo(EmployeeTestConstant.cargo)
        .sueldo(EmployeeTestConstant.salario)
        .isActive(EmployeeTestConstant.isActive)
        .build();
  }
}
