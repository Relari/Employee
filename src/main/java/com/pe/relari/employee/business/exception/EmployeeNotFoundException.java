package com.pe.relari.employee.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <b>Class:</b> EmployeeNotFoundException.</br>
 * <b>Response:</b> Mensaje de Error. </br>
 * <ul>
 *     <li><b>Code:</b> 400.</li>
 *     <li><b>Type:</b> Not Found.</li>
 * </ul>
 * @see java.lang.Exception
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
class EmployeeNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EmployeeNotFoundException(String message) {
    super(message);
  }

  public EmployeeNotFoundException(String message, Throwable throwable) {
    super(message, throwable);
  }
  
}
