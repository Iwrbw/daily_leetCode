package Test21_40;

import Test1_20.ListNode;

/**
 * @author yangshunfan 2018/11/6 22:16
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode currentNode = head;
        int count = 0;
        while (currentNode != null && count != k) {
            currentNode = currentNode.next;
            count++;
        }
        if (count == k) {
            // 递归的解决子问题
            currentNode = reverseKGroup(currentNode, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = currentNode;
                currentNode = head;
                head = temp;
            }
            //最终，该段的所有节点将会截空，head应指向current_node
            head = currentNode;
        }
        return head;
    }
}
