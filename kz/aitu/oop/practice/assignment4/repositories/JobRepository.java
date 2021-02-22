package kz.aitu.oop.practice.assignment4.repositories;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.entities.Job;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IJobRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobRepository implements IJobRepository {
    private final IDB db;

    public JobRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createJob(Job job) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Jobs(name, fixed_salary, department_id) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, job.getName());
            st.setInt(2, job.getFixed_salary());
            st.setInt(3, job.getDepartment_id());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Job getJob(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, fixed_salary, department_id FROM jobs WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Job job = new Job(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("fixed_salary"),
                        rs.getInt("department_id"));

                return job;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Job> getAllJobs() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, fixed_salary, department_id FROM Jobs";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Job> jobs = new ArrayList<>();
            while (rs.next()) {
                Job job = new Job(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("fixed_salary"),
                        rs.getInt("department_id"));

                jobs.add(job);
            }

            return jobs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
