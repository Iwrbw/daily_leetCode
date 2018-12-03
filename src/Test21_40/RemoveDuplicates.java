package Test21_40;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/11/7 22:10
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        index++;
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4};
        System.out.println(removeDuplicates(arr));
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
