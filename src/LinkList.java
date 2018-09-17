
public class LinkList {
	LLNode head;
	public LLNode next(LLNode node){
		LLNode currNode = head;
		while(currNode.next != null && currNode.next.value != node.value){
			currNode = currNode.next;
		}
		return currNode.next.next;
	}
	public LLNode prev(LLNode node){
		LLNode currNode = head;
		while(currNode.next != null && currNode.next.value != node.value){
			currNode = currNode.next;
		}
		return currNode.next.prev;		
	}
	public void add(LLNode node){
		if(head == null){
			head = node;
		}else{
			LLNode currNode = head;
			while(currNode.next != null){
				currNode = currNode.next;
			}
			currNode.next = node;
			node.prev = currNode;
		}
	}
	public void remove(LLNode node){
		LLNode currNode = head;
		if(currNode == null) throw new IllegalStateException("Linked List is empty");
		while(currNode.next != null){
			currNode = currNode.next;
			if(currNode.value == node.value){
				currNode.next.prev = currNode.prev;
				currNode.prev.next = currNode.next;
			}
		}
		
	}
	public void print(){
		LLNode currNode = head;
		if(currNode == null) throw new IllegalStateException("Linked List is empty");
		while(currNode.next != null){
			System.out.println(currNode.value);
			currNode = currNode.next;
		}System.out.println(currNode.value);
	}
	public static void main(String[] args) {
		LinkList ll =  new LinkList();
		ll.add(new LLNode(7));
		ll.add(new LLNode(8));
		ll.add(new LLNode(6));
		ll.add(new LLNode(17));
		ll.add(new LLNode(711));
		ll.add(new LLNode(718));
		ll.print();
		ll.remove(new LLNode(6));
		ll.print();

	}

}
class LLNode{
	LLNode prev;
	LLNode next;
	int value;	
	
	LLNode(int value){
		prev = null;
		next = null;
		this.value= value;
	}
}