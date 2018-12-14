package Test41_60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan on 2018/12/14
 * 46. 全排列
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        for (int i : nums) {
            List<Integer> list = new LinkedList<>();
            list.add(i);
            res.add(list);
        }

        return permute2(res, nums);
    }

    private List<List<Integer>> permute2(List<List<Integer>> res, int[] nums) {
        List<List<Integer>> newRes = new LinkedList<>();
        for (List<Integer> list : res) {
            for (int i : nums) {
                if (!list.contains(i)) {
                    List<Integer> tempList = new LinkedList<>(list);
                    tempList.add(i);
                    newRes.add(tempList);
                }
            }
        }
        if (newRes.isEmpty()) {
            return res;
        } else if (newRes.get(newRes.size() - 1).size() == nums.length) {
            return newRes;
        }
        return permute2(newRes, nums);
    }

    /**
     * 答案
     * @param nums 数组
     */
    public List<List<Integer>> permuteAnswer(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        }

        for (int num : nums) {
            if (!temp.contains(num)) {
                temp.add(num);
                backtrack(list, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums = {};
        System.out.println(permute.permute(nums));
    }
}
