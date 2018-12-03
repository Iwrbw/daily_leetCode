package Test21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yangshunfan 2018/12/3 22:27
 * 39. 组合总和
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //先将数组排序
        Arrays.sort(candidates);
        //key:数值 value：个数
        Map<Integer, Integer> map = new HashMap<>(candidates.length);
        //结果
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        compute(candidates, target, res, ans, 0);
        return ans;
    }

    private void compute(int[] candidates, int target, List<Integer> res, List<List<Integer>> ans,
            int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            ans.add(new ArrayList<>(res));
        } else {
            for (int i = start; i < candidates.length; i++) {
                res.add(candidates[i]);
                compute(candidates, target - candidates[i], res, ans, i);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidats = {2,3,6,7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidats, target));
    }
}
