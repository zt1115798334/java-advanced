package com.demo;

import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2019/7/24 10:10
 * description:
 */
public class BitSetDemo {
    public static void main(String[] args) {

        int xiao = 10 << 1;
        System.out.println("xiao = " + xiao);
        int x = 10 >> 1;
        System.out.println("x = " + x);

        //用户指定初始大小
        BitSet bitSet1 = new BitSet(1);
        BitSet bitSet2 = new BitSet(1);
//        for (int i = 0; i < 65; i++) {
//            if ((i % 2) == 0) {
//                bitSet1.set(i);
//            }
//            if ((i % 5) != 0) {
//                bitSet2.set(i);
//            }
//        }
//
//        System.out.println("Initial pattern in bits1: ");
//        System.out.println(bitSet1);
//        System.out.println("Initial pattern in bits2: ");
//        System.out.println(bitSet2);

        //交集
//        bitSet2.and(bitSet1);
//        System.out.println("and " + bitSet2);

        //差集（差 的是bitSet2 中的集合）
//        bitSet2.andNot(bitSet1);
//        System.out.println("andNot " + bitSet2);

        //并集
//        bitSet2.or(bitSet1);
//        System.out.println("or " + bitSet2);

        //两个集合的差集
//        bitSet2.xor(bitSet1);
//        System.out.println("xor " + bitSet2);

        //返回此 BitSet 中设置为 true 的位数。
//        int cardinality = bitSet2.cardinality();
//        System.out.println("cardinality = " + cardinality);
//         将此 BitSet 中的所有位设置为 false。
//        bitSet2.clear();
//        System.out.println("bitSet2 = " + bitSet2);
        //将索引指定处的位设置为 false。
//        bitSet2.clear(2);
//        System.out.println("bitSet2 = " + bitSet2);
        //将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的位设置为 false。
//        bitSet2.clear(2,4);
//        System.out.println("bitSet2 = " + bitSet2);
        //  复制此 BitSet，生成一个与之相等的新 BitSet。
//        Object clone = bitSet2.clone();
//        System.out.println("clone = " + clone);
        //将此对象与指定的对象进行比较。
//        System.out.println("clone.equals(bitSet1) = " + clone.equals(bitSet1));
//        System.out.println("clone.equals(bitSet2) = " + clone.equals(bitSet2));

        // 将指定索引处的位设置为其当前值的补码。
//        bitSet2.flip(4);
//        System.out.println("bitSet2 = " + bitSet2);
        //将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的每个位设置为其当前值的补码。
//        bitSet2.flip(4,6);
//        System.out.println("bitSet2 = " + bitSet2);
//        boolean b = bitSet2.get(5);
//        System.out.println("b = " + b);
//        BitSet bitSet = bitSet2.get(0, 6);
//        System.out.println("bitSet = " + bitSet);
//        BitSet bitSet = new BitSet();
//        bitSet.set(5);
//        bitSet2.intersects(bitSet);
//        System.out.println("bitSet2 = " + bitSet2);
//
////        int size = bitSet.size();
////        System.out.println("size = " + size);
//        System.out.println("bitSet2.cardinality() = " + bitSet2.cardinality());
//        System.out.println("bitSet2 = " + bitSet2.size());
//
//        System.out.println("bitSet2.toByteArray() = " + bitSet2.toByteArray());
//        System.out.println("bitSet2.toLongArray() = " + bitSet2.toLongArray());
//
//        int xiao = 0>>6;
//        System.out.println("xiao = " + xiao);
    }
}
