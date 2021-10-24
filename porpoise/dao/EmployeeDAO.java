package com.seanco.porpoise.dao;

import com.seanco.porpoise.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    void updateOrInsert(Employee employee);

    void deleteById(int id);


}
