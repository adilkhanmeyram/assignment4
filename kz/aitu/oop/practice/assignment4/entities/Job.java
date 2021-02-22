package kz.aitu.oop.practice.assignment4.entities;

public class Job {
    private int id;
    private String name;
    private int fixed_salary;
    private int department_id;
    private String department_name;

    public Job(String name, int fixed_salary, int department_id) {
        setName(name);
        setFixed_salary(fixed_salary);
        setDepartment_id(department_id);
    }

    public Job(int id, String name, int fixed_salary, int department_id) {
        setId(id);
        setName(name);
        setFixed_salary(fixed_salary);
        setDepartment_id(department_id);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public void setFixed_salary(int fixed_salary) {
        this.fixed_salary = fixed_salary;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public int getFixed_salary() {
        return fixed_salary;
    }

    @Override
    public String toString() {
        return "job id:" + getId() + ", name: " + getName() + ", fixed salary: " + getFixed_salary() + ", department id:" + getDepartment_id();
    }
}
