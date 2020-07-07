package com.renzo.employee.config;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * <b>Class:</b> ApplicationProperties.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */
@Getter
@Setter
@Lazy
@Configuration
@ConfigurationProperties(prefix = "application.error.backend")
public class ApplicationProperties {

  private String createEmployee;

  private String updateEmployee;

  private String getEmployee;
}
