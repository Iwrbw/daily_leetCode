package Test1_20;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/10/24 20:53
 */
public class FourNum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resList = new LinkedList<>();
        if (nums.length < 4) {
            return resList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = nums.length - 1; j > 2; j--) {
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int left = i + 1, right = j - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right] + nums[j];
                    if (sum == target) {
                        List<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        list.add(nums[j]);
                        resList.add(list);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-1,0,2,4,5};
        int target = 2;
        System.out.println(fourSum(nums, target));
    }
}
