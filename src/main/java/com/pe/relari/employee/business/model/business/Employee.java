package com.pe.relari.employee.business.model.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <b>Class:</b> EmployeeDto.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class Employee {

  private Integer idEmployee;
  private String lastNameFather;
  private String lastNameMother;
  private String firstName;
  private String position;
  private String sex;
  private Double salary;
  private Boolean isActive;
}
