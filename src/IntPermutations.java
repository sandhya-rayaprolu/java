
public class IntPermutations {
	    public int maxProduct(int[] A) {
	        if(A.length<=0)
	            throw new java.lang.IllegalArgumentException();
	        int product = A[0];
	        int maxProduct = A[0];
	        int lastProduct = A[0];
	        for(int i=1;i<A.length;i++){
	        	product = product * A[i];
	            if(product>maxProduct){
	                maxProduct = product;
	            }
	            else{
	            	lastProduct = maxProduct;
	            	product = A[i];
	            }
	        }
	        if(lastProduct>maxProduct)
	            maxProduct = lastProduct;
	        if(product>maxProduct)
	        	maxProduct = product;
	    return maxProduct;
	    }
	public static void main(String[] args) {
		IntPermutations perm  = new IntPermutations();
		int[] array = {-4,-3,-2}; 
		System.out.println(perm.maxProduct(array));

	}

}
