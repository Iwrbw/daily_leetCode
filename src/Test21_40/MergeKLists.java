package Test21_40;

import Test1_20.ListNode;
import java.util.Stack;

/**
 * @author yangshunfan 2018/11/1 20:45
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        stack.push(lists[0]);
        for (int i = 1; i < lists.length; i++) {
            ListNode node = lists[i];
            stack.push(mergeTwo(node, stack.pop()));
        }
        return stack.pop();
    }

    private ListNode mergeTwo(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (true) {
            if (node1.val > node2.val) {
                head.next = node2;
                head = head.next;
                node2 = node2.next;
            } else {
                head.next = node1;
                head = head.next;
                node1 = node1.next;
            }
            if (node1 == null) {
                head.next = node2;
                break;
            }
            if (node2 == null) {
                head.next = node1;
                break;
            }
        }
        return res.next;
    }
}
