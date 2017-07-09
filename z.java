class z{
	public static int[] getIntArray(String s){
		char x[] = s.toCharArray();
		int z[] = new int[x.length];
		for (int i=0;i<x.length;i++ ) {
			z[i] = (int) x[i];
		}
		return z;
	}
	public static void main(String[] args) {
		int x[] = getIntArray("arpit");
	}
}