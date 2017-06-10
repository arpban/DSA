class CreateArray{
	private long a[];
	private int n;
	CreateArray(int max){
		a = new long[max];
		n = 0;
	}
	void insert(long value){
		a[n] = value;
		n++;
	}
	void insertAtPos(long value, int pos){
		int i;
		for(i=n;i>pos;i--){
			a[i] = a[i-1];
		}
		n++;
		a[pos] = value;
	}
	void display(){
		for(int i = 0; i<n ; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	void swap(int x, int y){
		long temp = a[y];
		a[y] = a[x];
		a[x] = temp;
	}
	void delete(long value){
		int i;
		for(i=0; i<n; i++){
			if(a[i]==value){
				for(int j = i; j < n; j++){
					a[j] = a[j+1];
				}
				n--;
			}
		}
	}
	void bubbleSort(){
		int out,in;
		for(out=n-1;out>0;out--){
			for(in=0;in<out;in++){
				if(a[in]>a[in+1])
					swap(in,in+1);
			}
		}
	}
	void selectionSort(){
		int out, in,min;
		for(out=0; out<n-1; out++){
			min = out;
			for(in=out+1;in<n;in++){
				if(a[in]<a[min])
					min = in;
			}
			swap(out,min);
		}
	}
	void insertionSort(){
		int in, out;
		for (out=1;out<n;out++){
			long temp = a[out];
			in = out;
			while(in>0 && a[in-1]>=temp ){
				a[in] = a[in-1];
				in--;
			}
			a[in] = temp;
		}
	}

}

class ArrAppTwo{
	public static void main(String args[]){
		CreateArray arr = new CreateArray(100);
		arr.insert(20);
		arr.insert(30);
		arr.insert(50);
		arr.insert(10);
		arr.insert(70);
		arr.insert(5);
		arr.display();
		arr.delete(50);
		arr.display();
		arr.insertAtPos(50,2);
		arr.display();
		arr.selectionSort();
		arr.display();

	}
}