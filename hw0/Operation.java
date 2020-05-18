class Operation{
	/**iterate an int array and return the maximum*/
	private static int max_iter(int[] a){
		int res = Integer.MIN_VALUE;
		for (int i: a){
			res = Math.max(res, i);
		}
		return res;
	}
	/**while version*/
	private static int max_while(int[] a){
		int res = Integer.MIN_VALUE;
		int length = a.length;
		int cur = 0;
		while (cur < length){
			res = Math.max(res, a[cur]);
			cur += 1;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 0};
		int res = max_iter(a);
		System.out.println(res);
		System.out.println();
		res = max_while(a);
		System.out.println(res);
	}
}