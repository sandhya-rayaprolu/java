

class Solution {
    public int solution(int[] A) {
        int sum = 0;
        int result = 0;
        for(int i=0;i<A.length;i++){
            sum += A[i];
        }
        int leftSum = A[0];
        int rightSum = sum-A[0];
        int minDiff =  rightSum-leftSum;
        System.out.println("i: 0");
        System.out.println("A[i]: "+A[0]);
        System.out.println("Diff: "+result);
        System.out.println("MinDiff: "+minDiff);
        for(int i=1;i<A.length;i++){
            leftSum += A[i];
            rightSum -= A[i];
            result = rightSum-leftSum;
            if (result < minDiff){
                minDiff = result;
            }
            System.out.println("i: "+i);
            System.out.println("A[i]: "+A[i]);
            System.out.println("Diff: "+result);
            System.out.println("leftSum: "+leftSum);
            System.out.println("rightSum: "+rightSum);
            System.out.println("MinDiff: "+minDiff);
        }
        return minDiff;
    }
    public int solutionEqui(int[] A) {
        // Get the total sum
        long total = 0;
        long leftSum = 0;
        long rightSum = 0;
        if(A.length==0){
        	return -1;
        }
        for(int i=0;i<A.length;i++){
            total += A[i];
        }
        rightSum = total-leftSum-A[0];
        if(leftSum == rightSum){
            return 0;
        }
        // Check the left and right sum to get the equilibrium point
        for(int i=1;i<A.length;i++){
            leftSum += A[i-1];
            rightSum = total-leftSum-A[i];
            if(leftSum == rightSum){
                return i;
            }
            System.out.println("leftSum: "+leftSum);
            System.out.println("rightSum: "+rightSum);
            System.out.println("i: "+i);            
        }
        // No equilibrium index found
        return -1;
    }
    public void solutionFizzBuzz(int N){
    for(int i=1;i<=N;i++){
        if(i%105==0){
            System.out.println("FizzBuzzWoof"); 
        }
        else if(i%35==0){
            System.out.println("BuzzWoof"); 
        }
        else if(i%21==0){
            System.out.println("FizzWoof"); 
        }
        else if(i%15==0){
            System.out.println("FizzBuzz"); 
        }
        else if(i%7==0){
            System.out.println("Woof");
        }
        else if(i%5==0){
            System.out.println("Buzz");
        }
        else if(i%3==0){
            System.out.println("Fizz");
        }
        else{
           System.out.println(i); 
        }
    }
    }
    private int reverse(int n){
    	int result = 0;
    	while(n > 0){
    		result = result*10+n%10;
    		n /= 10;
    	}
    	System.out.println("Reverse of: "+n+" is: "+result);
    	return result;
    }
    public int decimalZip(int A, int B) {    
    if((A == 0) || (A > 100000000)){
        return -1;
    }
    if((B == 0) || (B > 100000000)){
        return -1;
    }
    int reverseA = reverse(A);
    int reverseB = reverse(B); 
    int result = 0;
    while((reverseA > 0) || (reverseB > 0)){
        if(reverseA > 0){
            result = result*10+reverseA%10;
            reverseA /= 10;
        }
        if(reverseB > 0){
            result =  result*10+reverseB%10;
            reverseB /= 10;
        }
    }
    while((A%10 == 0) || (B%10 == 0)){
	    if(A%10 == 0){
			result = result*10;
			A /= 10;
		}
		if(B%10 == 0){
			result = result*10;
			B /= 10;
		}
    }
    if(result > 100000000){
        result = -1;
    }
    return result;
}
    private int reduce(int n, int r){
        int reduced = r*10+n%10;
        n /= 10;
        return reduced;
    }
    
        public boolean find(int[] A, int K) {
            int n = A.length;
            for (int i = 0; i < n - 1; i++) {
                if (A[i] + 1 < A[i + 1])
                    return false;
            }
            if (A[0] != 1 || A[n - 1] != K){
                return false;
            }
            return true;
        }
    
	public static void main(String[] args) {

		Solution soln =  new Solution();
		int arr[] = {1,1,1};
		//int arr[] = {3, 1, 2, 4, 3};
	//	int arr[]= {-1, 3, -4, 5, 1, -6, 2, 1};
	//	int arr[]= {1110,1110,3000,5000};
	//	System.out.println(soln.solutionEqui(arr));
		//soln.solutionFizzBuzz(24);
		//System.out.println(soln.decimalZip(123,67890));
		System.out.println(soln.find(arr, 2));
		//soln.reverse(607);

	}

}
