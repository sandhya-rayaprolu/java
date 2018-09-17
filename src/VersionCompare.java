
public class VersionCompare {

    public int compareVersion(String version1, String version2) {
        int i=0;
        String [] v1 = version1.split("\\.");
        String [] v2 =  version2.split("\\.");
        while((i<v1.length)||(i<v2.length)){
            if((i<v1.length)&&(i<v2.length)){
                if(Integer.parseInt(v1[i])>Integer.parseInt(v2[i]))
                    return 1;
                else if(Integer.parseInt(v1[i])<Integer.parseInt(v2[i]))
                    return -1;
            }else if(i<v1.length){
                if(Integer.parseInt(v1[i]) != 0){
                    return 1;
                }
            }else if(i<v2.length){
                if(Integer.parseInt(v2[i]) != 0){
                    return -1;
                }
            }                
            i++;
        }
        return 0;
    }

	public static void main(String[] args) {
		VersionCompare vc = new VersionCompare();
		System.out.println(vc.compareVersion("1.0", "1.1"));

	}

}
