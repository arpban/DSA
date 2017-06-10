class Queue{
	private int maxSize;
	private long a[];
	private int front;
	private int rear;
	private int n;
	public Queue(int size){
		a = new long[size];
		maxSize = size;
		front = 0;
		rear = -1;
		n =0;
	}
	public void insert(long value){
		if(rear == maxSize-1)
			rear = -1;
		a[++rear] = value;
		n++;
	}
	public long remove(){
		long temp = a[front++];
		if(front == maxSize)
			front = 0;
		n--;
		return temp;
	}
	public long peekFront(){
		return a[front];
	}
	public boolean isEmpty(){
		return n == 0;
	}
	public boolean isFull(){
		return n == maxSize;
	}
	public int size(){
		return n;
	}
}
///////////////////////////////////////////////
class QueueApp{
	public static void main(String args[]){
		Queue q = new Queue(5);
		q.insert(10);
		q.insert(20);
		q.insert(30);
		q.insert(40);
		q.insert(50);
		while(!q.isEmpty()){
			System.out.println(q.remove());
		}
	}
}