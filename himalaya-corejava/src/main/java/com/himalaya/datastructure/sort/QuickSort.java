package com.himalaya.datastructure.sort;

import java.util.Arrays;

/**
 * @author xuqu
 * @date 2020/5/27 13:57
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {1, 60, 3, 30, 10, -1, 999, 1, -100};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right ) {
        // 左下标
        int l = left;
        // 右下标
        int r = right;
        // 变量交换的临时变量
        int temp = 0;
        // 选取一个中轴
        int pivot = arr[(left+right)/2];
        System.out.println(pivot);
        // 当前循环的作用是选取一个数，将数组中小于等于这个数的数据挪到数组的左边，大于该数的挪到数组的右边
        while(l < r) {
            // 找到左边第一个比pivot大的数
            while(arr[l] < pivot) {
                l +=1;
            }
            // 找到右边第一个比pivot小的数
            while(arr[r] > pivot) {
                r -=1;
            }
            // 如果左下标和右下标相等，表示已将数组的数据按照pivot分成了左右两部分，且左边的部分所有数都比右边部分的所有数小
            if (l >= r) {
                break;
            }
            // 交换两个数
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            // 没有下面两行代码为什么会出现死循环？
            // 因为最前面的两个while循环寻找左边第一个大于中轴的数和右边第一个小于中轴的数据的时候，
            // 没有考虑过等于中轴的情况，所以这里要对左右两个值移动位置,不然就不会满足 if(l>=r) break; 的条件
            // l = 2    r = 3
            // [-100, -1, 1, 1, 3, 10, 999, 30, 60]
            // 如果左边当前下标的数等于pivot
            System.out.println(l + "  " +  pivot + "  " + r);
            System.out.println(Arrays.toString(arr));
            if(arr[l] == pivot) {
                r -=1;
            }
            // 如果右边当前下标的数等于pivot
            if(arr[r] == pivot) {
                l +=1;
            }
        }

        // 如果 左下标 等于右下标，则要对左下标加1，右下标减一, 如果没有下面语句，将会导致栈溢出
        if (l == r) {
            l++;
            r--;
        }

        //  递归调用左边部分，继续排序
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 递归调用右边部分，继续排序
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
