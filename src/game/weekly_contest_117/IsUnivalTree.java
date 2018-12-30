package game.weekly_contest_117;


import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/12/30 10:31
 * 965. 单值二叉树
 */
public class IsUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        if (null == root) {
            return true;
        }
        int value = root.val;
        List<Integer> list = new LinkedList<>();
        help(root, list);
        for (Integer i : list) {
            if (i != value) {
                return false;
            }
        }
        return true;
    }

    private void help(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            help(root.left, list);
            help(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        IsUnivalTree isUnivalTree = new IsUnivalTree();
        System.out.println(isUnivalTree.isUnivalTree(root));
    }
}
