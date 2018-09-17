
public class Palindrome {
	public boolean isPalindrome(String s){
		if (s==null || s.isEmpty())
				return false;
		if(s.length()==1)
			return true;
		int len = s.length();
		for(int i=0;i<len;i++){
			if(s.charAt(i)!=s.charAt(len-i-1)){
				return false;
			}
		}
			return true;	
	}
	public int minPalCount(String str){
		if (str==null || str.isEmpty())
			return 0;
		if(str.length()==1)
			return 1;
		int result=0;
		int min=0;	
		String left;
		String right;
		int len = str.length();
		for (int i = 0; i < str.length(); i++) {
			System.out.println(i+str);
			left = str.substring(0,i);
			right= str.substring(i+1, len - i-1);
			result = minPalCount(left)+minPalCount(right);
			if(result<min)
				min=result;
		}
		return min;
	}
	public static void main(String[] args) {
		Palindrome pal = new Palindrome();
		System.out.println(pal.isPalindrome("abcba"));
		System.out.println(pal.minPalCount("abcba"));

	}

}
