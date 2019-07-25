package com.demo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2019/7/24 18:27
 * description:
 */
public class BitMapDemo {

    private static final int _1MB = 1024 * 1024;

    private static byte[] flags = new byte[512 * _1MB];

    public static void main(String[] args) {
        //待判重数据
//        int[] array = {255, 1024, 0, 65536, 255};
//        int index = 0;
//        for (int num : array) {
//            if (!getFlags(num)) {
//                //未出现的元素
//                array[index] = num;
//                index = index + 1;
//                //设置标志位
//                setFlags(num);
//                System.out.println("set " + num);
//            } else {
//                System.out.println(num + " already exist");
//            }
//        }
//        setFlags(255);
        int x = 255 & 7;
        System.out.println("x = " + x);
    }

    private static void setFlags(int num) {

        flags[num >> 3] |= 0x01 << (num & (0x07));
    }

    private static boolean getFlags(int num) {
        return (flags[num >> 3] >> (num & (0x07)) & 0x01) == 0x01;
    }
}
