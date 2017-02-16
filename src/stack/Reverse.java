package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {
	private int maxsize;
	private int top;
	private char[] stackArray;

	public Reverse(int size) {
		maxsize = size;
		stackArray = new char[maxsize];
		top = -1;
	}

	public void push(char j) {
		stackArray[++top] = j;
	}

	public char pop() {
		return stackArray[top--];
	}

	public char peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxsize - 1);
	}
}
class Reverser{
	private String input;
	private String output;
	
	public Reverser(String in){
		input =in;
	}
	
	public String doReverse(){
		int length=input.length();
		Reverse stackArray= new Reverse(length);
		for (int i=0;i<input.length();i++){
			char ch=input.charAt(i);
			stackArray.push(ch);
		}
		output="";
		while(!stackArray.isEmpty()){
			char c= stackArray.pop();
			output= output + c;
		}
		return output;
			
		
	}
	
}

class ReverseApp{
	
public static void main(String[] args) throws IOException {
String input,output;
while(true){
	System.out.println("Enter a string");
	System.out.flush();
	input=getstring();
	if(input.equals(""))
		break;
	Reverser rev=new Reverser(input);
	output=rev.doReverse();
	System.out.println("Reversed:"+output);
}
}
public static String getstring() throws IOException{
	InputStreamReader io= new InputStreamReader(System.in);
	BufferedReader br= new BufferedReader(io);
	String sr=br.readLine();
	return sr;
}
}
