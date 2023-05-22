package model.CR;

import model.CC.Employee;

public class SecretarialStaff extends Employee {//nhân viên thư kí
    public int day;

    public SecretarialStaff(){

    }
    public SecretarialStaff(String name, int age, String address, int id, double salary, int day) {
        super(name, age, address, id, salary);
        this.day = day;
    }

    public SecretarialStaff(int day) {
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
