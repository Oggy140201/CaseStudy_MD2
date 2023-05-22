package model.CR;

import model.CC.Employee;

public class PartTimeStaff extends Employee {
    public int workingHouse;

    public PartTimeStaff() {

    }

    public PartTimeStaff(String name, int age, String address, int id, double salary, int workingHouse) {
        super(name, age, address, id, salary);
        this.workingHouse = workingHouse;
    }

    public PartTimeStaff(int workingHouse) {
        this.workingHouse = workingHouse;
    }

    public int getWorkingHouse() {
        return workingHouse;
    }

    public void setWorkingHouse(int workingHouse) {
        this.workingHouse = workingHouse;
    }

    @Override
    public String toString() {
        return
                        "Name: " + name + "\t" +
                        "Age: " + age + "\t" +
                        "AddRess: " + address + "\t" +
                        "ID: " + id + "\t" +
                        "Salary: " + salary + "\t" +
                        "WorkingHouse: " + workingHouse + "\n"
                ;
    }

    @Override
    public double payrollCalculation() {
        return 0;
    }
}
