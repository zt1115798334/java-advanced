package com.demo.inter.impl;

import com.demo.inter.ISqlList;

public class SqlList<T> implements ISqlList<T> {

    private Object[] table = new Object[64];
    private int length = 64;

    /**
     * 传入一个数组初始化顺序表
     * 
     * @param array
     */
    public SqlList(T[] array) {
        if (array == null) {
            throw new NullPointerException("array can\'t be empty!");
        }
        // 创建对应容量的数组
        this.table = new Object[array.length];
        // 复制元素
        for (int i = 0; i < array.length; i++) {
            this.table[i] = array[i];
        }

        this.length = array.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index > this.length()) {
            return (T) this.table[index];
        }
        return null;
    }

    @Override
    public T set(int index, T data) {
        if (index >= 0 && index < this.table.length && data != null) {
            T old = (T) this.table[index];
            this.table[index] = data;
            return old;
        }
        return null;
    }

    @Override
    public boolean add(int index, T data) {
        if (data == null)
            return false;
        // 插入下标的容错判断,插入在最前面
        if (index < 0)
            index = 0;
        // 插入下标的容错判断,插入在最后面
        if (index > this.length)
            index = this.length;
        if (this.length == table.length) {
            Object[] tmp = this.table;
            this.table = new Object[tmp.length * 2];
            // 先把原数组下标从0到index-1(即插入位置的前一个位置)复制到新数组
            for (int i = 0; i < index; i++) {
                this.table[i] = tmp[i];
            }
        }
        // 从原数组的最后一个元素开始直到index位置,都往后一个位置
        // 最终腾出来的位置就是新插入元素的位置了
        for (int j = this.length - 1; j >= index; j--) {
            this.table[j + 1] = this.table[j];
        }

        this.table[index] = data;
        this.length++;
        return true;
    }

    @Override
    public T remove(int index) {
        if (this.length != 0 && index >= 0 && index < this.length) {
            T old = (T) this.table[index];
            for (int j = index; j < this.length - 1; j++) {
                this.table[j] = this.table[j + 1];
            }
            this.table[this.length - 1] = null;
            this.length--;
            return old;
        }

        return null;

    }

    @Override
    public boolean removeAll(T data) {
        boolean done = false;
        if (this.length != 0 && data != null) {
            int i = 0;
            while (i < this.length) {
                if (data.equals(this.table[i])) {
                    this.remove(i);
                    done = true;
                } else
                    i++;
            }
        }
        return done;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public int indexOf(T data) {
        if (data != null) {
            for (int i = 0; i < this.length; i++) {
                if (table[i].equals(data)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T data) {
        if (data != null) {
            for (int i = this.length - 1; i >= 0; i--) {
                if (data.equals(this.table[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

}