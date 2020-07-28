 /** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class SLList {	
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
//			System.out.println(size);
		}
	} 

	/* The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;

	private static void lectureQuestion() {
		SLList L = new SLList();
		IntNode n = new IntNode(5, null);
	}

	/** Creates an empty SLList. */
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	public SLList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	public SLList(int[] lst) {
		sentinel = new IntNode(63, null);
		IntNode p = sentinel;
		for (int i = 0; i < lst.length; i ++) {
			p.next = new IntNode(lst[i], null);
			p = p.next;
			size += 1;
		}
	}

 	/** Adds x to the front of the list. */
 	public void addFirst(int x) {
 		sentinel.next = new IntNode(x, sentinel.next);
 		size = size + 1;
 	}

 	/** Returns the first item in the list. */
 	public int getFirst() {
 		return sentinel.next.item;
 	}

 	/** Adds x to the end of the list. */
 	public void addLast(int x) {
 		size = size + 1; 		

 		IntNode p = sentinel;

 		/* Advance p to the end of the list. */
 		while (p.next != null) {
 			p = p.next;
 		}

 		p.next = new IntNode(x, null);
 	}
	/** Delete the first element. */
 	public int deleteFirst() {
 		IntNode origin = sentinel.next;
		sentinel.next = origin.next;
		size -= 1;
		return origin.item;
	}
 	
 	/** Returns the size of the list. */
 	public int size() {
 		return size;
 	}

	public static void main(String[] args) {
 		/* Creates a list of one integer, namely 10 */
// 		SLList L = new SLList();
// 		L.addLast(20);
//		L.addLast(30);
//		System.out.println(L.deleteFirst());
// 		System.out.println(L.size());
		SLList lst = new SLList(new int[]{1, 2, 3});
		System.out.println(lst.size);
 	}
}