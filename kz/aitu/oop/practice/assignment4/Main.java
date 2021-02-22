package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.data.PostgresDB;
import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.repositories.DepartmentRepository;
import kz.aitu.oop.practice.assignment4.repositories.EmployeeRepository;
import kz.aitu.oop.practice.assignment4.repositories.JobRepository;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IDepartmentRepository;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepository;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IJobRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IDepartmentRepository departmentRepository =new DepartmentRepository(db);
        IJobRepository jobRepository = new JobRepository(db);
        IEmployeeRepository employeeRepository = new EmployeeRepository(db);
        MyApplication app = new MyApplication(departmentRepository, jobRepository, employeeRepository);
        app.start();
    }
}
