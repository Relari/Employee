package com.renzo.employee.config.exception;

import lombok.Getter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <b>Class:</b> EmployeeException.</br>
 * <b>Response:</b> Mensaje de Error.</br>
 * <ul>
 *     <li><b>Code:</b> 500.</li>
 *     <li><b>Type:</b> Internal Server.</li>
 * </ul>
 * @see java.lang.Exception
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Getter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private String message;

  public EmployeeException(String message, Throwable throwable) {
    super(throwable);
    this.message = message;
  }
  
}
