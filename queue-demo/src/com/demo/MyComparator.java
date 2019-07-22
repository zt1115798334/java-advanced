package com.demo;

import com.demo.domain.Book;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2019/7/19 17:49
 * description:
 */
public class MyComparator implements Comparator<Book> {


    @Override
    public int compare(Book b1, Book b2) {
        System.out.println(b1 + " comparator " + b2);
        if (b1.getPrice() > b2.getPrice()) {
            return 1;
        }
        if (b1.getPrice() < b2.getPrice()) {
            return -1;
        }
        return b1.getName().compareTo(b2.getName());
    }
}
