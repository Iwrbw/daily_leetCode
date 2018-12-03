package Test1_20;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/10/4 22:00
 */
public class AddTowNums {
    public static Test1_20.ListNode addTwoNumbers(Test1_20.ListNode l1, Test1_20.ListNode l2) {
        Test1_20.ListNode dummyHead = new Test1_20.ListNode(0);
        Test1_20.ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new Test1_20.ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new Test1_20.ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1};
        int[] arr2 = {9, 9};
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        for (Integer i : arr1) {
            list1.add(i);
        }
        for (Integer i :  arr2) {
            list2.add(i);
        }
        Test1_20.ListNode node1 = Test1_20.ListNode.createListNode(list1);
        Test1_20.ListNode node2 = Test1_20.ListNode.createListNode(list2);
        int[] array = Test1_20.ListNode.chargeArray(addTwoNumbers(node1, node2));
        for (Integer i : array) {
            System.out.print(i + " ");
        }
    }
}
