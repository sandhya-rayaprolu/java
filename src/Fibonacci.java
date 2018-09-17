
public class Fibonacci {
	public static void main(String[] args) {
		int [] arr = {0,1,2,3,4,6,-34};
		Fibonacci fibonnaci = new Fibonacci();
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+"th Fibonacci number is " + fibonnaci.fibNoRecurse(arr[i]));
		}
		
	}
	
	private long fibRecurse(long n) {
		if(n<=1) {
			return 1;
		}
		else {
			return fibRecurse(n-1)+fibRecurse(n-2);
		}
	}
	private long fibNoRecurse(int n) {
		if(n<=1) {
			return 1;
		}
		long arr[] = new long[n+2];
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2;i<=n;i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		return arr[n];
		
	}
}
