package com.demo;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.HashSet;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2019/7/25 13:37
 * description:
 */
public class BloomFilterDemo {
    static int sizeOfNumberSet = Integer.MAX_VALUE >> 8;
//    static int sizeOfNumberSet = 217727;

    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("sizeOfNumberSet = " + sizeOfNumberSet);
        int error = 0;
        HashSet<Integer> set = new HashSet<>();
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), sizeOfNumberSet);
        for (int i = 0; i < sizeOfNumberSet; i++) {
            int r = random.nextInt();
            if (set.contains(r) && bloomFilter.mightContain(r)) {
                error++;
            }
            set.add(i);
            bloomFilter.put(i);
        }
        System.out.println("Error count: " + error + ", error rate = " + String.format("%f", (float) error / (float) sizeOfNumberSet));
    }
}
