package com.seanco.porpoise.controller;

import com.seanco.porpoise.entity.Employee;
import com.seanco.porpoise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// "http://localhost:8080/api/employee"
// "http://localhost:8080/api/employee/5"

@RestController
@RequestMapping("api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employee")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("employee/{employeeId}")
    public Employee findById(
            @PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.updateOrInsert(employee);
        return employee;
    }

    @PutMapping("employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.updateOrInsert(employee);
        return employee;
    }

    @DeleteMapping("employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteById(employeeId);
        return "delete success";
    }
}
