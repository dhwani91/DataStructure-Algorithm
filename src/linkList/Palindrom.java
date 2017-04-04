package linkList;

import java.util.LinkedList;

public class Palindrom {
	  Node head;  // head of list
	  Node slow_ptr, fast_ptr,second_half;
	 
	    /* Linked list Node*/
	    class Node 
	    {
	        char data;
	        Node next;
	 
	        Node(char d) 
	        {
	            data = d;
	            next = null;
	        }
	    }
	    public boolean isPalindrom(Node head){
	    	return true;
	    }
	    
	    public void push(char new_data) 
	    {
	        /* Allocate the Node &
	           Put in the data */
	        Node new_node = new Node(new_data);
	 
	        /* link the old list off the new one */
	        new_node.next = head;
	 
	        /* Move the head to point to new Node */
	        head = new_node;
	    }
	 
	    // A utility function to print a given linked list
	    void printList(Node ptr) 
	    {
	        while (ptr != null) 
	        {
	            System.out.print(ptr.data + "->");
	            ptr = ptr.next;
	        }
	        System.out.println("NULL");
	    }
}
class PalindromApp{
	  public static void main(String[] args) {
	         
	        /* Start with the empty list */
	        Palindrom llist = new Palindrom();
	 
	        char str[] = {'a', 'b', 'a', 'c', 'a', 'b', 'a'};
	        String string = new String(str);
	        for (int i = 0; i< 7 ; i++) {
	            llist.push(str[i]);
	            llist.printList(llist.head);
	            if (llist.isPalindrom(llist.head) != false) 
	            {
	                System.out.println("Is Palindrome");
	                System.out.println("");
	            }
	             else
	            {
	                System.out.println("Not Palindrome");
	                System.out.println("");
	            }
	        }
	    }
}
