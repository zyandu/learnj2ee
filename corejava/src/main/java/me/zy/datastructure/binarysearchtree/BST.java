package me.zy.datastructure.binarysearchtree;

/**
 * 二叉搜索树
 * 每个元素必须具有可比较性
 */
public class BST<E extends Comparable<E>> {
    public class Node{
        private E e;
        private Node left;
        private Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;
    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //插入一个元素
    public void add (E e){
        if(root == null){
            root = new Node(e);
            size++;
        }else{
            add(root,e);
        }
    }

    private void add(Node node,E e){
        if(node.e.equals(e)){
            return;
        }else if(e.compareTo(node.e) <0 && node.left == null){
            node.left = new Node(e);
            size++;
            return;
        }else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size++;
            return;
        }

        if(e.compareTo(node.e) < 0){
            add(node.left,e);
        }else{//e.compareTo(node.e) > 0
            add(node.right,e);
        }
    }

}
