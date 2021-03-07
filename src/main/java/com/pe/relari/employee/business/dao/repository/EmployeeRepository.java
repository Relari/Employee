package com.pe.relari.employee.business.dao.repository;

import com.pe.relari.employee.business.model.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <b>Interface:</b> EmployeeRepository.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
