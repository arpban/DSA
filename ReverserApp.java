import java.util.Scanner;

class StackX{
	private int maxsize;
	private char stackarray[];
	public int top;
	public StackX(int n){
		maxsize = n;
		stackarray = new char[maxsize];
		top = -1;
	}
	public void push(char value){
		stackarray[++top] = value;
	}
	public char pop(){
		return stackarray[top--];
	}
	public char peek(){
		return stackarray[top];
	}
	public boolean isEmpty(){
		return (top == -1);
	}
	public boolean isFull(){
		return (top == maxsize-1);
	}
}

/////////////////////////////////////////////////////////

class Reverser{
	private String str;
	private StackX stk;
	public Reverser(String s){
		str = s;
		stk = new StackX(str.length());
	}
	void display(){
		char c;
		for(int j=0; j<str.length(); j++){
			stk.push(str.charAt(j));
		}
		String out = "";
		while(!stk.isEmpty()){
			out+=stk.pop();
		}
		System.out.println(out);
	}
}

/////////////////////////////////////////////////////////

class ReverserApp{
	public static void main(String args[]){
		
		Scanner scn = new Scanner(System.in);
		while(true){
			String str = scn.nextLine();
			Reverser rev = new Reverser(str);
			rev.display();
		}

	}
}