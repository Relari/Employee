package com.renzo.employee.controller;

import com.renzo.employee.business.model.api.request.EmployeeRequest;
import com.renzo.employee.business.model.api.response.PersonResponse;
import com.renzo.employee.business.model.business.Employee;
import com.renzo.employee.business.service.EmployeeService;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <b>Class:</b> EmployeeController.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */
@RestController
@RequestMapping(path = "/employees")
@Api(value = "Api Employee")
@AllArgsConstructor
class EmployeeController {

  private final EmployeeService employeeService;

  @ApiOperation(
          value = "Listado de Empleados",
          notes = "Retorna todos los Empleados",
          produces = "application/json")
  @ApiResponses(value = {
          @ApiResponse(
                  code = 200,
                  message = "Retorna todos los Empleados")})
  @GetMapping
  public Observable<PersonResponse> listOfEmployees() {
    return this.employeeService.findAll()
            .map(this::mapPersonResponse);
  }

  @GetMapping(path = "/{id}")
  public Single<PersonResponse> findEmployeeById(@PathVariable("id") Integer id) {
    return employeeService.findById(id)
            .map(this::mapPersonResponse);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Completable save(@RequestBody @Valid EmployeeRequest employeeRequest) {
    return Single.fromCallable(() -> mapEmployee(employeeRequest))
            .flatMapCompletable(employeeService::save);
  }

  private Employee mapEmployee(EmployeeRequest employeeRequest) {
    return Employee.builder()
            .firstName(employeeRequest.getPerson().getFirstName())
            .lastNameFather(employeeRequest.getPerson().getLastNameFather())
            .lastNameMother(employeeRequest.getPerson().getLastNameMother())
            .sex(employeeRequest.getPerson().getSex())
            .position(employeeRequest.getDetail().getPosition())
            .salary(employeeRequest.getDetail().getSalary())
            .isActive(Boolean.TRUE)
            .build();
  }
  private PersonResponse mapPersonResponse(Employee employee) {
    return PersonResponse.builder()
            .firstName(employee.getFirstName())
            .lastNameFather(employee.getLastNameFather())
            .lastNameMother(employee.getLastNameMother())
            .sex(employee.getSex())
            .build();
  }
}
