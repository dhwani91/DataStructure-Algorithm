package stack;

public class StackX {
	private int maxsize;
	private int top;
	private double[] stackArray;

	public StackX(int size) {
		maxsize = size;
		stackArray = new double[maxsize];
		top = -1;
	}

	public void push(double j) {
		stackArray[++top] = j;
	}

	public double pop() {
		return stackArray[top--];
	}

	public double peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxsize - 1);
	}
	
}
class Stackapp {
	public static void main(String[] args) {
		StackX stack = new StackX(10);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		while (stack.isEmpty()) {
			double pop = stack.pop();
			System.out.println(pop);
			System.out.println(" ");
		}
		System.out.println(" ");
	}
}