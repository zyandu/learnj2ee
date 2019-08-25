package me.zy.datastructure.stack;

public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    /**
     * 将element压入堆栈，同时也返回element
     * @param e
     */
    void push(E e);

    /**
     * 返回位于栈顶的元素，并在进程中删除它
     * @return
     */
    E pop();

    /**
     * 返回位于栈顶的元素，但是并不在堆栈中删除它
     * @return
     */
    E peek();

    String toString();
}
