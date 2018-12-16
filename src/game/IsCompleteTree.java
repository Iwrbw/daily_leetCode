package game;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangshunfan 2018/12/16 10:58
 * 958. 二叉树的完全性检验
 */
public class IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = queue.poll();
        while (node != null) {
            queue.poll();
            queue.add(node.left);
            queue.add(node.right);
            node = queue.peek();
        }

        queue.poll();

        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                return false;
            }
            queue.poll();
        }
        return true;
    }
}
