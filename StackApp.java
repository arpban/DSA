class StackX{
	private int maxsize;
	private long stackarray[];
	public int top;
	public StackX(int n){
		maxsize = n;
		stackarray = new long[maxsize];
		top = -1;
	}
	public void push(long value){
		stackarray[++top] = value;
	}
	public long pop(){
		return stackarray[top--];
	}
	public long peek(){
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

class StackApp{
	public static void main(String args[]){
		StackX stk = new StackX(10);
		stk.push(100);
		stk.push(90);
		stk.push(80);
		stk.push(70);
		stk.push(60);
		while(stk.top != -1){
			System.out.println(stk.pop());
		}
	}
}