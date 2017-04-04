package linkList;

import java.util.HashSet;

public class RemoveDuplicateWithHash  {
	void removeduplicate(){
		HashSet<Integer>set=new HashSet<>();
		
	}




}
class RemoveduplicateWithHashApp{
public static void main(String[] args) {
	linkList thelist=new  linkList();
	thelist.insertFirst(1, 3);// insert link
	thelist.insertFirst(2, 4);
	thelist.insertFirst(3, 3);
	thelist.insertFirst(4, 5);
	thelist.insertFirst(5, 4);
	thelist.displayList();
	RemoveDuplicateWithHash rm= new RemoveDuplicateWithHash();
	rm.removeduplicate();
	
	
}
	
}

