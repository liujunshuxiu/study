package study.daily;

public class IntTest {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static long transToLong(ListNode node) {
        long res = 0;
        long num = 1;

        do{
            res = node.val * (num) + res;
            num = num * 10;
        }while ((node = node.next) != null);

        return res;
    }

    private static ListNode transToNode(int num) {
        String str = String.valueOf(num);
        ListNode node = null;
        ListNode nodef = null;
        for(String s : str.split("")){
            node = new ListNode(Integer.valueOf(s));
            if(nodef != null){
                node.next = nodef;
            }
            nodef = node;
        }
        
        return node;
    }
    
    public static void main(String[] args) {
        System.out.println(12 / 10);

        long a = 9999999999L;
        long b = 9999999999L;
        System.out.println(a + b);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        System.out.println(transToLong(node1));

        System.out.println(transToNode(807));
        
    }
}
