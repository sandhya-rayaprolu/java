import java.util.Arrays;
import java.util.HashMap;


public class TwoSum {
	    public int[] twoSum(int[] nums, int target) {
	        int[] result = {-1,-1};
	        for(int i=0;i<nums.length;i++){
	            int j = binSearch(target-nums[i],nums);
	        	System.out.println("i="+i+"j="+j+(target-nums[i]));
	            if(j!=-1){
	                result[0]=i;
	                result[1]=j;
	                return result;
	            }
	        }
	        return result;
	    }
	    public static int binSearch(int key, int[] a) {
	    int lo = 0;
	    int hi = a.length - 1;
	    while (lo <= hi) {
	        int mid = lo+(hi-lo/2);
	        if(key>a[mid]) lo = mid+1;
	        else if(key<a[mid]) hi = mid-1;
	        else return mid;
	    }
	    return -1;
	    }
        public int[] twoSumHashMap(int[] nums, int target) {
            int[] result = {-1,-1};
            HashMap<Integer,Integer> map = new HashMap<>();
            if(nums == null || nums.length==0) { 
                return result;
            }
            for(int i=0;i<nums.length;i++){
                if(map.get(nums[i])!=null){
                	result[0]=map.get(nums[i]);
                	result[1]=nums[i];
                    return result;
                }else{
                    map.put(target-nums[i],nums[i]);
                }
                System.out.println(map);
            }
            return result;
        }
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] nums = {3,2,4};
		int[] res = ts.twoSumHashMap(nums,6);
		System.out.println(res[0]+""+res[1]);

	}

}
