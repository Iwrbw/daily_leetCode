package Test21_40;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangshunfan 2018/11/17 17:54
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int maxValue = nums[nums.length - 1];
        map.put(maxValue, nums.length - 1);
        for (int i = nums.length - 2; i >= 0 ; i--) {
            int currNum = nums[i];
            if (currNum < maxValue) {
                int tempNum = currNum + 1;
                while (tempNum <= maxValue) {
                    if (map.containsKey(tempNum)) {
                        nums[i] = tempNum;
                        nums[map.get(tempNum)] = currNum;
                        Arrays.sort(nums, i + 1, nums.length);
                        return;
                    }
                    tempNum++;
                }
            } else {
                maxValue = currNum;
                if (!map.containsKey(currNum)) {
                    map.put(currNum, i);
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] nums = {16,27,25,23,25,16,12,9,1,2,7,20,19,23,16,0,6,22,16,11,8,27,9,2,20,2,13,7,25,29,12,12,18,29,27,13,16,1,22,9,3,21,29,14,7,8,14,5,0,23,16,1,20};
        int[] arr = {4,3,1};
        Arrays.sort(arr, 1, arr.length);
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }
}
