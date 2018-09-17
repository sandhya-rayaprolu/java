import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class IteratorFlattener {
	
	private Queue<Iterator<Integer>> itQueue;
	
	public IteratorFlattener(List<Iterator<Integer>> itList) {
		this.itQueue = new LinkedList<>();
		for( Iterator<Integer> iterator: itList){
			itQueue.add(iterator);
		}
	}
	
	public boolean hasNext(){
		return itQueue.peek().hasNext();
	}
	public Integer next(){
		Iterator<Integer> nextIt = itQueue.poll();
		itQueue.add(nextIt);
		return nextIt.next();
	}
	public static void main(String[] args) {
		Integer[] A = {1,2,3,4,5,6,7};
		Integer[] B = {11,21,31,41,51,61,71};
		Integer[] C = {12,22,32,42,52,62,72};
		Iterator<Integer> it1 = Arrays.asList(A).iterator();
		Iterator<Integer> it2 = Arrays.asList(B).iterator();
		Iterator<Integer> it3 = Arrays.asList(C).iterator();
		
		List<Iterator<Integer>> arList = new ArrayList<>();
		arList.add(it1);
		arList.add(it2);
		arList.add(it3);
		IteratorFlattener itFlat = new IteratorFlattener(arList);
		while(itFlat.hasNext()){
			System.out.println(itFlat.next());
		}
	}

}
