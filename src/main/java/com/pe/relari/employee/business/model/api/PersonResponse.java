package com.pe.relari.employee.business.model.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <b>Class:</b> PersonResponse.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@ApiModel("Employee")
public class PersonResponse {

  @ApiModelProperty(
          value = "Nombre del Empleado",
          example = "Ricardo",
          dataType = "String",
          position = 1)
  private String firstName;

  @ApiModelProperty(
          value = "Apellido Paterno del Empleado",
          example = "Lozano",
          dataType = "String",
          position = 2)
  private String lastNameFather;

  @ApiModelProperty(
          value = "Apellido Materno del Empleado",
          example = "Lozano",
          dataType = "String",
          position = 3)
  private String lastNameMother;

  @ApiModelProperty(
          value = "Sexo del Empleado",
          example = "M",
          dataType = "String",
          position = 4)
  private String sex;

}
