package com.renzo.employee.business.model.api.domain;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <b>Class:</b> Person.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Person {

  @NotBlank
  private String nombre;

  @NotBlank
  private String apellidoPaterno;

  @NotBlank
  private String apellidoMaterno;

  @NotBlank
  private String sexo;
}
