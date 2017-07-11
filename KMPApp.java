//knuth morris pratt algorithm

class KnuthMorrisPratt{
	char T[];
	char P[];
	int pi[];
	void computePrefixFunction(char PattArray[]){
		int m = PattArray.length;
		pi = new int[m];
		pi[0] = 0;
		int k = 0;
		for(int i=1; i<m; i++){
			while( k>0 && (PattArray[k] != PattArray[i]) )
				k = pi[k-1];
			if(PattArray[k] == PattArray[i])
				k += 1;
			pi[i] = k;
		}
		// for ( int i=0; i<pi.length;i++){
		// 	System.out.print(pi[i]+" ");
		// }
		// System.out.println();
	}
	void search(String t, String p){
		T = t.toCharArray();
		P = p.toCharArray();
		int q = 0;
		computePrefixFunction(P);
		for(int i=0; i<T.length; i++){
			while( q>0 && (P[q] != T[i]) )
				q = pi[q-1];
			if(P[q]==T[i])
				q+=1;
			if(q==P.length){
				System.out.println("pattern occurs at "+ (i-P.length+1));
				q = pi[q-1];
			}		
		}
	}
}
///////////////////////////////////////////////////////////////////////////////////
class KMPApp{
	public static void main(String[] args) {
		KnuthMorrisPratt kmp = new KnuthMorrisPratt();
		kmp.search("abcxxxabcxxxabcxxxxxxxabccc","abc");
	}
}

