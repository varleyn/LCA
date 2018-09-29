
public class BinaryTree {
	
	
	public static BTNode lca(BTNode root, BTNode n1, BTNode n2){
		
		if(root == null) return null;
		
		if(root.getLeft() == null && root.getRight() == null){
			
			return null;
		}
		
		if(    (root.getLeft() == n1)  ||  (root.getLeft() == n2)
		    || (root.getRight() == n1) ||  (root.getRight() == n2)){
			
			return root;
		}
		
		BTNode left = BinaryTree.lca(root.getLeft(), n1, n2);
		BTNode right = BinaryTree.lca(root.getRight(), n1, n2);
		
		if( (left != null) && (right != null)) return root;
		if(left == null) return right;
		if(right == null) return left;
		
		return null;
		
	}

}
