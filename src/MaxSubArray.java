
public class MaxSubArray {
		  public int maxSA(int[] A) {
		       int currsum=A[0];
		       int max=A[0];
		       System.out.println(" A[i] = "+A[0]+" currsum = "+currsum+" max = "+max);
			       for(int i=1;i<A.length;i++){
			    	   currsum=Math.max(currsum+A[i],A[i]);
			           max= Math.max(max, currsum);
			           System.out.println("i = "+i+" A[i] = "+A[i]+" currsum = "+currsum+" max = "+max);
			       }
		       return max;
		    }
	public static void main(String[] args) {
		int a[] = {-2,1,-3,4,-1,2,1,-5,4};
		MaxSubArray msa= new MaxSubArray();
		System.out.println(msa.maxSA(a));

	}

}
