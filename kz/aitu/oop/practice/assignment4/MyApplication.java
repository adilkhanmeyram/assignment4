package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.controllers.DepartmentController;
import kz.aitu.oop.practice.assignment4.controllers.EmployeeController;
import kz.aitu.oop.practice.assignment4.controllers.JobController;
import kz.aitu.oop.practice.assignment4.entities.Department;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IDepartmentRepository;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepository;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IJobRepository;

import java.util.List;
import java.util.Scanner;

public class MyApplication {
    private final DepartmentController departmentController;
    private final JobController jobController;
    private final EmployeeController employeeController;
    private final Scanner scanner;

    public MyApplication(IDepartmentRepository departmentRepository, IJobRepository jobRepository,
                         IEmployeeRepository employeeRepository) {
        departmentController = new DepartmentController(departmentRepository);
        jobController = new JobController(jobRepository, departmentRepository);
        employeeController = new EmployeeController(employeeRepository, jobRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to my application!");
            System.out.println("Select option");
            System.out.println("1. Employees");
            System.out.println("2. Jobs");
            System.out.println("3. Departments");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    employeeMenu();
                } else if (option == 2) {
                    jobMenu();
                } else if (option == 3) {
                    departmentMenu();
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }

            System.out.println("***********************************");
        }
    }

    public void employeeMenu () {
        while (true) {
            System.out.println();
            System.out.println("Select option");
            System.out.println("1. Get employee by id");
            //System.out.println("2. Get all employees");
            System.out.println("3. New employee");
            System.out.println("4. Fire employee");
            System.out.println("5. Main menu");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter option (1-5): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getEmployeeById();
                } else if (option == 2) {
                    getAllEmployees();
                } else if (option == 3) {
                    createEmployee();
                } else if(option == 4) {
                    fireEmployee();
                } else if(option==5) {
                    start();
                }
                else {
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }

            System.out.println("***********************************");
        }
    }

    public void jobMenu () {
        while (true) {
            System.out.println();
            System.out.println("Select option");
            System.out.println("1. Get job by id");
            System.out.println("2. Get all jobs");
            System.out.println("3. Create job");
            System.out.println("4. Main menu");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getJobById();
                } else if (option == 2) {
                    getAllJobs();
                } else if (option == 3) {
                    createJob();
                } else if(option==4) {
                    start();
                }
                else {
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }

            System.out.println("***********************************");
        }
    }

    public void departmentMenu () {
        while (true) {
            System.out.println();
            System.out.println("Select option");
            System.out.println("1. Get department by id");
            System.out.println("2. Get all departments");
            System.out.println("3. Create department");
            System.out.println("4. Main menu");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getDepartmentById();
                } else if (option == 2) {
                    getAllDepartments();
                } else if(option==3) {
                    createDepartment();
                }
                else if(option==4) {
                    start();
                }
                else {
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }

            System.out.println("***********************************");
        }
    }

    public void createDepartment() {
        System.out.println("Please enter name");
        String name = scanner.next();
        name += scanner.nextLine();

        String response = departmentController.createDepartment(name);
        System.out.println(response);
    }

    public void getDepartmentById() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = departmentController.getDepartment(id);
        System.out.println(response);
    }

    public void getAllDepartments() {
        String response = departmentController.getAllDepartments();
        System.out.println(response);
    }

    public void getJobById() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = jobController.getJob(id);
        System.out.println(response);
    }

    public void createJob() {
        System.out.println("Please enter department_id");
        Integer department_id = Integer.parseInt(scanner.next());

        try{
            var id = jobController.getDepartment(department_id).getId();
        }
        catch (Exception ex){
            return;
        }

        System.out.println("Please enter name");
        String name = scanner.next();

        System.out.println("Enter salary");
        int fixed_salary = scanner.nextInt();

        String response = jobController.createJob(name, fixed_salary, department_id);
        System.out.println(response);
    }

    public void getAllJobs() {
        String response = jobController.getAllJobs();
        System.out.println(response);
    }

    public void getEmployeeById() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = employeeController.getEmployee(id);
        System.out.println();
        System.out.println(response);
        System.out.println();

    }

    public void getAllEmployees() {
        String response = employeeController.getAllEmployees();
        System.out.println(response);
    }

    public void createEmployee() {
        System.out.println("Please enter job_id");
        Integer job_id = Integer.parseInt(scanner.next());
        try{
            var id = employeeController.getJob(job_id).getId();
        }
        catch (Exception ex){
            return;
        }

        System.out.println("Please enter first name");
        String first_name = scanner.next();
        System.out.println("Please enter last name");
        String last_name = scanner.next();

        String response = employeeController.createEmployee(first_name, last_name, job_id);
        System.out.println(response);
    }

    public void fireEmployee() {
        System.out.println("Please enter name of the worker you want to fire");
        System.out.println("Please enter first name");
        String first_name = scanner.next();
        System.out.println("Please enter last name");
        String last_name = scanner.next();

        String response = employeeController.fireEmployee(first_name, last_name);
        System.out.println(response);

    }



}
