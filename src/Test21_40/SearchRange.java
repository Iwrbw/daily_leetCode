package Test21_40;

/**
 * @author yangshunfan 2018/11/28 22:22
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        boolean isExist = false;
        while (rightIndex >= leftIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            int currNum = nums[mid];
            if (target > currNum) {
                leftIndex = mid + 1;
            } else if (target < currNum) {
                rightIndex = mid - 1;
            } else {
                isExist = true;
                leftIndex = mid;
                rightIndex = mid;
                while (leftIndex - 1 >= 0 && nums[leftIndex - 1] == target) {
                    leftIndex--;
                }
                while (rightIndex + 1 <= nums.length - 1 && nums[rightIndex + 1] == target) {
                    rightIndex++;
                }
                break;
            }
        }
        int[] res = {-1, -1};
        if (isExist) {
            res[0] = leftIndex;
            res[1] = rightIndex;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {6};
        int target = 6;
        SearchRange searchRange = new SearchRange();
        int[] arr = searchRange.searchRange(nums, target);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
