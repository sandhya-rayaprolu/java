
public class Heap {
	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public int getHeapsize() {
		return heapsize;
	}

	public void setHeapsize(int heapsize) {
		this.heapsize = heapsize;
	}
	private int[] data;
	private int heapsize;
	
	Heap(int size){
		data = new int[size];
		heapsize=0;
	}
	
	public void insert(int value){
		heapsize++;
		data[heapsize-1] = value;
		bubbleUp(heapsize-1);
	}
	public int deleteMax(){
		int maxVal = data[0];
		data[0]=data[heapsize-1];
		sinkDown(0);
		return maxVal;
	}
	public void bubbleUp(int currIndex){
		while(data[currIndex]>data[getParentIndex(currIndex)]){
			int temp = data[getParentIndex(currIndex)];
			data[getParentIndex(currIndex)] = data[currIndex];
			data[currIndex] = temp;
			currIndex=getParentIndex(currIndex);
		}
	}
	public void sinkDown(int currIndex){
		if(currIndex >= heapsize){
			return;
		}
		int leftChildIndex = getLeftChildIndex(currIndex);
		int rightChildIndex = getRightChildIndex(currIndex);
		int minValChildIndex = -1;
		if(data[leftChildIndex]<data[rightChildIndex]){
			minValChildIndex = leftChildIndex;
		}else{
			minValChildIndex = rightChildIndex;
		}
		while(data[currIndex]<data[minValChildIndex]){
			int temp = data[minValChildIndex];
			data[minValChildIndex] = data[currIndex];
			data[currIndex] = temp;
			sinkDown(minValChildIndex);
		}
	}
	public int getParentIndex(int childIndex){
		return (childIndex-1)/2;
	}
	public int getLeftChildIndex(int parentIndex){
		return parentIndex*2+1;
	}
	public int getRightChildIndex(int parentIndex){
		return parentIndex*2+2;
	}
	public void printHeap(){
		for(int i=0;i<heapsize;i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Heap heap = new Heap(10);
		heap.insert(4);
		heap.insert(5);
		heap.insert(3);
		heap.insert(6);
		heap.insert(1);
		heap.printHeap();
		System.out.println(heap.deleteMax());
		heap.printHeap();
	}

}
