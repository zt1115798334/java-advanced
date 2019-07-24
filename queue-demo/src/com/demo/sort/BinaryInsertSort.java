package com.demo.sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2019/7/24 13:46
 * description: 二分法插入排序
 */
public class BinaryInsertSort {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }
}
