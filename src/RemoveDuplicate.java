import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class RemoveDuplicate {
	public String removeDupChars(String input){
		StringBuilder result = new StringBuilder();
		HashSet<Character> distintChars = new HashSet<>();
		for(int i=0;i<input.length();i++){
			if(distintChars.add(input.charAt(i))){
				result.append(input.charAt(i));
			}
		}
		return result.toString();
	}
	public Character getSingleOccurance(String input){
		Character result = null;
		Map<Character,Integer>  map = new HashMap<>();
		for(int i=0;i<input.length();i++){
			Character ch = input.charAt(i);
			int count = 0;
			if(map.containsKey(ch)){
				count = map.get(ch);
			}
			map.put(ch, ++count);
		}
		System.out.println(map);
		for(int i=0;i<input.length();i++){
			Character ch = input.charAt(i);
			if(map.get(ch)==1)
				return ch;
		}
		return result;
	}
	public Character getMaxOccurance(String input){
		Map<Character,Integer> map =  new HashMap<>();
		int maxCount = 0;
		Character maxChar = null;
		
		for(int i=0;i<input.length();i++){
			Character ch = input.charAt(i);
			int count = 0;
			if(map.containsKey(ch)){
				count = map.get(ch);
			}
			map.put(ch, ++count);
			if(count>maxCount){
				maxCount = count;
				maxChar = ch;
			}
		}
		System.out.println(map);
		return maxChar;
	}
	public static void main(String[] args) {
		RemoveDuplicate rd = new RemoveDuplicate();
		//System.out.println(rd.removeDupChars("Goboggle"));
		//System.out.println(rd.getSingleOccurance("google"));
		System.out.println(rd.getMaxOccurance("googleey"));
	}

}
