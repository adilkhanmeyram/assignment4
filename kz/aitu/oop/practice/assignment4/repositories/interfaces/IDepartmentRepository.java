package kz.aitu.oop.practice.assignment4.repositories.interfaces;

import kz.aitu.oop.practice.assignment4.entities.Department;

import java.util.List;

public interface IDepartmentRepository {
    boolean createDepartment(Department department);
    Department getDepartment(int id);
    List<Department> getAllDepartments();
}
