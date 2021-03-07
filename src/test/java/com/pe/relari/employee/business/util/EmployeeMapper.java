package com.pe.relari.employee.business.util;

import com.pe.relari.employee.business.model.api.DetailModel;
import com.pe.relari.employee.business.model.api.PersonModel;
import com.pe.relari.employee.business.model.api.EmployeeRequest;
import com.pe.relari.employee.business.model.business.Employee;
import com.pe.relari.employee.business.model.entity.EmployeeEntity;

public class EmployeeMapper {

  public EmployeeRequest employeeRequest() {

    PersonModel personModel = PersonModel.builder()
            .firstName(EmployeeTestConstant.nombre)
            .lastNameFather(EmployeeTestConstant.apellidoPaterno)
            .lastNameMother(EmployeeTestConstant.apellidoMaterno)
            .sex(EmployeeTestConstant.sexo)
            .build();

    DetailModel detailModel = new DetailModel(
            EmployeeTestConstant.cargo, EmployeeTestConstant.salario);

    return new EmployeeRequest(personModel, detailModel);
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
