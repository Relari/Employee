package com.renzo.employee.business.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <b>Class:</b> EmployeeEntity.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Entity
@Table(name = "EMPLOYEE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class EmployeeEntity {

  @Id
//  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL
  private Integer id;

  @Column(name = "lastNameFather", length = 50, nullable = false)
  private String lastNameFather;

  @Column(name = "lastNameMother", length = 50, nullable = false)
  private String lastNameMother;

  @Column(name = "firstName", length = 50, nullable = false)
  private String firstName;

  @Column(name = "position", length = 50, nullable = false)
  private String position;

  @Column(name = "sex", length = 1, nullable = false)
  private String sex;

  @Column(name = "salary", nullable = false)
  private Double salary;

  @Column(name = "isActive", nullable = false)
  private Boolean isActive;
}
