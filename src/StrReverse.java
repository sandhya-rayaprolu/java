
public class StrReverse {
	 public String reverseWords(String s) {
	        String[] words = s.trim().split(" ");
	        if(words.length<=1){
	            return s.trim();
	        }
	        StringBuilder result =  new StringBuilder();
	        for(int i=0;i<words.length;i++){
	            if(!words[i].isEmpty()){
	                result.append(reverse(words[i]));
	                if(i<words.length-1){
	                    result.append(" ");
	                }
	            }
	        }
	        return reverse(result.toString());
	    }
	    public String reverse(String s){
	        char[] str = s.trim().toCharArray();
	        for(int i=0;i<str.length/2;i++){
	            char temp = str[i];
	            str[i] = str[str.length-i-1];
	            str[str.length-i-1]=temp;
	        }
	        return String.valueOf(str);
	    }
	public static void main(String[] args) {
		StrReverse strrev = new StrReverse();
		System.out.println("Reversed string:" + strrev.reverseWords("the sky is blue  ") + ":");
	}

}
