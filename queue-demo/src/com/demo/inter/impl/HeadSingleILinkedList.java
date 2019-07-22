package com.demo.inter.impl;

import com.demo.domain.Node;
import com.demo.inter.ILinkedList;

/**
 * Created by zejian on 2016/10/22. 带头结点并含有尾指针的链表
 */
public class HeadSingleILinkedList<T> implements ILinkedList<T> {

    private Node<T> headNode;
    private Node<T> rear;

    public HeadSingleILinkedList() {
//        this.headNode = this.rear = new Node<>(null);
        this.headNode = new Node<>(null);
        this.rear = new Node<>(null);
    }

    public HeadSingleILinkedList(Node<T> node) {
        this();
        this.headNode.next = rear.next = node;
        rear = rear.next;
    }

    public HeadSingleILinkedList(T[] arr) {
        this();
        if (arr != null && arr.length > 0) {
            System.out.println("this.headNode.hashCode() = " + this.headNode.hashCode());
            System.out.println("this.rear.hashCode() = " + this.rear.hashCode());
            this.headNode.next = new Node<>(arr[0]);
            rear = this.headNode.next;
            System.out.println("arr = " + rear.hashCode());
            int i = 1;
            while (i < arr.length) {
                rear.next = new Node<>(arr[i++]);
                rear = rear.next;
            }
        }
    }

    public HeadSingleILinkedList(HeadSingleILinkedList<T> list) {
        this();
        if (list != null && list.headNode.next != null) {
            this.headNode.next = new Node<>(list.headNode.data);
            Node<T> p = list.headNode.next;
            rear = this.headNode.next;
            while (p != null) {
                rear.next = new Node<>(p.data);
                rear = rear.next;
                p = p.next;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return headNode.next != null;
    }

    @Override
    public int length() {
        int length = 0;
        Node<T> currentNode = headNode.next;
        while (currentNode.data != null) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

    @Override
    public T get(int index) {
        if (index >= 0) {
            Node<T> pre = headNode.next;
            int j = 0;
            while (pre != null && j < index) {
                pre = pre.next;
                j++;
            }
            if (pre != null) {
                return pre.data;
            }
        }
        return null;
    }

    @Override
    public T set(int index, T data) {
        if (index >= 0 && data != null) {
            Node<T> pre = this.headNode.next;
            int j = 0;
            while (pre != null && j < index) {
                pre = pre.next;
                j++;
            }
            if (pre != null) {
                T old = pre.data;
                pre.data = data;
                return old;
            }
        }
        return null;
    }

    @Override
    public boolean add(int index, T data) {
        if (index >= 0 && data != null) {
            int j = 0;
            Node<T> pre = this.headNode;
            while (pre.next != null && j < index) {
                pre = pre.next;
                j++;
            }
            Node<T> q = new Node<>(data, pre.next);
            pre.next = q;
            if (pre == this.rear) {
                this.rear = q;
            }
        }
        return false;
    }

    @Override
    public boolean add(T data) {
        if (data != null) {
            this.rear.next = new Node<>(data);
            this.rear = this.rear.next;
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        T old = null;
        if (index >= 0) {
            Node<T> pre = this.headNode;
            int j = 0;
            while (pre.next != null && j < index) {
                pre = pre.next;
                j++;
            }
            Node<T> r = pre.next;
            if (r != null) {
                old = r.data;
                if (r == this.rear) {
                    this.rear = pre;
                }
                pre.next = r.next;
            }
        }
        return old;
    }

    @Override
    public boolean removeAll(T data) {
        boolean isRemove = false;
        if (data != null) {
            Node<T> front = this.headNode;
            Node<T> pre = front.next;
            while (pre != null) {
                if (data.equals(pre.data)) {
                    if (data.equals(rear.data)) {
                        this.rear = front;
                    }
                    front.next = pre.next;
                    pre = front.next;
                    isRemove = true;
                } else {
                    front = pre;
                    pre = pre.next;
                }
            }
        }
        return isRemove;
    }

    @Override
    public void clear() {
        this.headNode.next = null;
        this.rear = this.headNode;
    }

    @Override
    public boolean contains(T data) {
        if (data != null) {
            Node<T> pre = this.headNode.next;
            while (pre != null) {
                if (data.equals(pre.data)) {
                    return true;
                }
                pre = pre.next;
            }
        }
        return false;
    }

    public void concat(HeadSingleILinkedList<T> list) {
        if (this.headNode.next == null) {
            this.headNode.next = list.headNode.next;
        } else {
            Node<T> pre = this.headNode.next;
            while (pre.next != null)
                pre = pre.next;
            pre.next = list.headNode.next;
            //更新尾部指针指向
            this.rear = list.rear;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("(");
        Node<T> pre = this.headNode.next;
        while (pre != null) {
            str.append(pre.data);
            pre = pre.next;
            if (pre != null)
                str.append(", ");
        }
        return str + ")";
    }

    public static void main(String[] args) {

        String[] letters = {"A", "B", "C", "D", "E", "F"};
        HeadSingleILinkedList<String> list = new HeadSingleILinkedList<>(letters);

        System.out.println("list.get(3)->" + list.get(3));
        System.out.println("list:" + list.toString());

        System.out.println("list.add(4,Y)—>" + list.add(4, "Y"));
        System.out.println("list:" + list.toString());
        System.out.println("list.add(Z)—>" + list.add("Z"));
        System.out.println("list:" + list.toString());


        System.out.println("list.contains(Z)->" + list.contains("Z"));
        System.out.println("list.set(4,P)-->" + list.set(4, "P"));
        System.out.println("list:" + list.toString());

        System.out.println("list.remove(Z)->" + list.removeAll("Z"));
        System.out.println("list.remove(4)-->" + list.remove(4));
        System.out.println("list:" + list.toString());
    }
}