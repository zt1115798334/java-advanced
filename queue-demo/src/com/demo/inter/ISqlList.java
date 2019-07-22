package com.demo.inter;

public interface ISqlList<T> {
    /**
     * 判断链表是否为空
     * 
     * @return
     */
    boolean isEmpty();

    /**
     * 链表长度
     * 
     * @return
     */
    int length();

    /**
     * 获取元素
     * 
     * @param index
     * @return
     */
    T get(int index);

    /**
     * 设置某个元素值
     * 
     * @param index
     * @param data
     */
    T set(int index, T data);

    /**
     * 添加元素
     */
    boolean add(int index, T data);

    /**
     * 移除元素
     */
    T remove(int index);

    /**
     * 根据data移除元素
     * 
     * @param data
     * @return
     */
    boolean removeAll(T data);

    /**
     * 清空元素
     */
    void clear();

    /**
     * 查看是否包含元素
     * 
     * @param data
     * @return
     */
    boolean contains(T data);

    /**
     * 根据值查询下标
     * 
     * @param data
     * @return
     */
    int indexOf(T data);

    /**
     * 根据data查询顺序列表中最后出现的下标
     * 
     * @param data
     * @return
     */
    int lastIndexOf(T data);

    /**
     * 输出格式
     */
    String toString();
}