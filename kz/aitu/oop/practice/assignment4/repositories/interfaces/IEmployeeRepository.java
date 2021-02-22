package kz.aitu.oop.practice.assignment4.repositories.interfaces;

import kz.aitu.oop.practice.assignment4.entities.Employee;

import java.util.List;

public interface IEmployeeRepository {
    boolean createEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmployees();

    boolean fireEmployee(Employee employee);
}
