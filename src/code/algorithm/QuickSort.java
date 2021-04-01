package code.algorithm;

import java.util.Arrays;

/**
 * 快速排序 分治法
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7,2,6,5,9,4};

        aaa(arr, 0, arr.length-1);



    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int leftBound, int rightBound){
        if(leftBound >= rightBound) return;
        int index = partiton(arr, leftBound, rightBound);
        sort(arr, leftBound, index-1);
        sort(arr, index+1, rightBound);
    }

    /**
     *
     *
     * @param arr 排序得数组
     * @param leftBound 数组左侧边界
     * @param rightBound 数组右侧边界
     * @return 排序完毕得数组
     * 确定一个pivot数字为轴，小于该值放左侧，大于该值放右侧，完成一次后，返回轴坐标。
     */
    public static int partiton(int[] arr, int leftBound, int rightBound) {
        //首先选取一个值为轴,选取了数组最右侧得值作为轴
        int privot = arr[rightBound];
        //左侧指针
        int left = leftBound;
        //右侧指针，因为初始轴位于数组末尾，指针位于数组得倒数第二位
        int right = rightBound-1;

        //指针向中间靠拢完成一次筛选
        while (left <= right) {
            //当左侧指针获取的数值小于轴，则不许移动，左侧指针向右侧移动
            while (left <= right && arr[left] <= privot) left++; //{2,3}
            //当右侧指针获取的值大于轴，则不需移动，右侧指针向左侧移动  不能同时带等号，否则会出现相同值左右两侧都会出现
            while (left <= right &&arr[right] > privot) right--;
            //当找到了左侧大于轴，右侧小于轴得值所在位置时，如果指针还未重合，则互换位置
            System.out.println("交换前left->" + left + " right" + right);
            if(left < right) {
                Util.swap(arr, left, right);
            }
        }
        Util.swap(arr, left, rightBound);
        return left;
    }

    //来自于王军伟，单指针移动
    public static int aaa(int[] arr, int start, int end) {
        int privot = 3;
        Util.swap(arr, privot, end);
        int index = -1;
        for (int i = start; i <= end ; i++) {
            if(arr[i] <= arr[end]) {
                index++;
                if(i > index) {
                    Util.swap(arr, i, index);
                }
            }
        }
        return index;
    }
}
