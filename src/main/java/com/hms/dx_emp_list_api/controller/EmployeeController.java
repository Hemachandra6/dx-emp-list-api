package com.hms.dx_emp_list_api.controller;

import com.hms.dx_emp_list_api.dto.EmployeeRequest;
import com.hms.dx_emp_list_api.entity.EmployeeDetails;
import com.hms.dx_emp_list_api.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDetails> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<EmployeeDetails> addEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeRequest));
    }

    @GetMapping("/{empId}")
    public  ResponseEntity<EmployeeDetails> getEmployeeById(@PathVariable Long empId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(empId));
    }

    @PatchMapping("/{empId}")
    public  ResponseEntity<EmployeeDetails> updateEmployee(@PathVariable Long empId, @RequestBody EmployeeRequest employeeRequest) {
        return ResponseEntity.ok(employeeService.updateEmployee(empId, employeeRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable Long id) {
         return employeeService.deleteById(id);
    }
}
