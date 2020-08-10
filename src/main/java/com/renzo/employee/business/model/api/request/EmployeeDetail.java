package com.renzo.employee.business.model.api.request;

import com.renzo.employee.business.model.api.request.constant.EmployeeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <b>Class:</b> EmployeeDetail.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDetail {

  @NotBlank
  @Pattern(regexp = EmployeeConstant.onlyLettersWithSpace)
  @ApiModelProperty(
          name = "cargo",
          dataType = "String",
          example = "Asistente",
          required = true
  )
  private String cargo;

  @NotNull
  @ApiModelProperty(
          name = "salario",
          dataType = "String",
          example = "1500",
          required = true
  )
  private Double salario;
}
