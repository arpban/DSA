class Node{
		public int data;
		Node left;
		Node right;
		public Node(int d){
			this.data = d;
			left = null;
			right = null;
		}			
	}
////////////////////////////////////////////////////////////////////////////
class BinarySearchTree{
	public Node root;
	public BinarySearchTree(){
		root = null;
	}
	public boolean isEmpty(){
		return root == null;
	}
	public Node findMin(Node t){
		if(t==null)
			return null;
		else if(t.left == null)
			return t;
		return findMin(t.left);
	}
	public Node find(int x){
		return find(x,root);
	}
	public Node find(int x, Node t){
		if (x < t.data) {
			return find(x,t.left);
		}
		else if (x > t.data) {
			return find(x, t.right);
		}
		else if (x == t.data) {
			return t;
		}
		else 
			return null;
	}
	public void insert(int x){
		root = insert(x, root);
	}
	public void remove(int x){
		remove(x, root);
	}
	public void remove(int x, Node t){
		// if (x < t.data) {
		// 	t.left = remove(x, t.left);
		// }
		// if (x> t.data) {
		// 	t.right = remove(x, t.right);
		// }
		Node toBeDel = find(x);
		Node replacingBy = findMin(toBeDel.right);
		toBeDel.data = replacingBy.data;
		remove(replacingBy.data, toBeDel);
		if(toBeDel == null)
			return;
	}
	public Node insert(int x, Node t){
		
		if(t == null)
			return new Node(x);
		if(x < t.data)
			t.left = insert(x,t.left);
		else if(x > t.data)
			t.right = insert(x,t.right);
		else
			System.out.println("Duplicate nodes not allowed.");
		return t;
	}
	public void inOrder(Node t){
		if(t != null){
			inOrder(t.left);
			System.out.print(" "+t.data+" ");
			inOrder(t.right);
		}
	}
}
///////////////////////////////////////////////////////////////////////////////////
class BSTApp{
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(25);
		bst.insert(100);
		bst.insert(30);
		bst.insert(7);
		bst.inOrder(bst.root);
		bst.remove(30);
		bst.inOrder(bst.root);
	}
}