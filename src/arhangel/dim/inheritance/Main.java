package arhangel.dim.inheritance;

import java.util.Arrays;

/**
 * Created on 18/08/14.
 */
public class Main {

    public static void main(String[] args) {

        Employee employee = new Employee("John", 3000);
        employee.printInfo();

        Manager tom = new Manager("Tom", 10000, Department.IT);
        tom.printInfo();

        System.out.println(tom.toString());



        Employee tmp = tom;

        if (employee instanceof  Manager) {
            System.out.println("Is mgr");
        }

        if (tmp instanceof Employee) {
            System.out.println("Is employee");
        }
        if (tmp instanceof Manager) {
            System.out.println("Is manager");
        }
        if (tmp instanceof Object) {
            System.out.println("Is object");
        }

        System.out.println("Polimorf: ");
        tmp.printInfo();



        System.out.println("\n\n------------\n");


        Employee[] employees = new Employee[5];
        employees[0] = tom;
        employees[1] = new Manager("John", 12000, Department.HUMAN_RESOURCES);
        employees[2] = new Employee("Anna", 5000);
        employees[3] = new Employee("Mike", 4000);
        employees[4] = new Employee("Andy", 6000);

        for (int i = 0; i < 5; i++) {
            employees[i].printInfo();
        }



        //tmp.getDepartment(); // error
        tmp.printInfo(); // called from Manager



    }

    static void intToHex(int n) {
        char[] output = new char[8];
        for (int i = 0; i < 8; i++) {
            int tmp = (n >> (i * 4)) & 0xf;
            if (tmp < 10) {
                output[7 - i] = (char) ('0' + tmp);
            } else {
                output[7 - i] = (char) ('a' - 10 + tmp);
            }
        }
        System.out.println(Arrays.toString(output));
    }


    static void printCoord() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.print("one\ntwo\ntree");


    }

}
