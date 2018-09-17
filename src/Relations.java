import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Relations {

	public void printRelations(List<Pair> relList){
		
		Map<String,List<String>> map = new HashMap<>();
		Set<String> isInVaues =  new HashSet<>();
		
		for( Pair relation : relList){
			String first = relation.getFirst();
			String second = relation.getSecond();
			List<String> values;
			if(map.containsKey(first)){
				values = map.get(first);
			} else {
				values = new ArrayList<>();
				map.put(first, values);
			}
			values.add(second);
			isInVaues.add(second);
		}
		Set<String> keySet = map.keySet();
		for(String key: keySet){
				if(!isInVaues.contains(key)){
					System.out.println(key);
					printChildren(map,key);
				}
			}
		}
public void printChildren(Map<String,List<String>> map, String key){ 
	List<String> children = map.get(key);
	for(String child:children){
		System.out.print("\t");
		System.out.print(child);
		if(map.containsKey(child)){
			printChildren(map,child);
			map.remove(child);
		}
	}
	System.out.println();
}

	public static void main(String[] args) {
			Relations rel =  new Relations();
			List<Pair> relationList =  new ArrayList<>();
			relationList.add(new Pair("Cat","Persian"));
			relationList.add(new Pair("Mammal","Dog"));
			relationList.add(new Pair("Mammal","Cat"));
			relationList.add(new Pair("Dog","Poodle"));
			relationList.add(new Pair("Bird","Eagle"));
			rel.printRelations(relationList);


	}
}
class Pair{

	private String first;
	private String second;
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	Pair(String first, String second){
		this.first = first;
		this.second = second;
	}
}
