package Test41_60;

import java.util.*;

/**
 * @author yangshunfan on 2019/2/14
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 */
public class GetPermutation {

    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
        int n = 3;
        int k = 3;
        System.out.println(getPermutation.getPermutation(n, k));
    }

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        backRoll(result, temp, nums, k);
        List<Integer> list = result.get(k - 1);
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        return sb.toString();
    }

    /**
     * 递归获取全排列
     * @param result 全排列
     * @param temp 数列
     * @param nums 所有数字
     */
    private void backRoll(List<List<Integer>> result, List<Integer> temp, int[] nums, int k) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            if (result.size() == k) {
                return;
            }
        }

        for (int num : nums) {
            if (!temp.contains(num)) {
                temp.add(num);
                backRoll(result, temp, nums, k);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
