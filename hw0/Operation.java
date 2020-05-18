import java.util.Arrays;

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

	/** three sum with O(logn * n^2) time complexity */
	private static boolean three_sum(int[] a){
		int n = a.length;
		Arrays.sort(a);
		boolean res = false;
		for (int i = 0; i < n; i++){
			for (int j =0; j < n; j++){
				int k = Arrays.binarySearch(a, -(a[i] + a[j]));
				if (k >= 0){
					res = true;
					break;
				}
			}
		}
		return res;
	}

	private static boolean threeSumDistinct(int[] a){
		int n = a.length;
		Arrays.sort(a);
		boolean res = false;
		for (int i = 0; i < n; i++){
			for (int j = i + 1; j < n; j++){
				int k = Arrays.binarySearch(a, -(a[i] + a[j]));
				if (k > j){
					res = true;
					break;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 0};
		int res = max_iter(a);
		System.out.println("*** Iteration version of Max ***");
		System.out.println(res);

		System.out.println("*** While version of Max ***");
		System.out.println();
		res = max_while(a);
		System.out.println(res);

		System.out.println("*** testing for 3sum ***");
		System.out.println(three_sum(new int[] {-6, 2, 4}) == true);
		System.out.println(three_sum(new int[] {-6, 2, 5}) == false);
		System.out.println(three_sum(new int[] {-6, 3, 10, 200}) == true);
		System.out.println(three_sum(new int[] {8, 2, -1, 15}) == true);
		System.out.println(three_sum(new int[] {8, 2, -1, -1, 15}) == true);
		System.out.println(three_sum(new int[] {5, 1, 0, 3, 6}) == true);

		System.out.println("*** testing for threeSumDistinct ***");
		System.out.println(threeSumDistinct(new int[] {-6, 2, 4}) == true);
		System.out.println(threeSumDistinct(new int[] {-6, 2, 5}) == false);
		System.out.println(threeSumDistinct(new int[] {-6, 3, 10, 200}) == false);
		System.out.println(threeSumDistinct(new int[] {8, 2, -1, 15}) == false);
		System.out.println(threeSumDistinct(new int[] {8, 2, -1, -1, 15}) == true);
		System.out.println(threeSumDistinct(new int[] {5, 1, 0, 3, 6}) == false);

	}
}