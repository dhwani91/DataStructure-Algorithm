package tree;
import tree.TreeNode;

public class SortedArrayBinarySearchtree {
	
public TreeNode creatMinimalBST(int arr[],int start,int end){
	if(end<start){
		return null;
	}
	int mid=(start + end)/2;
	TreeNode n = new TreeNode(arr[mid]);
	System.out.println(n.val);
	n.left=creatMinimalBST(arr, start, mid-1);
	n.right=creatMinimalBST(arr, mid+1, end);

	return n;
}

	
}
class App{
	public static void main(String[] args) {
		int arr[]= {0,1,2,3,4,5,6,7,8,9,10};
		int len=arr.length;
		System.out.println("array length:"+len);
		SortedArrayBinarySearchtree tree= new SortedArrayBinarySearchtree();
		TreeNode node=tree.creatMinimalBST(arr, 0, len-1);
		

	}
}

