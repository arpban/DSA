class ArrayBubble{
	private long[] a;
	private int n;
	ArrayBubble(int max){
		a = new long[max];
		n = 0;
	}
	public void insert(long value){
		a[n] = value;
		n++;
	}
	public void display(){
		for(int i=0; i<n;i++){
			System.out.print(a[i] + "  ");
		}
		System.out.println();
	}
	public void bubbleSort(){
		int in, out;
		for(out = n-1; out>0; out--){
			for(in = 0; in<out;in++){
				if(a[in]>a[in+1])
					swap(in,in+1);
			}
			display();
		}
	}
	public void swap(int x, int y){
		long temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
class BubbleSortApp{
	public static void main(String args[]){
		ArrayBubble arr = new ArrayBubble(100);
		arr.insert(20);
		arr.insert(30);
		arr.insert(50);
		arr.insert(10);
		arr.insert(70);
		arr.insert(5);

		arr.display();
		System.out.println("_________________________________");
		arr.bubbleSort();
		System.out.println("_________________________________");
		arr.display();

	}
}