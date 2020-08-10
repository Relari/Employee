package com.renzo.employee.controller;

import com.renzo.employee.business.model.api.request.EmployeeRequest;
import com.renzo.employee.business.model.api.response.PersonResponse;
import com.renzo.employee.business.model.dto.EmployeeDto;
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

/**
 * <b>Class:</b> EmployeeController.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */
@RestController
@RequestMapping(path = "/employees")
@Api(value = "Api Employee")
@AllArgsConstructor
public class EmployeeController {

  private EmployeeService employeeService;

  @GetMapping(path = "")
  @ApiOperation(value = "Listado de Empleados", notes = "Retorna todos los Empleados",
      produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorna todos los Empleados")})
  public Observable<PersonResponse> listOfEmployees() {
    return this.employeeService.findAll()
            .map(this::buildPersonResponse);
  }

  @GetMapping(path = "/{id}")
  public Single<PersonResponse> findEmployeeById(@PathVariable("id") Integer id) {
    return employeeService.findById(id)
            .map(this::buildPersonResponse);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = "")
  public Completable saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
    return Single.fromCallable(() -> buildEmployeeDto(employeeRequest))
            .flatMapCompletable(employeeService::saveEmployee);
  }

  private EmployeeDto buildEmployeeDto(EmployeeRequest employeeRequest) {
    return EmployeeDto.builder()
            .nombre(employeeRequest.getPerson().getNombre())
            .apellidoPaterno(employeeRequest.getPerson().getApellidoPaterno())
            .apellidoMaterno(employeeRequest.getPerson().getApellidoMaterno())
            .sexo(employeeRequest.getPerson().getSexo())
            .cargo(employeeRequest.getDetail().getCargo())
            .sueldo(employeeRequest.getDetail().getSalario())
            .build();
  }
  private PersonResponse buildPersonResponse(EmployeeDto employeeDto) {
    return PersonResponse.builder()
            .nombre(employeeDto.getNombre())
            .apellidoPaterno(employeeDto.getApellidoPaterno())
            .apellidoMaterno(employeeDto.getApellidoMaterno())
            .sexo(employeeDto.getSexo())
            .build();
  }
}
