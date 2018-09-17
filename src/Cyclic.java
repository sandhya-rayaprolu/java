
public class Cyclic {

	public boolean hasRotations(String[] strs){
		if(strs == null || strs.length == 0)
			return false;
		for(int i=0;i<strs.length;i++){
			for(int j=i+1;j<strs.length-1;j++){
				if((strs[i]+strs[i]).contains(strs[j])){
					System.out.println(strs[i]+":"+strs[j]);
					return true;
				}
		}
		}
		return false;
	}
public boolean areRotations(String str1, String str2){
	if(str1.contains(str2+str2))
		return true;
	else 
		return false;
}
	public static void main(String[] args) {
		String[] str = {"algorithms",   "polynomial",   "sortsuffix",   "boyermoore",
				"structures",   "minimumcut",   "suffixsort",   "stackstack",
				"binaryheap",   "digraphdfs",   "stringsort",   "digraphbfs"};
		Cyclic cy =  new Cyclic();
		System.out.println(cy.hasRotations(str));
	}

}
