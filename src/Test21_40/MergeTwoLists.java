package Test21_40;

import Test1_20.ListNode;

/**
 * @author yangshunfan 2018/10/31 21:20
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resNode;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            resNode = l1;
            resNode.next = mergeTwoLists(l1.next, l2);
        } else {
            resNode = l2;
            resNode.next = mergeTwoLists(l1, l2.next);
        }

        return resNode;
    }
}
