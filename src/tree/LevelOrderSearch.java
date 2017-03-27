/* Algorithm
 * 1) empty queue
 * 2)temp node intialize start with root Node temp=root
 * 3)Loop while temp is not null
 * 		1)print root node
 * 		2)Enqueue children
 * 		3)Dequeue element and assign to temp
 * 
 * */


package tree;

import java.util.LinkedList;
import java.util.Queue;

import linkList.linkList;

class Link {
	int data;
	Link left, right;

	public Link(int item) {
		data = item;
		left = null;
		right = null;
	}
}

public class LevelOrderSearch {
	Link root;

	public void levelOrderSearch() {
		Queue<Link> queue = new LinkedList<Link>();
		Link temp = root;
		while (temp != null) {
			displayNode(temp);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
			temp=queue.poll();
		}
	}

	public void displayNode(Link curr) {
		System.out.print(" "+curr.data+ " ");
	}

}
class levelOrderSearchApp{
	public static void main(String[] args) {
		LevelOrderSearch search=new LevelOrderSearch();
		search.root=new Link(1);
		search.root.left=new Link(2);
		search.root.right=new Link(3);
		search.root.left.left=new Link(4);
		search.root.left.right=new Link(5);
		search.root.right.left=new Link(6);
		search.root.right.right=new Link(7);
		search.root.left.left.left=new Link(8);
		search.root.left.left.right=new Link(9);
		search.root.left.right.left=new Link(10);
		search.root.left.right.right=new Link(11);
		System.out.println("Level order traversal of binary tree is - ");
		search.levelOrderSearch();
	}
}
