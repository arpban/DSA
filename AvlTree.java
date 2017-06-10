class Node{
	Node left;
	Node right;
	int data;
	int height;
	Node(int d){
		left,right = null;
		data = d;
		height = 1;
	}
}
////////////////////////////////////////////////////////////////
class AvlTree{
	Node root;
	AvlTree(){
		root = null;
	}

	int height(Node n){
		if(n == null)
			return 0;
		return n.height;
	}

	int max(int a, int b){
		return (a > b) : a ? b;
	}

	int balancingFactor(Node n){
		return height(n.left) - height(n.right);
	}

	Node leftRotate(Node x){
		Node y = x.right;
		x.right = y.left;
		y.left = x;
		//update heights
		x.height = max( height(x.left), height(x.right) ) + 1;
		y.height = max( height(y.left), height(y.right) ) + 1;
		return y;
	}

	Node rightRotate(Node x){
		Node y = x.left;
		x.left = y.right;
		y.right = x;
		//update heights
		x.height = max( height(x.left), height(x.right) ) + 1;
		y.height = max( height(y.left), height(y.right) ) + 1;
		return y;
	}

	public Node insert(Node node, int data){
		
	}	

}