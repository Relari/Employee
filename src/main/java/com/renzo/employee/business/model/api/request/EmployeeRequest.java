package com.renzo.employee.business.model.api.request;

import com.renzo.employee.business.model.api.domain.Detail;
import com.renzo.employee.business.model.api.domain.Person;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <b>Class:</b> EmployeeRequest.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class EmployeeRequest {

  @Valid
  private Person person;

  @Valid
  private Detail detail;

}