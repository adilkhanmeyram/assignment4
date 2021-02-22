package kz.aitu.oop.practice.assignment4.entities;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int job_id;
    private String job_name;
    private int fixed_salary;
    private int department_id;
    private String department_name;

    public Employee() {};

    public Employee(String firstName, String lastName, int job_id) {
        setFirstName(firstName);
        setLastName(lastName);
        setJob_id(job_id);
    }

    public Employee(int id, String firstName, String lastName, int job_id) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setJob_id(job_id);
    }

    public Employee(String firstName, String lastName, String job_name, int fixed_salary, String department_name) {
        setFirstName(firstName);
        setLastName(lastName);
        setJob_name(job_name);
        setFixed_salary(fixed_salary);
        setDepartment_name(department_name);
    }

    public Employee(int id, String firstName, String lastName, String job_name, String department_name, int fixed_salary) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setJob_name(job_name);
        setFixed_salary(fixed_salary);
        setDepartment_name(department_name);
    }

    public Employee(String first_name, String last_name) {
        setFirstName(first_name);
        setLastName(last_name);
    }


    public int getId() {
        return id;
    }

    public int getJob_id() {
        return job_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public void setFixed_salary(int fixed_salary) {
        this.fixed_salary = fixed_salary;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getFixed_salary() {
        return fixed_salary;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public String getJob_name() {
        return job_name;
    }

    @Override
    public String toString() {
        return "name: " + getFirstName() + " " + getLastName() + "\n"+
                "job: " + getJob_name() + "\n" +
                "department: " + getDepartment_name() + "\n" +
                "salary: " + getFixed_salary();
    }
}
