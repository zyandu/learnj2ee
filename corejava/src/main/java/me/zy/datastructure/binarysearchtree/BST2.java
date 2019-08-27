package me.zy.datastructure.binarysearchtree;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 二叉搜索树
 * 每个元素必须具有可比较性
 */
public class BST2<E extends Comparable<E>> {
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
    public BST2(){
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
        root = add(root,e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node,E e){
        if(node == null){
            size++;
            root = new Node(e);
            return root;
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }

    //看二叉搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if(node == null){
            return  false;
        }

        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else { //if(e.compareTo(node.e) > 0)
            return contains(node.right, e);
        }
    }

    //前序遍历
    public void preOrder(){
        preOrder(root);
    }

    //前序遍历以node为根节点的二分搜索树，递归算法
    private void preOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    public void inOrder(){
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历以node为根的二分搜索树, 递归算法
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        gennerateBSTString(root, 0, res);
        return res.toString();
    }

    private void gennerateBSTString(Node node, int depth, StringBuilder res) {
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        gennerateBSTString(node.left, depth + 1, res);
        gennerateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++) {
            res.append("--");
        }

        return res.toString();
    }

    /**
     * 前序、中序、后序遍历都是深度遍历
     * 下面演示广度遍历：同层级的在一起
     */
    public void levelOrder(){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left != null){
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
        }


    }

    public static void main(String[] args) {
        BST2<Integer> bst2 = new BST2<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums){
            bst2.add(num);
        }
        //System.out.println(bst2);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        //bst2.preOrder(); //532468
        //System.out.println();
        //System.out.println(bst2);
        //
        //bst2.inOrder(); //234568
        //System.out.println();
        //System.out.println(bst2);
        //
        //bst2.postOrder(); //243865
        //System.out.println();
        //System.out.println(bst2);

        bst2.levelOrder(); //536248
        System.out.println();
        System.out.println(bst2);


    }
}
