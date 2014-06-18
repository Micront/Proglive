package arhangel.dim.webinar;

/**
 *
 */
public class Inheritance {

    static class Employee {
        protected String name;
        protected float salary;

        Employee() {}

        Employee(String name, float salary) {
            this.name = name;
            this.salary = salary;
        }

        public void fire() {
            System.out.println("You are fired!");
        }
    }

    static class Manager extends Employee {
        protected float annualBonus;

        Manager(String name, float salary, float annualBonus) {
            super(name, salary);
            this.annualBonus = annualBonus;
        }
    }
}
