package com.pe.relari.employee.business.model.api;

import static com.pe.relari.employee.business.model.api.EmployeeConstant.ONLY_LETTERS;
import static com.pe.relari.employee.business.model.api.EmployeeConstant.REGEXP_SEX;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * <b>Class:</b> PersonModel.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */


@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel {

  @NotBlank
  @Pattern(regexp = ONLY_LETTERS)
  @Size(min = 1, max = 50)
  @ApiModelProperty(
          name = "nombre",
          dataType = "String",
          example = "Daniel",
          required = true
  )
  private String firstName;

  @NotBlank
  @Pattern(regexp = ONLY_LETTERS)
  @Size(min = 1, max = 50)
  @ApiModelProperty(
          name = "lastNameFather",
          dataType = "String",
          example = "Gonzales",
          required = true
  )
  private String lastNameFather;

  @NotBlank
  @Pattern(regexp = ONLY_LETTERS)
  @Size(min = 1, max = 50)
  @ApiModelProperty(
          name = "lastNameMother",
          dataType = "String",
          example = "Perez",
          required = true
  )
  private String lastNameMother;

  @NotBlank
  @Pattern(regexp = REGEXP_SEX)
  @ApiModelProperty(
          name = "sex",
          dataType = "String",
          example = "M",
          required = true
  )
  private String sex;

}
