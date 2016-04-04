package tekstanalyse;

public class BinarySearchTree {
	Node root;
	
	public void addNode(int key, String name){
		Node newNode = new Node(key, name);
		
		if(root == null){
			root = newNode;
		}
		else{
			Node focusNode = root;
			
			Node parent;
			
			while(true){
				parent = focusNode;
				
				if(key < focusNode.key){
					focusNode = focusNode.leftChild;
					
					if(focusNode == null){
						parent.leftChild = newNode;
						return;
					}
				}
				else{
					focusNode = focusNode.rightChild;
					
					if(focusNode == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
		
	}
	
	public void inOrderTraverse(Node focusnode){
		if(focusnode != null){
			inOrderTraverse(focusnode.leftChild);
			
			System.out.println(focusnode);
			
			inOrderTraverse(focusnode.rightChild);
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
		
	   int key;
	   String name;
	   Node leftChild;
	   Node rightChild;
		
	   Node(int key, String name) {
	       this.key = key;
	       this.name = name;
	   }
	   
	   public String toString(){
			return name + " with key " + key;
		}
	}  
}
