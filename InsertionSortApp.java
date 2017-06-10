class ArrayInsertionSort{
	private long[] a;
	private int n;
	ArrayInsertionSort(int max){
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
	public void insertionSort(){
		int out, in;
		for(out = 1; out< n; out++){
			long temp = a[out];
			in = out;
			while(in>0 && a[in-1]>=temp){
				a[in] = a[in-1];
				--in;
			}
			a[in] = temp;
			display();
		}
	}
	public void swap(int x, int y){
		long temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
class InsertionSortApp{
	public static void main(String args[]){
		ArrayInsertionSort arr = new ArrayInsertionSort(100);
		arr.insert(20);
		arr.insert(30);
		arr.insert(50);
		arr.insert(10);
		arr.insert(70);
		arr.insert(5);

		arr.display();
		System.out.println("_________________________________");
		arr.insertionSort();
		System.out.println("_________________________________");
		arr.display();

	}
}