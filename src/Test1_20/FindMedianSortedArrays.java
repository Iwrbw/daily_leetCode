package Test1_20;

import java.util.Stack;

/**
 * @author yangshunfan 2018/10/8 22:32
 */
public class FindMedianSortedArrays {
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int lenSum = len1 + len2;
        int median = lenSum / 2;
        int left = 0;
        int right = 0;


        double result = 0.0;

        double medianSum;

        if (len1 == 0 && len2 == 0) {
            median = 0;
        } else if (len1 == 0) {
            if (len2 < 2) {
                return nums2[0];
            }
            if (len2 % 2 > 0) {
                result = nums2[median];
            } else {
                medianSum = nums2[median] + nums2[median - 1];
                result = medianSum / 2;
            }
        } else if (len2 == 0) {
            if (len1 < 2) {
                return nums1[0];
            }
            if (len1 % 2 > 0) {
                result = nums1[median];
            } else {
                medianSum = nums1[median] + nums1[median - 1];
                result = medianSum / 2;
            }
        }

        if (len1 == 0 || len2 == 0) {
            return result;
        }

        Stack<Integer> stack = new Stack<>();

        //如果是奇数个数
        if (lenSum % 2 > 0) {
            while (stack.size() < median + 1) {
                if (left < len1 && right < len2) {
                    if (nums1[left] < nums2[right]) {
                        stack.push(nums1[left]);
                        left++;
                    } else {
                        stack.push(nums2[right]);
                        right++;
                    }
                } else if (left == len1) {
                    stack.push(nums2[right]);
                    right++;
                } else if (right == len2) {
                    stack.push(nums1[left]);
                    left++;
                }
            }
            return stack.pop();

        } else {
            while (stack.size() < median + 1) {
                if (left < len1 && right < len2) {
                    if (nums1[left] < nums2[right]) {
                        stack.push(nums1[left]);
                        left++;
                    } else {
                        stack.push(nums2[right]);
                        right++;
                    }
                } else if (left == len1) {
                    stack.push(nums2[right]);
                    right++;
                } else if (right == len2) {
                    stack.push(nums1[left]);
                    left++;
                }
            }
            medianSum = stack.pop() +stack.pop();
            return medianSum / 2;

        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 3};
        int[] num2 = {2};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
