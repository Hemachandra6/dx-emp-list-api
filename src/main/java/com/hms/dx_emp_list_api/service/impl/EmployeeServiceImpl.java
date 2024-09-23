package com.hms.dx_emp_list_api.service.impl;

import com.hms.dx_emp_list_api.dto.EmployeeRequest;
import com.hms.dx_emp_list_api.entity.EmployeeDetails;
import com.hms.dx_emp_list_api.exception.ResourceNotFoundException;
import com.hms.dx_emp_list_api.repository.EmployeeRepository;
import com.hms.dx_emp_list_api.service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDetails> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDetails addEmployee(EmployeeRequest employeeRequest) {
        EmployeeDetails details = new EmployeeDetails();
        details.setFirstName(employeeRequest.getFirstName());
        details.setLastName(employeeRequest.getLastName());
        details.setEmail(employeeRequest.getEmail());
        details.setDepartment(employeeRequest.getDepartment());
        details.setPhoneNumber(employeeRequest.getPhoneNumber());
        return employeeRepository.save(details);
    }

    @Override
    public EmployeeDetails getEmployeeById(Long empId) {
        return employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not available with the provided id."));
    }

    @Override
    public EmployeeDetails updateEmployee(Long empId, EmployeeRequest employeeRequest) {
        EmployeeDetails existingEmployee = employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not available with the provided id."));
        if (employeeRequest.getFirstName() != null) {
            existingEmployee.setFirstName(employeeRequest.getFirstName());
        }
        if (employeeRequest.getLastName() != null) {
            existingEmployee.setLastName(employeeRequest.getLastName());
        }
        if (employeeRequest.getEmail() != null) {
            existingEmployee.setEmail(employeeRequest.getEmail());
        }
        if (employeeRequest.getDepartment() != null) {
            existingEmployee.setDepartment(employeeRequest.getDepartment());
        }
        if (employeeRequest.getPhoneNumber() != null) {
            existingEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
        }
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteById(Long id) {
        EmployeeDetails employeeDetails = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not available with the provided id."));
        employeeRepository.delete(employeeDetails);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
