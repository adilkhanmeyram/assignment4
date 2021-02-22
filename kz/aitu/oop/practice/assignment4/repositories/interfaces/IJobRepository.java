package kz.aitu.oop.practice.assignment4.repositories.interfaces;

import kz.aitu.oop.practice.assignment4.entities.Job;

import java.util.List;

public interface IJobRepository {
    boolean createJob(Job job);
    Job getJob(int id);
    List<Job> getAllJobs();
}
