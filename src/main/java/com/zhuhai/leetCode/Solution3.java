package com.zhuhai.leetCode;
/**
 * Created with IntelliJ IDEA.
 * Date: 2019/7/11
 * Time: 10:12
 *
 * @author: zhuhai
 */
public class Solution3 {


    /**
     * 使用递归的方式删除链表中指定的元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        /*ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }*/

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;


    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,6,3,4,6,5};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        Solution3 solution3 = new Solution3();
        solution3.removeElements(listNode, 6);
        System.out.println(listNode);
    }


}
