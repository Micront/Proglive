package arhangel.dim.oop;

/**
 * Created on 13/08/14.
 */
public class Anonymous {

    static class A {
        protected int val;

        public A() {

        }

        public A(int val) {
            this.val = val;
        }

        public void print() {
            System.out.println("From A, val = " + val);
        }
    }

    static class B {
        void func(A a) {
            a.print();
        }
    }


    public static void main(String[] args) {
        B b = new B();

        b.func(new A() {
            @Override
            public void print() {
                System.out.println("Anonymous, val = " + val);
            }
        });

        b.func(new A(10) {
            @Override
            public void print() {
                System.out.println("Anonymous, val = " + val);
            }
        });
    }

}
