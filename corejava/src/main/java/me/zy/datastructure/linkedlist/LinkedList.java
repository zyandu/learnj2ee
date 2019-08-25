package me.zy.datastructure.linkedlist;

public class LinkedList<E> {
    private class Node<E>{
        public E e;
        public Node next;

        public Node (E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(){
            this(null,null);
        }

        public Node (E e){
           this(e,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    } //inner class end

    private Node head;
    private int size;

    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    //获取链表中元素个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在链表头添加新的元素e
    public void addFirst(E e){
        //Node node = new Node(e);
        //node.next = head;
        //head = node;

        //上面三行优雅写法
        head = new Node(e,head);

        size ++;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        if(index == 0){
            addFirst(e);
        }else{
            Node prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;

                //Node node = new Node(e);
                //node.next = prev.next;
                //prev.next = node;

                //代替上面实现
                prev.next = new Node(e,prev.next);
                size ++;
            }
        }
    }

    //在链表尾部添加新元素
    public void addLast(E e){
        add(size,e);
    }

}
