package linkList;

public class SumOfLinks {
	linkList addList(linkList l1, linkList l2) {
		int len1 = size(l1);
		int len2 = size(l2);
		System.out.println("len1" + "   " + len1 + "len2" + "    " + len2);

		if (len1 > len2) {
			l2 = addZero(l2, len1 - len2);
		l2.displayList();
		} else {
			l1 = addZero(l1, len2 - len1);
		l1.displayList();
		}
		int carry=0;
		int partialsum=0;
		linkList list =new linkList();
		while(l1.first!=null && l2.first!=null){
			
			double sum= carry+l1.first.data + l2.first.data;
			
				carry=(int)(sum /10);
				if(sum >10){
					partialsum=(int)(sum % 10);
				}
				else{
					partialsum=(int) sum;
				}
				
				
			list.insertFirst(0, partialsum);
			
			
			
			l1.first=l1.first.next;
			l2.first=l2.first.next;
			
			
		}
		return list;

	}

	public int size(linkList l) {
		int size = 0;
		for (Link n = l.first; n != null; n = n.next)
			size++;
		return size;
	}

	public linkList addZero(linkList l, int zeros) {
		for (int i = 0; i < zeros; i++) {
			Link zero = new Link(0, 0);
			zero.next = l.first;
			l.first = zero;
		}

		return l;

	}

}

class SumOfLinksApp {
	public static void main(String[] args) {
		linkList l1 = new linkList(); // make list
		l1.insertFirst(1, 6);// insert link
		l1.insertFirst(2, 1);
		l1.insertFirst(3, 7);

		l1.displayList();

		linkList l2 = new linkList();
		l2.insertFirst(1, 2);// insert link
		l2.insertFirst(2, 9);
		l2.insertFirst(3, 5);

		l2.displayList();
		SumOfLinks sum = new SumOfLinks();
		linkList total=sum.addList(l1, l2);
		total.displayList();

	}
}