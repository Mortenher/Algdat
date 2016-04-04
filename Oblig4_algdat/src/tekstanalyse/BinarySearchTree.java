package tekstanalyse;

public class BinarySearchTree {
	Node root;
	
	public BinarySearchTree(){}

	public void addNode(String value){
		
		if(root == null){
			root = new Node(value);
		}
		else{
			Node focusNode = root;
			
			while(true){
				int checknode = value.compareTo(focusNode.data);
				
				if(checknode < 0){
					if(focusNode.leftChild == null){
						focusNode.leftChild = new Node(value);
						return;
					}
					focusNode = focusNode.leftChild;
				}
				else if(checknode == 0){
					focusNode.key ++;
					return;
				}
				else{
					if(focusNode.rightChild == null){
						focusNode.rightChild = new Node(value);
						return;
					}
					focusNode = focusNode.rightChild;
				}
			}
		}
	}
	
	public void printTree(){
		if(root == null){
			System.out.println("treet er tomt");
		}
		else{
			printRecursive(root);
		}
	}   
	   
	public void printRecursive(Node n){
		if(n.leftChild != null){
			printRecursive(n.leftChild);
		}
		System.out.println(n.data + ": " + n.key);
		if(n.rightChild != null){
			printRecursive(n.rightChild);
		}
			
	} 
	   
	public Node findNode(int key){
		Node focusNode = root;
		
		while(focusNode.key != key){
			if(key < focusNode.key){
				focusNode = focusNode.leftChild;
			}
			else{
				focusNode = focusNode.rightChild;
			}
			if(focusNode == null){
				return null;
			}
		}
		return focusNode;
	}
	
	
	
	class Node {
		
	   String data;
	   int key;
	   Node leftChild;
	   Node rightChild;
		
	  public Node(String value) {
	       data = value;
	       key = 1;
	   }
	}  
}