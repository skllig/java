public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	/** If 2 numbers in a row are the same, we add them together and make one large node.*/
	boolean flag = true;
	public void addAdjacent() {
		IntList p = this;
		if (p.rest == null || ! flag) return;
		while (p.rest != null) {
			if (p.first == p.rest.first) {
				p.first *= 2;
				p.rest = p.rest.rest;
				addAdjacent();
				break;
			} else {
				p = p.rest;
			}
		}
		flag = false;
	}

	public void insertFirst(int x) {
		IntList p = this;
		while (p.rest != null) {
			IntList next = new IntList(p.first * p.first, p.rest);
			p.rest = next;
			p = p.rest.rest;
		}
		IntList next = 	new IntList(p.first * p.first, new IntList(x, null));
		p.rest = next;
	}

	public String toString() {
		IntList p = this;
		String str = Integer.toString(p.first);
		while (p.rest != null) {
			str += " => ";
			p = p.rest;
			str += Integer.toString(p.first);
		}
		return str;
	}

	public static void main(String[] args) {
//		IntList L = new IntList(15, null);
//		L = new IntList(10, L);
//		L = new IntList(5, L);
//		System.out.println(L.get(100));
		IntList L = new IntList(2, null);
		L = new IntList(1, L);
		L = new IntList(1, L);
		L = new IntList(4, L);
		L = new IntList(5, L);
		System.out.println(L);
		L.addAdjacent();
		System.out.println(L);
		L.insertFirst(10);
		System.out.println(L);
		L.insertFirst(9);
		System.out.println(L);
	}
} 