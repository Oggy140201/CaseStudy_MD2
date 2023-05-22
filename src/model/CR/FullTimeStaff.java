package model.CR;

import model.CC.Employee;

public class FullTimeStaff extends Employee {
    public int day;

    public FullTimeStaff(String name, int age, String address, int id, double salary, int day) {
        super(name, age, address, id, salary);
        this.day = day;
    }

    public FullTimeStaff() {
    }

    public FullTimeStaff(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return
                        "Name: " + name + "\t" +
                        "Age: " + age + "\t" +
                        "AddRess: " + address + "\t" +
                        "ID: " + id + "\t" +
                        "Salary: " + salary + "\t" +
                        "Day: " + day + "\n"
                ;
    }

    @Override
    public double payrollCalculation() {
        return salary*day;
    }
}
