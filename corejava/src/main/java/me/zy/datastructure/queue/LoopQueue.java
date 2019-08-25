package me.zy.datastructure.queue;

public class LoopQueue<E> implements Queue<E>{
    private int front,tail;
    private E[] data;
    private int size;

    public LoopQueue(int capacity) {
        // 需要保留一个位置
        data = (E[])new Object[capacity + 1];
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        //循环队列满了
        if((tail +1)%(data.length) == front){
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private E[] resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity+1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;

        return data;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;

        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity()/4 && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }

        return ret;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        sb.append("front [");
        for (int i = front; i != tail; i = (i+1) % data.length) {
            sb.append(data[i]);
            if((i+1) % data.length != tail){
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                System.out.println("deque~"+i);
                queue.dequeue();
                System.out.println("dequeue~"+queue);
            }
        }
    }

}
