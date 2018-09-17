
public class ArrayProduct {
	
	public static void main(String[] args) {
	ArrayProduct arrProd = new ArrayProduct();
	int[] arr = {2,3,45,67};
	System.out.println("Product array for "+arr.toString()+" is  "+arrProd.prodArray(arr).toString());	
}

	private int[] prodArray (int[] arr) {
		int n = arr.length;
		if(n <= 0) {
			return arr;
		}
		int[] productArray = new int[n];
		int[] leftArray = new int[n];
		int[] rightArray = new int[n];
		leftArray[0]=1;
		rightArray[n-1]=1;
		for(int i=1;i<n;i++) {
			leftArray[i] = leftArray[i-1]*arr[i-1];
		}
		for(int j=n-2;j>=0;j--) {
			rightArray[j] = rightArray[j+1]*arr[j+1];
		}
		for(int i=0;i<n;i++) {
			productArray[i]=leftArray[i]*rightArray[i];
		}
		return productArray;
	}
}
