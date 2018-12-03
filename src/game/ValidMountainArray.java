package game;

/**
 * @author yangshunfan 2018/11/18 10:31
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length <= 1) {
            return false;
        }
        if (A[1] < A[0]) {
            return false;
        }
        int index = 1;
        int currNum = A[0];
        boolean isMountain = false;
        while (index < A.length && A[index] > currNum) {
            currNum = A[index];
            index++;
        }
        for (int i = index; i < A.length; i++) {
            if (A[i] < currNum) {
                isMountain = true;
                currNum = A[i];
            } else {
                return false;
            }
        }
        return isMountain;
    }

    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
        int[] arr = {0,3,2,1};
        System.out.println(validMountainArray.validMountainArray(arr));
    }
}
