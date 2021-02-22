package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Department;
import kz.aitu.oop.practice.assignment4.entities.Job;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IDepartmentRepository;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IJobRepository;

import java.util.List;

public class JobController {
    private final IJobRepository jobRepository;
    private final IDepartmentRepository departmentRepository;

    public JobController(IJobRepository jobRepository, IDepartmentRepository departmentRepository) {
        this.jobRepository = jobRepository;
        this.departmentRepository = departmentRepository;
    }

    public String createJob(String name, int fixed_salary, int department_id) {
        Job job = new Job(name, fixed_salary, department_id);

        boolean created = false==jobRepository.createJob(job);

        return (created ? "Job was created!" : "Job creation was failed!");
    }

    public String getJob(int id) {
        Job job = jobRepository.getJob(id);

        return (job == null ? "Job was not found!" : job.toString());
    }

    public String getAllJobs() {
        List<Job> Jobs = jobRepository.getAllJobs();

        return Jobs.toString();
    }

    public Department getDepartment(int id) {
        Department department = departmentRepository.getDepartment(id);

        return department;
    }
}
