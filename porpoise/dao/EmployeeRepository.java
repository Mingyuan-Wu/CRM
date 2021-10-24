package com.seanco.porpoise.dao;

import com.seanco.porpoise.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findDistinctEmployeeByFirstNameOrLastName(String firstName, String lastName);

    List<Employee> findAllByOrderByFirstName();

    List<Employee> findAllByOrderByLastName();

    List<Employee> findAllByOrderByEmail();
}
