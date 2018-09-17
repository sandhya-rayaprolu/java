import java.util.Arrays;


public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return;
        if(k==0 || k==nums.length)
            return;
        if(k>nums.length) k = k%nums.length;
        int x= nums.length - k;
        int[] newNums = new int[nums.length];
        for(int i=x,j=0;i<nums.length;i++,j++){
            newNums[j] = nums[i];
        }
        for(int i=0,j=k;i<x;i++,j++){
            newNums[j] = nums[i];
        }
    }
    public static void main(String[] args){
    	int[] arr = {1,2};
    	RotateArray ra =  new RotateArray();
    	ra.rotate(arr, 1);
    	System.out.println(arr[0]+","+arr[1]);
    }
}

