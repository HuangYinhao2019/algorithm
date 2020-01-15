package jian;
import java.util.ArrayList;
import java.util.List;



public class printListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return new ArrayList<Integer>();
        }
        else if(listNode.next == null){
            ArrayList<Integer> res = new ArrayList<Integer>();
            res.add(listNode.val);
            return res;
        }
        else{
            ArrayList<Integer> res = printListFromTailToHead(listNode.next);
            res.add(listNode.val);
            return res;
        }
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        printListFromTailToHead p = new printListFromTailToHead();
        System.out.println(p.printListFromTailToHead(l1));
    }
}
