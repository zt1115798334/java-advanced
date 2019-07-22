package com.demo.inter.impl;

import com.demo.domain.Node;
import com.demo.inter.ILinkedList;

public class SingleILinkedList<T> implements ILinkedList<T> {

    protected Node<T> headNode;

    public SingleILinkedList(Node<T> node) {
        this.headNode = node;
    }

    @Override
    public boolean isEmpty() {
        return this.headNode == null;
    }

    @Override
    public int length() {
        int length = 0;
        Node<T> p = headNode;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    @Override
    public T get(int index) {
        if (this.headNode != null && index > 0) {
            int cout = 0;
            Node<T> p = this.headNode;
            while (p != null && cout < index) {
                p = p.next;
                cout++;
            }
            if (p != null) {
                return p.data;
            }
        }
        return null;
    }

    @Override
    public T set(int index, T data) {
        if (this.headNode != null && index > 0 && data != null) {
            Node<T> pre = this.headNode;
            int count = 0;
            while (pre != null && count < index) {
                pre = pre.next;
                count++;
            }
            if (pre != null) {
                T oldData = pre.data;
                pre.data = data;
                return oldData;
            }
        }

        return null;
    }

    @Override
    public boolean add(int index, T data) {
        if (data == null) {
            return false;
        }
        if (this.headNode == null || index <= 1) {
            this.headNode = new Node<T>(data, this.headNode);
        } else {
            int count = 0;
            Node<T> front = this.headNode;
            while (front.next != null && count < index - 1) {
                front = front.next;
                count++;
            }
            front.next = new Node<T>(data, front.next);
        }
        return true;
    }

    @Override
    public boolean add(T data) {
        return false;
    }

    @Override
    public T remove(int index) {
        T old = null;
        if (this.headNode != null && index >= 0) {
            if (index == 0) {
                old = this.headNode.data;
                this.headNode = this.headNode.next;
            } else {
                Node<T> front = this.headNode;
                int count = 0;
                while (front.next != null && count < index - 1) {
                    front = front.next;
                    count++;
                }

                // Node<T> r = front.next;
                // if (r != null) {
                // old = r.data;
                // front.next = r.next;
                // r = null;
                // }
                if (front.next != null) {
                    old = front.next.data;
                    front.next = front.next.next;
                }
            }
        }
        return old;
    }

    @Override
    public boolean removeAll(T data) {
        return false;
    }

    @Override
    public void clear() {
        headNode = null;
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

}