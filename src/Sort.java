
public class Sort {

	public int[] quickSort(int[] nums){
		int length = nums.length;
		return qSort(nums,0,length);

	}
	public int[] qSort(int[] nums, int start, int end){
		int mid = (end - start)/2;
		for(int i=0;i<length;i++){
			int pivot = nums[mid];
			qSort(nums, start, mid);
			qSort(nums, mid, end);
		}		
		return result;	
		
	}
	
	public static void main(String[] args) {
		

	}

}
