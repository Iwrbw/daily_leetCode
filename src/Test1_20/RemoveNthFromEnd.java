package Test1_20;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yangshunfan 2018/10/28 10:44
 */
public class RemoveNthFromEnd {
    public static Test1_20.ListNode removeNthFromEnd(Test1_20.ListNode head, int n) {
        if (head == null) {
            return null;
        }
        Queue<Test1_20.ListNode> queue = new LinkedList<>();
        int len = 0;
        while (head != null) {
            queue.add(head);
            head = head.next;
            len++;
        }
        Test1_20.ListNode node = new Test1_20.ListNode(0);
        Test1_20.ListNode res = node;
        int index = 0;
        while (!queue.isEmpty()) {
            if (index == len - n) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                node.next = queue.poll();
                node = node.next;
                index++;
            }
        }
        node.next = null;
        return res.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int n = 1;
        List<Integer> list1 = new LinkedList<>();
        for (Integer i : arr1) {
            list1.add(i);
        }
        Test1_20.ListNode node1 = Test1_20.ListNode.createListNode(list1);
        int[] array = Test1_20.ListNode.chargeArray(removeNthFromEnd(node1, n));
        for (Integer i : array) {
            System.out.print(i + " ");
        }

        String str = "-123";
        Boolean isNumber = str.matches("-?[0-9]+.*[]0-9]*");
        System.out.println(isNumber);
    }
}
