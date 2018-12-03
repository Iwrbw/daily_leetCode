package Test21_40;

/**
 * @author yangshunfan 2018/11/29 22:56
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i]) {
                index = i + 1;
            }
        }
        return index;
    }
}
