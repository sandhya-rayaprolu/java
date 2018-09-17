
public class PageRange {
	
	private int maxPages;
	private int numPages;
	
	PageRange(int max, int numPages){
		this.maxPages = max;
		this.numPages = numPages;
	}
	int[] getDisplayRange(int current){
		int[] result = {1,maxPages};
		int minPage = current - numPages/2;
		if(minPage < 0){
			minPage = 1;
		}
		int maxPage = minPage + numPages-1;	
		if(maxPage > maxPages){
			maxPage = maxPages;
		}
		result[0] = minPage;
		result[1] = maxPage;
		return result;
	}
	
	public static void main(String[] args) {
		PageRange pr = new PageRange(100, 10);
		int[] displayRange = pr.getDisplayRange(161);
		System.out.println(displayRange[0] + "-"+displayRange[1]);
	}

}
