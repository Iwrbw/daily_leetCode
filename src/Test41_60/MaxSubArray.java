package Test41_60;

/**
 * @author yangshunfan 2018/12/24 22:05
 * 53. 最大子序和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            if (sum <= 0) {
                sum = Math.max(temp, sum);
                result = Math.max(sum, result);
            } else {
                int tempSum = sum + temp;
                if (tempSum >= 0) {
                    sum = tempSum;
                    result = Math.max(sum, result);
                } else {
                    sum = 0;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1};
        MaxSubArray maxWidthRamp = new MaxSubArray();
        System.out.println(maxWidthRamp.maxSubArray(nums));
    }
}
