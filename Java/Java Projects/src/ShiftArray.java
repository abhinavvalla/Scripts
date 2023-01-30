import java.util.Arrays;

public class ShiftArray {
    public static void main(String[] args){
        int [] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(shiftRight(nums)));
    }
    public static int[] shiftLeft (int[] inputArray){
        int firstNum = inputArray[0];
        for (int i = 0; i < inputArray.length-1; i++){
            inputArray[i] = inputArray[i + 1];
        }
        inputArray[inputArray.length-1] = firstNum;
        return inputArray;
    }
    public static int[] shiftRight (int[] inputArray){
        int lastNum = inputArray[inputArray.length-1];
        for (int i = inputArray.length-1; i > 0; i--){
            inputArray[i] = inputArray[i-1];
        }
        inputArray[0] = lastNum;
        return inputArray;
    }
}
