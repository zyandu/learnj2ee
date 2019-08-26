package me.zy.datastructure.linkedlist.leetcode;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * leetcode上述问题解答
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //不使用虚拟头结点实现
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return head;
        }

        ListNode prev = head;
        while (prev.next != null ){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode ln = new ListNode(arr);
        System.out.println(ln);

        Solution solution = new Solution();
        solution.removeElements(ln,6);
        System.out.println(ln);
    }

}
