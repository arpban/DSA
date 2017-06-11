class Node{
	Node left;
	Node right;
	public int data;
	public int height;
	Node(int d){
		// left = null;
		// right = null;
		data = d;
		height = 0;
	}
}
////////////////////////////////////////////////////////////////
class AvlTree{
	Node root;
	
	public int height(Node n){
		if(n == null)
			return -1;
		return n.height;
	}

	public int max(int a, int b){
		return (a>b) ? a : b ;
	}

	public int balancingFactor(Node n){
		if(n==null){
			return 0;
		}
		return height(n.left) - height(n.right);
	}

	public Node leftRotate(Node x){
		Node y = x.right;
		x.right = y.left;
		y.left = x;
		//update heights
		x.height = max( height(x.left), height(x.right) ) + 1;
		y.height = max( height(y.left), height(y.right) ) + 1;
		return y;
	}

	public Node rightRotate(Node x){
		Node y = x.left;
		x.left = y.right;
		y.right = x;
		//update heights
		x.height = max( height(x.left), height(x.right) ) + 1;
		y.height = max( height(y.left), height(y.right) ) + 1;
		return y;
	}

	public Node insert(Node tmproot, int data){
		
		//performing normal BST insert.

		if(tmproot == null)
			return (new Node(data));

		if(data < tmproot.data)
			tmproot.left = insert(tmproot.left, data);
		else if(data > tmproot.data)
			tmproot.right = insert(tmproot.right, data);
		else
			return tmproot;

		//updating heights after normal BST insert.

		tmproot.height = max( height(tmproot.left), height(tmproot.right) ) + 1;

		//now performing rotations.

		if( balancingFactor(tmproot)>1 && data<tmproot.left.data )
			return rightRotate(tmproot);
		if( balancingFactor(tmproot)>1 && data<tmproot.right.data ){
			tmproot.left = leftRotate(tmproot.left);
			return rightRotate(tmproot);
		}
		if( balancingFactor(tmproot)<-1 && data>tmproot.right.data )
			return leftRotate(tmproot);
		if( balancingFactor(tmproot)<-1 && data>tmproot.left.data ){
			tmproot.right = rightRotate(tmproot.right);
			return leftRotate(tmproot);
		}

		return tmproot;
	}	

	public void preOrder(Node node){
		if(node != null)
		{
			System.out.print(node.data+"   ");
			preOrder(node.left);
			preOrder(node.right);
		}	
		
	}
}
/////////////////////////////////////////////////////////////////////////////////
class AvlTreeApp{
	public static void main(String[] args) {
		AvlTree tree = new AvlTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);

        System.out.println("preorder traversal of AVL tree :");
        tree.preOrder(tree.root);
	}
}