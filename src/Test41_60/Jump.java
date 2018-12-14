package Test41_60;

/**
 * @author yangshunfan on 2018/12/14
 * 46. 跳跃
 */
public class Jump {
    public int jump(int[] nums) {
        int time = 0;
        int index = 0;
        int len = index + nums[index];
        if (nums.length <= 1) {
            return 0;
        }
        if (len >= nums.length) {
            return 1;
        }
        for (int i = index; i < len; i = index) {
            index = getNewIndex(nums, i);
            time++;
            len = nums[index] + index;
            if (index == nums.length - 1) {
                break;
            }
        }
        return time;
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
        Jump jump = new Jump();
        int[] nums = {1,2,3};
        System.out.println(jump.jump(nums));
    }
}
