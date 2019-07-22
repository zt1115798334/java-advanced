package com.demo;

import com.demo.domain.Book;
import com.demo.domain.Person;

import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2019/7/19 17:43
 * description:
 */
public class SetDemo {
    public static void main(String[] args) {
//        TreeSet ts = new TreeSet();
//        ts.add(new Person("aa", 20));
//        ts.add(new Person("bb", 18));
//        ts.add(new Person("cc", 17));
//        ts.add(new Person("dd", 17));
//        ts.add(new Person("dd", 15));
//        ts.add(new Person("dd", 15));
//
//
//        System.out.println(ts);
//        System.out.println(ts.size()); // 5

        TreeSet<Book> ts = new TreeSet<>(new MyComparator());
        ts.add(new Book("think in java", 100));
        ts.add(new Book("java 核心技术", 75));
        ts.add(new Book("现代操作系统", 50));
        ts.add(new Book("java就业教程", 35));
        ts.add(new Book("think in java", 100));
        ts.add(new Book("ccc in java", 100));

        System.out.println(ts);

    }

}
