package com.renzo.employee.business.model.api.request;

import com.renzo.employee.business.model.api.request.constant.EmployeeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * <b>Class:</b> EmployeePerson.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class EmployeePerson {

  @NotBlank
  @Pattern(regexp = EmployeeConstant.onlyLettersWithSpace)
  @ApiModelProperty(
          name = "nombre",
          dataType = "String",
          example = "Daniel",
          required = true
  )
  private String nombre;

  @NotBlank
  @Pattern(regexp = EmployeeConstant.onlyLettersWithSpace)
  @ApiModelProperty(
          name = "apellidoPaterno",
          dataType = "String",
          example = "Gonzales",
          required = true
  )
  private String apellidoPaterno;

  @NotBlank
  @Pattern(regexp = EmployeeConstant.onlyLettersWithSpace)
  @ApiModelProperty(
          name = "apellidoMaterno",
          dataType = "String",
          example = "Perez",
          required = true
  )
  private String apellidoMaterno;

  @NotBlank
  @Pattern(regexp = EmployeeConstant.regexpSex)
  @ApiModelProperty(
          name = "sexo",
          dataType = "String",
          example = "M",
          required = true
  )
  private String sexo;

}
