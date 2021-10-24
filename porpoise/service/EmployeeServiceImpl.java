package com.seanco.porpoise.service;

import com.seanco.porpoise.dao.EmployeeDAO;
import com.seanco.porpoise.dao.EmployeeRepository;
import com.seanco.porpoise.entity.Employee;
import com.seanco.porpoise.util.SortParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateOrInsert(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> search(String keyword) {
        return employeeRepository.findDistinctEmployeeByFirstNameOrLastName(keyword, keyword);
    }

    @Override
    public List<Employee> findAllSortBy(int sort) {
        switch (sort) {
            case SortParams.FIRST_NAME:
                return  employeeRepository.findAllByOrderByFirstName();

            case SortParams.LAST_NAME:
                return  employeeRepository.findAllByOrderByLastName();
            case SortParams.EMAIL:
                return  employeeRepository.findAllByOrderByEmail();

        }
        return null;
    }
}
