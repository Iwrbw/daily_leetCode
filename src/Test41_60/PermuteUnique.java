package Test41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangshunfan 2018/12/17 21:09
 *   47. 全排列2
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
            Arrays.sort(nums);
        helper(result, list, visited, nums);
            return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> list, int[] visited, int[] num) {
        if(list.size() == num.length) {
            result.add(new ArrayList<>(list));
        }
        for(int i = 0; i < num.length; i++) {
            if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)) {
                continue;
            }
            visited[i] = 1;
            list.add(num[i]);
            helper(result, list, visited, num);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}
