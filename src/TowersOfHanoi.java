import java.util.Stack;


public class TowersOfHanoi {
	private Stack<Integer> disks;
		
	TowersOfHanoi() {
		disks =  new Stack<>();
	}
	public void moveDisks(int start, int mid, int end){
		if(n<=0){
			return;
		}
		if(n==1){
			System.out.println(disks[0]);
			return;
		}
		moveDisks(n-1,start,end,mid);
		System.out.println(disks);
		moveDisks(n-1,mid,start,end);
	}
	public void printDisks(){
		while(disks.peek() != null){
			System.out.println(disks.pop());
		}
	}
	
	public static void main(String[] args) {
		TowersOfHanoi[] toh = new TowersOfHanoi[3];
		toh[0].disks.push(4);
		toh[0].disks.push(3);
		toh[0].disks.push(2);
		toh[0].disks.push(1);
		toh[0].printDisks();
		System.out.println("--------");
		toh[1].printDisks();
		System.out.println("--------");
		toh[2].printDisks();
		System.out.println("--------");
		toh[0].disks.push(4);
		toh[0].disks.push(3);
		toh[0].disks.push(2);
		toh[0].disks.push(1);
		toh[0].moveDisks(toh[2]);
		toh[0].printDisks();
		System.out.println("--------");
		toh[1].printDisks();
		System.out.println("--------");
		toh[2].printDisks();
		System.out.println("--------");

	}

}
