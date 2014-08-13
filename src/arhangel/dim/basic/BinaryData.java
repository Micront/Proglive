package arhangel.dim.basic;

import java.util.Arrays;
import java.util.Random;

public class BinaryData {


    static void print(String str) {
        System.out.println("String: " + str);
    }

    static void print(int a) {
        System.out.println("Int: " + a);
    }

    static void print(int a, boolean b) {
        System.out.println("2 args");
    }

    public static void main(String[] args) {

        System.out.println(intToIp(1));


    }

    static String intToIp(int ip) {
        int[] add = new int[4];
        add[0] = (ip >> 24) & 0xff;
        return Arrays.toString(add);
    }

    static int max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;

    }


    static void func(int a) {
        System.out.println("a=" + a);
        a = 10;
        System.out.println("a=" + a); // 2
    }

    static void printAbc() {
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            System.out.println((char) (a + i));
        }
    }

    static void references(Box box) {
        box = new Box();
        box.a = 2;
    }

}

class Box {
    int a;
}
