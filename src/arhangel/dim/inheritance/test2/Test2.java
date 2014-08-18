package arhangel.dim.inheritance.test2;

import arhangel.dim.inheritance.test1.Test1;

/**
 * Created on 18/08/14.
 */
public class Test2 {

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        //t1.packageFunc(); // not allowed
        t1.publicFunc();
        //t1.privateAccess();
    }
}


