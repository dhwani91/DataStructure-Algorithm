/*  function to check if given binary tree is balanced or not?
 * balanced tree = height of two subtree of any node never differ by more than 1 */

 
package tree;

public class IsBalancedTree {
	TreeNode root;
	
	public static int checkHeight(TreeNode root){
		if(root== null){
			return 0;
		}
		//left is balanced
		int leftHeight=checkHeight(root.left);
		if(leftHeight==-1){
			return -1;
		}
		int rightHeight=checkHeight(root.right);
		if(rightHeight==-1){
			return -1;
		}
		int heightDiff=leftHeight-rightHeight;
		if(Math.abs(heightDiff)>1){
			return -1;
		}
		else{
			return Math.max(leftHeight, rightHeight) +1;
		}
	
		
	}
	public static boolean isBalance(TreeNode root){
		if(checkHeight(root)==-1){
			return false;
		}
		else{
			return true;
		}
		
	}

}
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
 }
class isBalanceApp{
	public static void main(String[] args) {
		IsBalancedTree app=new IsBalancedTree();
		app.root= new TreeNode(10);
		app.root.left=new TreeNode(5);
		app.root.left.left=new TreeNode(11);
		app.root.left.left.left=new TreeNode(9);
		app.root.right=new TreeNode(6);
		app.root.right.left=new TreeNode(8);
		app.root.right.right=new TreeNode(7);
		app.root.right.right.right=new TreeNode(4);
		int height=app.checkHeight(app.root);
		System.out.println("height : "+height);
		boolean isBalnce=app.isBalance(app.root);
		System.out.println("Tree is balanced    "+ isBalnce);
		
	}
}
