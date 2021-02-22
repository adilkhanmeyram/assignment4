package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.entities.Job;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepository;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IJobRepository;

import java.util.List;

public class EmployeeController {
    private final IEmployeeRepository employeeRepository;
    private final IJobRepository jobRepository;

    public EmployeeController(IEmployeeRepository employeeRepository, IJobRepository jobRepository ) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    public String createEmployee(String firstName, String lastname, int job_id) {
        Employee employee = new Employee(firstName, lastname, job_id);

        boolean created = false==employeeRepository.createEmployee(employee);

        return (created ? "Employee was created!" : "Employee creation was failed!");
    }

    public String getEmployee(int id) {
        Employee employee = employeeRepository.getEmployee(id);

        return (employee == null ? "Employee was not found!" : employee.toString());
    }

    public String getAllEmployees() {
        List<Employee> employees = employeeRepository.getAllEmployees();

        return employees.toString();
    }

    public String fireEmployee(String first_name, String last_name) {
        Employee employee = new Employee(first_name, last_name);
        boolean fired = false==employeeRepository.fireEmployee(employee);

        return (fired ? "Employee has been fired!" : "Employee firing was failed!");
    }

    public Job getJob(int id) {
        Job job = jobRepository.getJob(id);

        return job;
    }

//    public String employeeInformation(int id) {
//        return employeeRepository.getEmployee(id).getFirstName() + " " +
//                employeeRepository.getEmployee(id).getLastName() + ", " + "work as" +
//    }
}
