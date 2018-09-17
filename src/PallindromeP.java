
public class PallindromeP {

	public boolean isPalindrome(String str){
		if(str == null || str.length() == 0){
			return false;
		}
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=str.charAt(str.length()-1-i)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		PallindromeP p = new PallindromeP();
		String str = "abbacad cab";
		StringBuilder strBuilder; 
		for(int i=0;i<str.length();i++)
		{
			strBuilder
			String newStr = 
			System.out.println(p.isPalindrome("abbacad cab"));
		}
	}
}
