package com.renzo.employee.business.model.api.request;

import static com.renzo.employee.business.model.api.request.EmployeeConstant.ONLY_LETTERS;
import static com.renzo.employee.business.model.api.request.EmployeeConstant.REGEXP_SEX;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * <b>Class:</b> EmployeePerson.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */


@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePerson {

  @NotBlank
  @Pattern(regexp = ONLY_LETTERS)
  @ApiModelProperty(
          name = "nombre",
          dataType = "String",
          example = "Daniel",
          required = true
  )
  private String nombre;

  @NotBlank
  @Pattern(regexp = ONLY_LETTERS)
  @ApiModelProperty(
          name = "apellidoPaterno",
          dataType = "String",
          example = "Gonzales",
          required = true
  )
  private String apellidoPaterno;

  @NotBlank
  @Pattern(regexp = ONLY_LETTERS)
  @ApiModelProperty(
          name = "apellidoMaterno",
          dataType = "String",
          example = "Perez",
          required = true
  )
  private String apellidoMaterno;

  @NotBlank
  @Pattern(regexp = REGEXP_SEX)
  @ApiModelProperty(
          name = "sexo",
          dataType = "String",
          example = "M",
          required = true
  )
  private String sexo;

}
