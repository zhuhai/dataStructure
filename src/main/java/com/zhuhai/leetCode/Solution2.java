package com.zhuhai.leetCode;
/**
 * Created with IntelliJ IDEA.
 * Date: 2019/7/11
 * Time: 10:12
 *
 * @author: zhuhai
 */
public class Solution2 {


    /**
     * 使用虚拟头节点删除链表中指定的元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
               /* ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;*/
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }

        }
        return dummyNode.next;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,6,3,6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        Solution2 solution2 = new Solution2();
        solution2.removeElements(listNode, 6);
        System.out.println(listNode);
    }


}
