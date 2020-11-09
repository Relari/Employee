package com.renzo.employee.business.model.business;

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
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String nombre;
  private String cargo;
  private String sexo;
  private Double sueldo;
  private Boolean isActive;
}
