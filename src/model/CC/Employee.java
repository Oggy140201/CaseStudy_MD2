package model.CC;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    public String name;
    public int age;
    public String address;
    public int id;
    public double salary;

    public Employee(String name, int age, String address, int id, double salary) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.id = id;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract double payrollCalculation();
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", address='" + address + '\'' +
//                ", id=" + id +
//                ", salary=" + salary +
//                '}';
//    }
}
