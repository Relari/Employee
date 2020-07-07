package com.renzo.employee.business.model.api.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <b>Class:</b> PersonResponse.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@ApiModel("Employee")
public class PersonResponse {

  @NotBlank
  @Size(max = 50)
  @ApiModelProperty(value = "Nombre del Empleado", example = "Ricardo", required = true,
      dataType = "String", position = 1)
  private String nombre;

  @NotBlank
  @Size(max = 50)
  @ApiModelProperty(value = "Apellido Paterno del Empleado", example = "Lozano", required = true,
      dataType = "String", position = 2)
  private String apellidoPaterno;

  @NotBlank
  @Size(max = 50)
  @ApiModelProperty(value = "Apellido Materno del Empleado", example = "Lozano", required = true,
      dataType = "String", position = 3)
  private String apellidoMaterno;

  @NotBlank
  @Size(max = 1)
  @ApiModelProperty(value = "Sexo del Empleado", example = "M", required = true,
      dataType = "String", position = 4)
  private String sexo;

}
