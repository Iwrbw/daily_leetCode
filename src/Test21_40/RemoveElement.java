package Test21_40;

/**
 * @author yangshunfan 2018/11/8 22:44
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        System.out.println(index);
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 3, 4, 5, 6, 7};
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(nums, 3));
        for (Integer i : nums) {
            System.out.print(i);
        }
    }
}
