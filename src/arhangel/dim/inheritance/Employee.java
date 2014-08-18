package arhangel.dim.inheritance;

/**
 * Created on 18/08/14.
 */
public class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void printInfo() {
        System.out.println("Employee: [name=" + name + ", salary=" + salary + "];");
    }
}
