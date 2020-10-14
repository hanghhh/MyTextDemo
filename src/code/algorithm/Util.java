package code.algorithm;

import java.util.Arrays;

public class Util {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getrandom(0,3));;

        }
    }

    public static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static int getrandom(int start,int end) {

        int num=(int) (Math.random()*(end-start+1)+start);
        return num;
    }


}
