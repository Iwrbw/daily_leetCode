package Test21_40;

import Test1_20.ListNode;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/11/5 22:16
 */
public class SwapPairs {

    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);
        temp.next = head;
        return temp;
    }

    /**
     * 遍历
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = head, nowNode = head, lastNode = head.next;
        while (lastNode != null) {
            //获取第三个节点
            nowNode.next = lastNode.next;
            //第二个节点替换为前面的节点
            lastNode.next = nowNode;
            //若最新的节点为head，则将头节点指向为lastNode
            if (nowNode == head) {
                head = lastNode;
            }

            if (preNode != nowNode) {
                preNode.next = lastNode;
            }
            preNode = lastNode.next;
            nowNode = nowNode.next;
            lastNode = nowNode == null ? null : nowNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        List<Integer> list = new LinkedList<>();
        for (Integer i : arr) {
            list.add(i);
        }
        ListNode node = swapPairs(ListNode.createListNode(list));
        int[] result = ListNode.chargeArray(node);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
}
