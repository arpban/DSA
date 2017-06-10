import java.io.*;
import java.util.*;
class Node{
	public Node left;
	public Node right;
	public long data;
	public Node(long data){
		this.data = data;
	}
	public void displayNode(){
		System.out.print(data + "  ");
	}
}
///////////////////////////////////////////////////////////////////////////
class Tree{
	public Node root;
	public Tree(){
		root = null;
	}
	public boolean find(long key){
		Node current = root;
		while(current.data != key){
			if(key<current.data)
				current = current.left;
			else
				current = current.right;
			if(current == null)
				return false;
		}
		return true;
	}
	public void insert(long key){
		Node newnode = new Node(key);
		if(root==null)
			root = newnode;
		else{
			Node current = root;
			Node parent;
			while(true){
				parent = current;
				if(key<current.data){
					current = current.left;
					if(current==null){
						parent.left = newnode;
						return;
					}
				}
				else{
					current = current.right;
					if(current==null){
						parent.right = newnode;
						return;
					}
				}
			}
		}
	}
	public void traverse(int traverseType){
		switch (traverseType) {
			case 1: System.out.println("Preorder traversal");
					preOrder(root);
					break;
			case 2: System.out.println("inorder traversal");
					inOrder(root);
					break;
			case 3: System.out.println("Postorder traversal");
					postOrder(root);
					break;				
		}
		System.out.println();
	}
	private void preOrder(Node localroot){
		if(localroot!=null){
			System.out.print(localroot.data + " ");
			preOrder(localroot.left);
			preOrder(localroot.right);
		}
	}
	private void inOrder(Node localroot){
		if(localroot!=null){
			inOrder(localroot.left);
			System.out.print(localroot.data+" ");
			inOrder(localroot.right);
		}
	}
	private void postOrder(Node localroot){
		if(localroot!=null){
			postOrder(localroot.left);
			postOrder(localroot.right);
			System.out.print(localroot.data+" ");
		}
	}
}
///////////////////////////////////////////////////////////////////////
class TreeApp{
	public static void main(String[] args) throws IOException {
		Tree t = new Tree();
		t.insert(10);
		t.insert(1);
		t.insert(30);
		t.insert(20);
		t.insert(50);
		while(true){
			System.out.println("type 1 for preOrder traversal, 2 for inOrder, 3 for postOrder and ctrl c to exit.");	
			int i = getInt();
			t.traverse(i);
		}
	}
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
}