package Test21_40;

/**
 * @author yangshunfan 2018/11/27 21:32
 * 33. 搜索旋转排序数组
 */
public class Search {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        int leftNum = nums[leftIndex];
        int rightNum = nums[rightIndex];

        //如果发生过旋转
        if (rightNum < leftNum) {
            if (target >= leftNum) {
                int diff = target - leftNum;
                rightIndex = leftIndex + diff > nums.length - 1 ? nums.length - 1 : leftIndex + diff;
                while (rightIndex > leftIndex && nums[rightIndex] < target) {
                    if (nums[rightIndex] == target) {
                        return rightIndex;
                    }
                    rightIndex--;
                }
            } else if (target <= rightNum) {
                int diff = rightNum - target;
                leftIndex = rightIndex - diff < 0 ? 0 : rightIndex - diff;
                while (leftIndex < rightIndex && nums[leftIndex] > target) {
                    leftIndex++;
                }
            }
        }
        while (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                rightIndex = mid - 1;
            } else {
                leftIndex = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(new Search().search(nums, target));
    }
}
