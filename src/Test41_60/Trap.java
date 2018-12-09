package Test41_60;

/**
 * @author yangshunfan 2018/12/6 23:22
 *
 */
public class Trap {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        if (left >= right) {
            return res;
        }
        int leftheight = height[left];
        int rightheight = height[right];
        while (left < right) {
            if (leftheight < rightheight) {
                left ++;
                if (leftheight > height[left]) {
                    res += (leftheight - height[left]);
                } else {
                    leftheight = height[left];
                }
            } else {
                right --;
                if (rightheight > height[right]) {
                    res += (rightheight - height[right]);
                } else {
                    rightheight = height[right];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap.trap(height));
    }

}
