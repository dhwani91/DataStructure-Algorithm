package mergesort;
/**
 * File Name: SlistMergeSort.java Sort int slist using Merge Sort
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */

/*
 * To compile you require: IntUtil.java RandomInt.java IntSlist2.java
 * SlistSort.java SlistMergeSort.java
 */

class SlistMergeSort extends SlistSort {

	public node findMiddleNode(node first) {
		node slw_ptr = first;
		node fast_ptr = first;
		while (fast_ptr != null && fast_ptr.next != null && fast_ptr.next.next != null) {
			slw_ptr = slw_ptr.next;
			fast_ptr = fast_ptr.next.next;
		}
		return slw_ptr;
	}

	public node mergeSortLinkList(node first) {
		if (first == null || first.next == null)
			return first;
		node mid = findMiddleNode(first);
		node midNext = mid.next;
		mid.next = null;
		node left = mergeSortLinkList(first);
		node right = mergeSortLinkList(midNext);
		return mergeRecursive(left, right);
	}

	public node mergeRecursive(node left, node right) {
		if (left == null)
			return right;

		if (right == null)
			return left;

		node temp = null;

		if (left.d <= right.d) {
			temp = left;
			temp.next = mergeRecursive(left.next, right);
		} else {
			temp = right;
			temp.next = mergeRecursive(left, right.next);
		}
//		if(-(left.d)<=-(right.d)){
//			temp=right;
//			temp.next=mergeRecursive(left, right.next);
//		}else{
//			temp=left;
//			temp.next=mergeRecursive(left.next, right);
//		}
		return temp;
	}

	@Override
	protected void sort(boolean ascend) {
		node start = a.first;
		node sortedNode = mergeSortLinkList(start);
		a.first = sortedNode;
		printList(sortedNode);

	}

	public void printList(node sortedNode) {
		node temp = sortedNode;
		while (temp != null) {
			System.out.print(temp.d + "-> ");
			temp = temp.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		System.out.println("SlistMergeSort.java");
		SlistMergeSort u = new SlistMergeSort();
		System.out.println();
		u.testBench();
	}
}
