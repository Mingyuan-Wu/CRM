package com.seanco.porpoise.service;

import com.seanco.porpoise.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    void updateOrInsert(Employee employee);

    void deleteById(int id);

    List<Employee> search(String keyword);

    List<Employee> findAllSortBy(int sort);
}
