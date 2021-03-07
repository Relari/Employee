package com.pe.relari.employee.business.model.api;

import static com.pe.relari.employee.business.model.api.EmployeeConstant.ONLY_LETTERS;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * <b>Class:</b> EmployeeDetail.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetail {

  @NotBlank
  @Pattern(regexp = ONLY_LETTERS)
  @Size(min = 1, max = 50)
  @ApiModelProperty(
          name = "position",
          dataType = "String",
          example = "Asistente",
          required = true
  )
  private String position;

  @NotNull
  @ApiModelProperty(
          name = "salary",
          dataType = "String",
          example = "1500",
          required = true
  )
  private Double salary;
}
