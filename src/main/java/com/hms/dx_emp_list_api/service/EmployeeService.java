package com.hms.dx_emp_list_api.service;

import com.hms.dx_emp_list_api.dto.EmployeeRequest;
import com.hms.dx_emp_list_api.entity.EmployeeDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<EmployeeDetails> getAllEmployees();
    EmployeeDetails addEmployee(EmployeeRequest employeeDetails);
    EmployeeDetails getEmployeeById(Long empId);
    EmployeeDetails updateEmployee(Long empId, EmployeeRequest employeeRequest);

    ResponseEntity<Map<String, Boolean>> deleteById(Long id);
}
