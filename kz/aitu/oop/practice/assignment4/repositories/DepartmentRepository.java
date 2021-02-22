package kz.aitu.oop.practice.assignment4.repositories;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.entities.Department;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IDepartmentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository implements IDepartmentRepository {
    private final IDB db;

    public DepartmentRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createDepartment(Department department) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO departments(name) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, department.getName());

            boolean executed = false==st.execute();
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
    public Department getDepartment(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, department_name FROM departments WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Department department = new Department(rs.getInt("id"),
                        rs.getString("name"));

                return department;
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
    public List<Department> getAllDepartments() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, department_name FROM Departments";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Department> departments = new ArrayList<>();
            while (rs.next()) {
                Department department = new Department(rs.getInt("id"),
                        rs.getString("name"));

                departments.add(department);
            }

            return departments;
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


