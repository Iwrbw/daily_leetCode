package Test1_20;

import java.util.Arrays;

/**
 * @author yangshunfan 2018/10/22 22:59
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int closestNum = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = sum - target;
                if (closestNum > Math.abs(diff)) {
                    closestNum = Math.abs(diff);
                    closestSum = sum;
                    if (diff < 0) {
                        left++;
                    } else {
                        right--;
                    }
                } else {
                    if (diff < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
