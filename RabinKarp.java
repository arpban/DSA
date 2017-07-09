class RabinKarp{
	int prime = 101;
	int d = 256; //max characters in language(i.e. acsii)
	
	public static void search(String text, String pattrn){
		int n = text.length();
		int m = pattrn.length();
		int h = (int) Math.pow(d,m-1) % prime;
		int pattrnArray[] = getIntArray(pattrn);
		int textArray[] = getIntArray(text);
		int pattrnHash = 0;
		int t[] = new int[n];
		t[0] = 0;
		for (int i=0; i<m ;i++ ) {
			pattrnHash = ( d*pattrnHash + pattrnArray[i] ) % prime;
			t[0] = ( d*t[0] + textArray[i] ) % prime;
		}
		//matching 
		for (int s=0; s <= n-m ; s++ ) {
			if (pattrnHash == t[s]) {
				System.out.println("patter occurs with shift "+s);
			}
			t[s+1] = ( d*(t[s]-textArray[s]*h) + textArray[s+m+1] )%prime;
		}
	}

	public static int[] getIntArray(String s){
		char x[] = s.toCharArray();
		int z[] = new int[x.length];
		for (int i=0;i<x.length;i++ ) {
			z[i] = (int) x[i];
		}
		return z;
	}

	public static void main(String[] args) {
		RabinKarp rk = new RabinKarp();
		rk.search("arpitbansal","arp");
	}

}