package arhangel.dim.abstr;

import java.util.Arrays;

/**
 * Created by dmirty on 01/09/14.
 */
public class Main {



    class Test {
        final int var = 10;

        public Test() {
            //var = 10;
        }
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        System.out.println("size: " + arr.length);


        String[] arr1 = new String[10];
        System.out.println(Arrays.toString(arr1));
        for (int i = 0; i < 10; i++) {
            arr1[i] = String.valueOf(i);
        }
        System.out.println(Arrays.toString(arr1));

        int[][] map = new int[10][10];


        int[][] map2 = {{0,0},
                        {1,1,1},
                        {0}};


        int[] row1 = map2[0];
        int[] row2 = map2[1];




    }



}
