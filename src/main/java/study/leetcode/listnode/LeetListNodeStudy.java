package study.leetcode.listnode;

public class LeetListNodeStudy {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        ListNode snode1 = new ListNode(1);
//        ListNode snode2 = new ListNode(3);
//        ListNode snode3 = new ListNode(4);
//        snode1.next = snode2;
//        snode2.next = snode3;

        ListNode listNode = reverseList(node1);

        System.out.println(listNode);
    }
}
