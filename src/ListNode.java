package Test1_20;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/10/4 22:00
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public static ListNode createListNode(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        ListNode node = new ListNode(0);
        for (Integer i : list) {
            node.addNode(i);
        }
        return node.next;
    }

    public static int[] chargeArray(ListNode node) {
        List<Integer> list = new LinkedList<>();
        while (node != null)  {
            list.add(node.val);
            node = node.next;
        }
        int[] result = new int[list.size()];
        int n = 0;
        for (Integer i : list) {
            result[n++] = i;
        }
        return result;
    }

    public void addNode(int d) {
        ListNode N = new ListNode(d);
        if (next == null) {
            next = N;
            return;  /*由于每次是增加一个节点，所以对头结点进行初始化之后就要退出函数*/
        }
        ListNode tem;
        tem = next;
        while (tem.next != null) {
            tem = tem.next;
        }
        tem.next = N;
    }
}
