package com.seanco.porpoise.dao;

import com.seanco.porpoise.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Employee.class, id);
    }

    @Override
    public void updateOrInsert(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = findById(id);
        session.delete(employee);
    }
}
