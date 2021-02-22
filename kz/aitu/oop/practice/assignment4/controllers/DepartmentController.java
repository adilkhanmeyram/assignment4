package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Department;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IDepartmentRepository;

import java.util.List;

public class DepartmentController {
    private final IDepartmentRepository repo;

    public DepartmentController(IDepartmentRepository repo) {
        this.repo = repo;
    }

    public String createDepartment(String name) {
        Department department = new Department(name);

        boolean created = repo.createDepartment(department);

        return (created ? "Department was created!" : "Department creation was failed!");
    }

    public String getDepartment(int id) {
        Department department = repo.getDepartment(id);

        return (department == null ? "Department was not found!" : department.toString());
    }

    public String getAllDepartments() {
        List<Department> departments = repo.getAllDepartments();

        return departments.toString();
    }
}
