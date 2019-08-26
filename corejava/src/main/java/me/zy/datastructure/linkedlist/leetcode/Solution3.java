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
public class Solution3 {
    //使用递归算法实现
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        head.next = removeElements(head.next,val);
        return head.val == val?head.next:head;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head, 6);
        System.out.println(res);
    }
}
