package com.renzo.employee.business.model.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <b>Class:</b> Detail.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Detail {

  private String cargo;

  private Double salario;
}
