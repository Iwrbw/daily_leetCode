package Test1_20;

/**
 * @author yangshunfan 2018/10/15 22:06
 */
public class MaxArea {
    public static int maxArea(int[] height) {
        if (height.length < 1) {
            return 0;
        }
        int start = 0, end = height.length - 1;
        int maxArea = 0;
        while (start < end) {
            int shortOne = Math.min(height[start], height[end]);
            int newArea = shortOne * (end - start);
            maxArea = Math.max(maxArea, newArea);
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(maxArea(height));
    }
}
