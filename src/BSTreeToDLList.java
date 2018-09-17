
public class BSTreeToDLList {

	public void convertToLinkList(Node root, LinkList dll){
		LinkList dll = new LinkList();
		Node leftNode = root;
		if(leftNode.getLeft() = null){
			dll.add(leftNode);
			return;
		}
		convertToLinkList(leftNode.getLeft(),dll);
		convertToLinkList(leftNode.getRight(),dll);	
		}
	}
	
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

	}

}
