/* Find link list is palindrom or not
 * 1)Reverese and compare
 * 2) using stack 
 * In below i used stack .keep fast pointer and slow pointer when fast pointer.add slow pointer in stack until when fast pointer reaches end.
 * Then compare stack data to slow pointer.
 * */

package linkList;
import java.util.Stack;

import linkList.linkList;



public class PalindromLink {
	
	public boolean ispalindrom(Link head){
		Link slw_ptr=head;
		Link fast_ptr=head;
		Stack<Integer> stack= new Stack<Integer>();

		while(fast_ptr!=null && fast_ptr.next!=null){
			stack.push((int) slw_ptr.data);
			slw_ptr=slw_ptr.next;
			fast_ptr=fast_ptr.next.next;
			
		}
		if(fast_ptr!=null){
			slw_ptr=slw_ptr.next;
		}
		while(slw_ptr!=null){
			int top=stack.pop();
			if(top!=slw_ptr.data){
				return false;
			}
			slw_ptr=slw_ptr.next;
		}
		return true;
	}



}
class PalindromLinkApp{
	public static void main(String[] args) {
		linkList thelist = new linkList(); // make list
		thelist.insertFirst(1,1);// insert link
		thelist.insertFirst(2, 2);
		thelist.insertFirst(3, 2);
		thelist.insertFirst(4, 1);
		thelist.displayList(); // display list
		PalindromLink pal=new PalindromLink();
		boolean flag=pal.ispalindrom(thelist.first);
		System.out.println("Linklist is palindrom :"+flag);
		
		
		
	}
}
