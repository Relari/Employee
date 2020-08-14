package com.renzo.employee.business.model.api.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <b>Class:</b> EmployeeRequest.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Getter
@Setter
@ToString
public class EmployeeRequest {

  @Valid
  @NotNull
  private EmployeePerson person;

  @Valid
  @NotNull
  private EmployeeDetail detail;

}
