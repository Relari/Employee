package com.renzo.employee.business.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * <b>Class:</b> ExceptionFactory.</br>
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionFactory {

  private static final String NOT_FOUND = "NOT_FOUND";

  private String message;
  private Throwable throwable;
  private ErrorCategory errorCategory;

  public RuntimeException getException() {
    if (NOT_FOUND.equals(errorCategory.name())) {
      if (throwableIsNull()) {
        return new EmployeeNotFoundException(message);
      } else {
        return new EmployeeNotFoundException(message, throwable);
      }
    } else {
      if (throwableIsNull()) {
        return new RuntimeException(message);
      } else {
        return new RuntimeException(message, throwable);
      }
    }
  }

  private boolean throwableIsNull() {
    return Objects.isNull(throwable);
  }

}
