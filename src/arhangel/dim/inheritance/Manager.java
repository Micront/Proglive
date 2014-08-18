package arhangel.dim.inheritance;

/**
 * Created on 18/08/14.
 */
public class Manager extends Employee {
    protected Department department;

    public Manager(String name, double salary, Department department) {
        super(name, salary);
        this.department = department;
    }


    @Override
    public void printInfo() {
        System.out.println("Manager of department: " + department.toString() + ", [name=" + name + ", salary=" + salary + "];");
    }


    @Override
    public String toString() {
        return "Manager to String";
    }



}
