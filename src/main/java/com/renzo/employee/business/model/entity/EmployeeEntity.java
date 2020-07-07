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
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;

  @Column(name = "apellidoPaterno", length = 50, nullable = false)
  private String apellidoPaterno;

  @Column(name = "apellidoMaterno", length = 50, nullable = false)
  private String apellidoMaterno;

  @Column(name = "nombre", length = 50, nullable = false)
  private String nombre;

  @Column(name = "cargo", length = 50, nullable = false)
  private String cargo;

  @Column(name = "sexo", length = 1, nullable = false)
  private String sexo;

  @Column(name = "sueldo", nullable = false)
  private Double sueldo;

  @Column(name = "isActive", nullable = false)
  private Boolean isActive;
}
