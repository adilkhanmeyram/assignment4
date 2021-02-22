package kz.aitu.oop.practice.assignment4.entities;

public class Department {
    private int id=0;
    private String name;

    public Department() {};

    public Department(String name) {
        setName(name);
    }

    public Department(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "department id: " + getId() + ", department name: " + getName() + " " + "\n";
    }
}
