import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree implements Iterator<Node> {

	private Node root;
	private Iterator<Node> iterator;
	
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	BinaryTree(Node root){
		if(root == null)
			return;
		this.root = root;
		iterator =  new BinaryTreeIterator(root);
	}
	public void addNode(Node node){
		Node currNode = root;
		while(currNode!=null){
			if(node.getData()<currNode.getData()){
				if(currNode.getLeft() == null){
					currNode.setLeft(node);
					return;
				} else{
					currNode = currNode.getLeft();
				}
			}
			else if(node.getData()>currNode.getData()){
				if(currNode.getRight() == null){
					currNode.setRight(node);
					return;
				} else{
					currNode = currNode.getRight();
				}
			}else return; //equal values not allowed, do nothing
		//	addNode(currNode);	
		}
	}
	public void printPreOrderTree(Node node){
		if(node==null){
			return;
		}
		System.out.println(node.getData());
		printPreOrderTree(node.getLeft());
		printPreOrderTree(node.getRight());
	}
	public void printInOrderTree(Node node){
		if(node==null){
			return;
		}
		printInOrderTree(node.getLeft());
		System.out.println(node.getData());
		printInOrderTree(node.getRight());
	}
	public void printPostOrderTree(Node node){
		if(node==null){
			return;
		}
		printPostOrderTree(node.getLeft());
		printPostOrderTree(node.getRight());
		System.out.println(node.getData());
	}
	public void printBFS(Node root){
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node node = queue.remove();
			System.out.println(node.getData());
			if(node.getLeft()!=null){
				queue.add(node.getLeft());
			}
			if(node.getRight()!=null){
				queue.add(node.getRight());
			}
		}
	}
	public void printDFSPreOrder(Node root){
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			System.out.println(node.getData());
			if(node.getRight()!=null){
				stack.push(node.getRight());
			}
			if(node.getLeft()!=null){
				stack.push(node.getLeft());
			}
		}
	}
/*	public void printDFSInOrder(Node root){
		Deque<Node> stack = new ArrayDeque<>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			System.out.println(node.getData());
			if(node.getRight()!=null){
				stack.push(node.getRight());
			}
			if(node.getLeft()!=null){
				stack.push(node.getLeft());
			}
		}
	}*/
/*	public void printDFSPostOrder(Node root){
		Deque<Node> stack = new ArrayDeque<>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			System.out.println(node.getData());
			if(node.getLeft()!=null){
				stack.push(node.getLeft());
			}
			if(node.getRight()!=null){
				stack.push(node.getRight());
			}
		}
	}*/
	public static void main(String[] args) {
		Node rootNode = new Node(50);
		BinaryTree bTree = new BinaryTree(rootNode);
		bTree.addNode(new Node(10));
		bTree.addNode(new Node(60));
		bTree.addNode(new Node(9));
		bTree.addNode(new Node(11));
		bTree.addNode(new Node(55));
		bTree.addNode(new Node(75));
		bTree.addNode(new Node(1000));
		bTree.printPreOrderTree(bTree.getRoot());
		System.out.println("------------------");
		bTree.printDFSPreOrder(bTree.getRoot());	
		System.out.println("------------------");
		bTree.printInOrderTree(bTree.getRoot());
		System.out.println("------------------");
		//bTree.printDFSInOrder(bTree.getRoot());	
		System.out.println("------------------");
		bTree.printPostOrderTree(bTree.getRoot());
		System.out.println("------------------");
		//bTree.printDFSPostOrder(bTree.getRoot());	
		System.out.println("------------------");
		bTree.printBFS(bTree.getRoot());

	}
	

}
class Node{

	private int data;
	private Node left;
	private Node right;
	
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
 class BinaryTreeIterator<Node> implements Iterator<Node>{

		private Stack<Node> stack;
		
		public BinaryTreeIterator(Node root) {
			if(root != null){
				stack =  new Stack<>();
				while(root != null){
					stack.push(root);
					root= root.left;
				}
			}
		}
		
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public Object next() {
			Node node = null;
			int result = Integer.MIN_VALUE;
			if(stack != null && !stack.isEmpty()){
				node  = stack.pop();
				result = node.getData();
				while(node.right != null){
					node = node.right;
					while(node!=null){
						stack.push(node);
						node = node.left;
					}
				}
			}
			return result;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}
}