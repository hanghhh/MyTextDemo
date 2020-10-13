package code.algorithm;

import java.util.Arrays;

public class MergerSorted {
    public static void main(String[] args) {
        int[] arr = {1,45,12,78,101,36,58,49,47};
        int[] merger = mergerSort(arr);
        System.out.println(Arrays.toString(merger));
        //数组过大或者数组内部无须得错误示范
        int[] left = {1,3};
        int[] right = {2,4,5,9,7};
        int[] merger1 = merger(left, right);
        System.out.println(Arrays.toString(merger1));
    }

    /**
     * 归并排序
     */
    //
    public static int[] mergerSort(int[] arr) {
        if(arr.length<2) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merger(mergerSort(left), mergerSort(right));
    }

    //将两个合并好的数组，合并成一个数组
    public static int[] merger(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        //index res得下表   i left下表   j right下表
        for (int index = 0, i=0, j=0; index < res.length; index++) {

            if(i >= left.length) {          //left是否已经全部装入res
                res[index] = right[j];
                j++;
            }else if(j >= right.length) { //right是否已经全部装土res
                res[index] = left[i];
                i++;
            }else if(left[i] > right[j]) { //决定大小顺序   //一个循环的开始，会先以此判断left和right第一个数值大小，装入res，依次向后直到两个结果都走到各自长度
                res[index] = right[j];                      //left和right从0开始依次比较大小放入res，然后从哪个数组取值，那个数组下标加一去寻找下一个值和另一个数组第一个值比较，交替执行当前过程
                j++;                                        //知道某个数组全部放入。另一个数组剩下得值一定大于当前数组所有值，保证数组够小是关键。
            } else {
                res[index] = left[i];
                i++;
            }
        }
        return res;

    }
}
