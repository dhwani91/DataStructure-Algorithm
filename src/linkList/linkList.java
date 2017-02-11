package linkList;

class Link {

	public int id; // data item(key)
	public double data;// data item
	public Link next;// next link in list

	public Link(int id, double data) // constructor for intialize index and data
	{
		this.id = id;
		this.data = data; // next set to null automatically

	}

	public void displayLink() {
		System.out.println("{" + id + " ," + data + " }");
	}
}

public class linkList {

	public Link first;
	public Link last;
	private Link current;
	// ref to first link in list

	public linkList() {
		first = null;
		last = null;// no items in list
	}

	public Boolean isEmpty() { // true if list is empty
		return (first == null);

	}

	public void insertFirst(int id, double data) { // insert at start of link
		Link newLink = new Link(id, data);
		if (!isEmpty()) {
			newLink.next = first;
			first = newLink;
		} else
			newLink.next = null;
			first = newLink; // first---->newLink
	}

	public void insertLast(int id, double data) {
		Link tail = new Link(id, data);
		Link current = first;
		if (first == null) {
			first = tail;

		} else {

			while (current.next != null) {
				current = current.next;

			}
			current.next = tail;
			tail.next = null;
		}

	}

	public Link insertAtPosition(int id, double data, int position) {
		Link newNode = new Link(id, data);
		Link current=first;
		if (first == null) {
			return newNode;
		}
		if (position == 0) {
			newNode.next = first;
			first = newNode;

		}
		int currentPos = 0;
		while (currentPos < position - 1 && first.next != null) {
			first = first.next;
			currentPos++;

		}
		Link NodeAtPos = first.next;
		first.next = newNode;
		newNode.next = NodeAtPos;

		return current;

	}

	public Link deleteFisrtLink() { // delete first item and assume list is not
									// empty

		Link temp = first; // save ref to link
		first = first.next; // delete it first --->old next
		return temp;// return deleted link
	}

	public void displayList() {
		System.out.println("List (first --->last): ");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");

	}

	public Link find(int key) { // find link with gven key(assume link list is
								// not empty)
		Link current = first;
		while (current.data != key) {
			if (current.next == null) {
				return null;

			} else
				current = current.next;
		}
		return current;
	}

	public Link delete(int key) { // delEte link wit given key
		Link current = first; // search for link
		Link previous = first;
		while (current.data != key) {
			if (current.next == null) { // didn't find
				return null;
			} else
				previous = current;
			current = current.next;

		}
		if (current == first) {
			first = first.next;
		} else
			previous.next = current.next;
		return current;

	}
	void  reverseLinklist( ){
		Link prevNode=null;
		Link currentNode=first;
		Link nextNode=null;
		while(currentNode.next!=null){
			nextNode=currentNode.next;
			currentNode.next=prevNode;
			prevNode=currentNode;
			currentNode=nextNode;
		
		}
		first=prevNode;
		displayList();
		
	}

}


class LinklIstApp {
	public static void main(String[] args) {
		System.out.println("hello");
		linkList thelist = new linkList(); // make list
		thelist.insertFirst(22, 100);
		thelist.insertFirst(66, 300);
		thelist.insertFirst(88, 400);
		thelist.insertLast(10, 500);
		thelist.insertLast(20, 600);
		thelist.insertLast(30, 700);
		thelist.reverseLinklist();
		thelist.insertAtPosition(40, 800,3);
		
		thelist.delete(800);
		thelist.displayList(); // display list

		Link find = thelist.find(400);
		if (find != null) {
			System.out.println("Found link with key" + find.data);
		} else
			System.out.println("Link not found");

		Link d = thelist.delete(300);
		if (d != null) {
			System.out.println("Deleted link with key" + d.data);
		} else
			System.out.println("Can't delete link list");
		thelist.displayList();
		thelist.reverseLinklist();
	}
}