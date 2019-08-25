package me.zy.datastructure.array;

public class GenericArray<E> {
    private E[] data;
    private int size;

    //传入数组的容量，构造函数
    public GenericArray(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    //无参构造函数，数组容量默认为10
    public GenericArray() {
        this(10);
    }

    //获取数组容量
    public int getCapacity(){
        return data.length;
    }

    //获取数组中元素个数
    public int getSize(){
        return size;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在第一个位置添加一个元素
    public void addFirst(E e){
        add(0,e);
    }

    //在最后添加一个新元素
    public void addLast(E e){
        add(size,e);
    }

    //在index索引位置添加一个元素
    public void add(int index,E e){
        if(index == data.length){
            throw new IllegalArgumentException("Add failed.Array is full.");
        }

        if(index < 0 || index >size){
            throw  new IllegalArgumentException("Add failed. Require index >= 0 and index <= size. ");
        }

        for (int i = size -1 ; i >= index; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    //获取指定位置元素
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");

        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i] == e)
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i] == e)
                return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for(int i = index + 1 ; i < size ; i ++){
            data[i-1] = data[i];
        }

        size--;
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d,capacity = %d\n",size,data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if(i != size-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //测试函数，为了方便，就写在当前类中了
    public static void main(String[] args) {
        GenericArray<Integer> arr = new GenericArray<>(20);
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}
