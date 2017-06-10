class OrdArray{
	private long[] a;
	private int n;
	public OrdArray(int max){
		a = new long[max];
		n = 0;
	}
	public int size(){
		return n;
	}
	public int find(long searchKey){
		int lowerBound = 0;
		int upperBound = n-1;
		int curIn;
		while(true){
			curIn = (lowerBound+upperBound)/2;
			if(a[curIn]==searchKey)
				return curIn;
			else if(lowerBound>upperBound)
				return n; //cant find it
			else
				if(searchKey > a[curIn]){
					lowerBound = curIn + 1;
				}
				else{
					upperBound = curIn -1;
				}

		}
	}

	public void insert(long value){
		int j;
		for( j=0;j<n;j++ ){
			if(a[j]>value)
				break;
		}
		for(int k=n;k>j;k--){
			a[k] = a[k-1];
		}
		a[j] = value;
		n++;
	}

	public boolean delete(long value){
		int j = find(value);
		if(j==n)
			return false;
		else{
			for(int k=j;k<n;k++){
				a[k] = a[k+1];
			}
			n--;
			return true;
		}
	}

	public void display(){
		for(int i =0 ;i<n;i++){
			System.out.println(a[i]);
		}
	}
}

class OrderedArrayApp{
	public static void main(String args[]){
		int maxSize = 100;
		OrdArray arr = new OrdArray(maxSize);
		arr.insert(30);
		arr.insert(10);
		arr.insert(50);
		arr.insert(0);
		arr.insert(20);
		arr.insert(300);
		arr.insert(500);
		arr.insert(90);

		int i = arr.find(20);
		System.out.println(i);
		System.out.println();
		arr.display();

	}
}