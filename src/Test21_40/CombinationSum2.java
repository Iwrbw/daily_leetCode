package Test21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/12/4 22:09
 * 40. 组合总和 II
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        compute(candidates, target, res, ans, 0);
        return ans;
    }

    private void compute(int[] candidates,int target, List<Integer> res, List<List<Integer>> ans,
            int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            List<Integer> list = new ArrayList<>(res);
            if (!ans.contains(list)) {
                ans.add(new ArrayList<>(res));
            }
        } else {
            for (int i = start; i < candidates.length; i++) {
                res.add(candidates[i]);
                //start+1,不重复使用数
                compute(candidates, target - candidates[i], res, ans, i + 1);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidats = {2,5,2,1,2};
        int target = 5;
        CombinationSum2 combinationSum = new CombinationSum2();
        System.out.println(combinationSum.combinationSum2(candidats, target));
    }
}
