package com.renzo.employee.business.util;

import com.renzo.employee.business.model.api.domain.Detail;
import com.renzo.employee.business.model.api.domain.Person;
import com.renzo.employee.business.model.api.request.EmployeeRequest;
import com.renzo.employee.business.model.dto.EmployeeDto;
import com.renzo.employee.business.model.entity.EmployeeEntity;

public class EmployeeMapper {

  public EmployeeRequest employeeRequest() {
    return EmployeeRequest.builder()
        .person(person())
        .detail(detail())
        .build();
  }

  private Person person() {
    return Person.builder()
        .nombre("Renzo")
        .apellidoPaterno("Lavado")
        .apellidoMaterno("Rivas")
        .sexo("M")
        .build();
  }

  private Detail detail() {
    return Detail.builder()
        .cargo("Sistemas")
        .salario(2000.00)
        .build();
  }

  public EmployeeDto employeeDto() {
    return EmployeeDto.builder()
        .idEmployee(1)
        .nombre("Renzo")
        .apellidoPaterno("Lavado")
        .apellidoMaterno("Rivas")
        .sexo("M")
        .cargo("Sistemas")
        .sueldo(2000.00)
        .isActive(true)
        .build();
  }

  public EmployeeEntity employeeEntity() {
    return EmployeeEntity.builder()
        .id(1)
        .nombre("Renzo")
        .apellidoPaterno("Lavado")
        .apellidoMaterno("Rivas")
        .sexo("M")
        .cargo("Sistemas")
        .sueldo(2000.00)
        .isActive(true)
        .build();
  }
}
