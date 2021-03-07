package com.pe.relari.employee.business.model.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class EmployeeRequest {

  @Valid
  @NotNull
  private PersonModel person;

  @Valid
  @NotNull
  private DetailModel detail;

}
