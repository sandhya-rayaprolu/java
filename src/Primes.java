import java.util.ArrayList;
import java.util.List;


public class Primes {

	boolean isPrime[];
	public List<Integer> numPrimes(int n){
		List<Integer> result = new ArrayList<>();
		isPrime =  new boolean[n+1];
		for(int i=2;i<=n;i++){
			isPrime[i] = true;
		}
		for(int i=2;i*i<=n;i++){
			if(isPrime[i]){
				for(int j=i;i*j<=n;j++){
					isPrime[i*j]= false;
				}
			}
		}
		
		for(int i=0;i<=n;i++){
			if(isPrime[i]){
				result.add(i);
			}
		}
		return result;
	}
	public int getUgly(int n){
		int[] num = new int[n];
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		num[0] = 1;
		for(int i=1;i<n;i++){
			int next2 = num[i2]*2;
			int next3 = num[i3]*3;
			int next5 = num[i2]*5;
			int min =  Math.min(next2, Math.min(next3, next5));
			num[i]=min;
			if(min == next2) i2++;
			if(min == next3) i3++;
			if(min == next5) i5++;
		}
		return num[n-1];
	}
	
	
	public static void main(String[] args) {
		Primes primes =  new Primes();
		System.out.println(primes.numPrimes(100));
		//System.out.println(primes.getUgly(150));
	}

}
