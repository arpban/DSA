class ArraySelectionSort{
	private long[] a;
	private int n;
	ArraySelectionSort(int max){
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
	public void selectionSort(){
		int in, out, min;
		for(out = 0; out < n-1; out++){
			min = out;
			for(in = out+1; in<n; in++){
				if(a[in] < a[min])
					min = in;
			}
			swap(out,min);
			display();
		}
	}
	public void swap(int x, int y){
		long temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
class SelectionSortApp{
	public static void main(String args[]){
		ArraySelectionSort arr = new ArraySelectionSort(100);
		arr.insert(20);
		arr.insert(30);
		arr.insert(50);
		arr.insert(10);
		arr.insert(70);
		arr.insert(5);

		arr.display();
		System.out.println("_________________________________");
		arr.selectionSort();
		System.out.println("_________________________________");
		arr.display();

	}
}