package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brackets {
	private int maxsize;
	private int top;
	private char[] stackArray;

	public Brackets(int size) {
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
class BracketChecker{
	private String input;
	
	public BracketChecker(String in){
		input=in;
	}
	public void check(){
		int stacklen=input.length();
		Brackets theStack= new Brackets(stacklen);
		for (int i=0;i<input.length();i++){
			char ch=input.charAt(i);
			switch(ch){
			case '{':
			case '[':
			case '(':
			theStack.push(ch);
			break;
			case '}':
			case ']':
			case ')':
			
				if(!theStack.isEmpty()){
					char chx=theStack.pop();
					if((ch =='{' && chx !='}')||
					  (ch =='[' && chx !=']')||
					  (ch =='(' && chx !=')')){
						System.out.println("error :"+ch + "at "+i);
					}
					else
						System.out.println("error :"+ch + "at "+i);
				}
				
			default :
				break;
				
			}
		}
	}
}

class BracketApp{
	
public static void main(String[] args)throws IOException {
String input;
while(true){
	System.out.println("Enter a Containing Delimiters");
	System.out.flush();
	input=getstring();
	if(input.equals(""))
		break;
	BracketChecker theChecker=new BracketChecker(input);
	theChecker.check();
	
}
}
public static String getstring() throws IOException{
	InputStreamReader io= new InputStreamReader(System.in);
	BufferedReader br= new BufferedReader(io);
	String sr=br.readLine();
	return sr;
}
}