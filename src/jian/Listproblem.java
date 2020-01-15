package jian;

public class Listproblem {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k == 0) return null;
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
            if (p == null && i < k - 1) return null;
        }
        if (p == null) return head;
        else{
            ListNode q = head;
            while(p != null){
                p = p.next;
                q = q.next;
            }
            return q;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        else if (head.next  == null) return head;
        else {
            ListNode p = head;
            ListNode ans = reverse(head,head.next);
            p.next = null;
            return ans;
        }
    }

    public ListNode reverse(ListNode node1, ListNode node2){
        if (node2.next != null){
            ListNode q = node2.next;
            node2.next = node1;
            return reverse(node2,q);
        }
        else{
            node2.next = node1;
            return node2;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        int h = 0;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val > list2.val){
            h = list2.val;
            list2 = list2.next;
        }
        else{
            h = list1.val;
            list1 = list1.next;
        }
        ListNode head = new ListNode(h);
        ListNode p = head;
        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                p.next = new ListNode(list2.val);
                list2 = list2.next;
                p = p.next;
            }
            else{
                p.next = new ListNode(list1.val);
                list1 = list1.next;
                p = p.next;
            }
        }
        while (list1 != null){
            p.next = new ListNode(list1.val);
            list1 = list1.next;
            p = p.next;
        }
        while (list2 != null){
            p.next = new ListNode(list2.val);
            list2 = list2.next;
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Listproblem l = new Listproblem();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        System.out.println(l.FindKthToTail(l1,1).val);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(l.FindKthToTail(l1,4).val);
        System.out.println(l.FindKthToTail(l1,3).val);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(4);
        ListNode l8 = new ListNode(8);
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        ListNode h = l.Merge(l1,l5);
        System.out.println(h);

    }

}
