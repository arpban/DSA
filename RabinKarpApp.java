class RabinKarp{
	int prime = 13;
	int d = 256; //max characters in language(i.e. acsii)
	
	public void search(String text, String pattrn){
		int n = text.length();
		int m = pattrn.length();
		System.out.println("length of text:"+n+" and length of pattrn:"+m);
		int h = (int) Math.pow(d,m-1) % prime;
		System.out.println("h:"+h);
		int pattrnArray[] = getIntArray(pattrn);
		int textArray[] = getIntArray(text);
		// System.out.println("pattrnArray:"+pattrnArray);
		// System.out.println("textArray:"+textArray);
		int pattrnHash = 0;
		int t[] = new int[n];
		t[0] = 0;
		for (int i=0; i<m ;i++ ) {
			pattrnHash = ( d*pattrnHash + pattrnArray[i] ) % prime;
			t[0] = ( d*t[0] + textArray[i] ) % prime;
		}
		System.out.println("pattrnHash: "+pattrnHash);
		System.out.println("t[0]: "+t[0]);
		//matching 
		for (int s=0; s <= n-m ; s++ ) {
			if (pattrnHash == t[s]) {
				System.out.println("patter occurs with shift "+s);
			}
			if(s < n-m){
				t[s+1] = ( d*(t[s]-textArray[s]*h) + textArray[s+m] )%prime;
				// t[s+1] = 0;
				// for (int i=0; i<m ;i++ ) {
				// 	t[s+1] = ( d*t[s+1] + textArray[s+1+i] ) % prime;
				// }
				if(t[s+1] <0)
					t[s+1] += prime;
				System.out.println("t["+(s+1)+"]: "+t[s+1] );
			}

		}
	}

	public int[] getIntArray(String s){
		char x[] = s.toCharArray();
		int z[] = new int[x.length];
		for (int i=0;i<x.length;i++ ) {
			z[i] = (int) x[i];
			System.out.print(z[i]+" ");
		}
		return z;
	}

}

class RabinKarpApp{
	public static void main(String[] args) {
		RabinKarp rk = new RabinKarp();
		rk.search("xxxxarpitxxxarpitxxxxar","ar");
	}
}