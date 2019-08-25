package me.zy.datastructure.queue;

public interface Queue<E> {
    /**
     * 获得队列大小
     */
    int getSize();

    /**
     * 是否包含元素
     */
    boolean isEmpty();

    /**
     * 入队列
     */
    void enqueue(E e);

    /**
     * 对首
     */
    E getFront();

    /**
     * 队首元素，出队列
     * @return
     */
    E dequeue();

}
