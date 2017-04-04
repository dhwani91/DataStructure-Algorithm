package graph;

class StackX {

	private final int SIZE = 20;
	private int[] st;
	private int top;

	public StackX() {

		st = new int[SIZE];
		top = -1;
	}

	public void push(int i) {
		st[++top] = i;
	}

	public int peek() {
		return st[top];
	}

	public int pop() {
		return st[top--];
	}

	public boolean isEmpty() {
		return (top == -1);

	}
}

class QueueX {
	private int size = 20;
	private int[] que;
	private int rear;
	private int front;

	public QueueX() {
		rear = -1;
		front = 0;
		que = new int[size];
	}

	public void insert(int j) {
		if (rear == size - 1) {
			rear = -1;
			que[++rear] = j;
		}
	}

	public int remove() {
		int temp = que[front++];
		if (front == size) {
			front = 0;
		}
		return temp;
	}
public boolean isEmpty(){
	return (rear+1==front || (front+size-1==rear));
		
}
}

class Vertex {
	public char label;
	public boolean wasVisited;

	public Vertex(char lab) {
		label = lab;
		wasVisited = false;

	}
}

public class Graph {
	public int max_vertex = 20;
	public Vertex vertexList[];
	public int adjList[][];
	public int nVertex;
	StackX st;

	public Graph() {
		vertexList = new Vertex[max_vertex];
		adjList = new int[max_vertex][max_vertex];
		nVertex = 0;
		for (int i = 0; i < max_vertex; i++) {
			for (int k = 0; k < max_vertex; k++) {
				adjList[i][k] = 0;
				st = new StackX();
			}
		}
	}

	public void addVertex(char label) {
		vertexList[nVertex++] = new Vertex(label);
	}

	public void addEdge(int start, int end) {
		adjList[start][end] = 1;
		adjList[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	public void dfs() {

		vertexList[0].wasVisited = true;
		displayVertex(0);
		st.push(0);

		while (!st.isEmpty()) {
			int v = getAdjUnvisitedVertex(st.peek());
			if (v == -1) {
				st.pop();
			} else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				st.push(v);
			}

		}
		for (int j = 0; j < nVertex; j++) {
			vertexList[j].wasVisited = false;
		}

	}

	public int getAdjUnvisitedVertex(int k) {
		for (int i = 0; i < max_vertex; i++) {
			if (adjList[k][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}

}

class DfsApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();

		theGraph.addVertex('a');
		theGraph.addVertex('b');
		theGraph.addVertex('c');
		theGraph.addVertex('d');
		theGraph.addVertex('e');

		theGraph.addEdge(0, 1);
		theGraph.addEdge(1, 2);
		theGraph.addEdge(0, 3);
		theGraph.addEdge(3, 4);
		System.out.print("Visits :");
		theGraph.dfs();
	}

}
