package sda.workers;

/**
 * Created by RENT on 2017-02-18.
 */
public class AbstrackEmployee {
    protected String firstName;
    protected String lastName;
    protected double salary;
    protected String departament;

    public AbstrackEmployee(String firstName, String lastName, double salary, String departament) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departament = departament;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartament() {
        return departament;
    }

    @Override
    public String toString() {
        return "AbstrackEmployee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", departament='" + departament + '\'' +
                '}';
    }
}
