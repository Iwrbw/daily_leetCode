package Test41_60;

/**
 * @author yangshunfan 2018/12/26 21:39
 * 55. 跳跃游戏
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        boolean canJump  = false;
        int index = 0;
        int len = index + nums[index];
        if (nums.length <= 1) {
            return true;
        }
        if (len >= nums.length) {
            return true;
        }
        for (int i = index; i < len; i = index) {
            index = getNewIndex(nums, i);
            len = nums[index] + index;
            if (index == nums.length - 1) {
                canJump = true;
                break;
            }
        }
        return canJump;
    }

    private int getNewIndex(int[] nums, int currIndex) {
        int len = nums[currIndex] + currIndex;
        int max = len;
        int jumpIndex = 0;
        for (int i = currIndex + 1; i <= len && i < nums.length; i++) {
            int t = nums[i] + i;
            if (t >= max) {
                jumpIndex = i;
                max = t;
            }
            if (i == nums.length - 1) {
                return i;
            }
        }
        return jumpIndex;
    }

    public static void main(String[] args) {
        CanJump jump = new CanJump();
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(jump.canJump(nums));
        System.out.println(jump.canJump(nums2));
    }
}
