
public class BinaryTree {
	
	public static Boolean n1Present = false;  //will be set to true once node n1 has been seen
	public static Boolean n2Present = false;  //will be set to true once node n2 has been seen
	
	public static BTNode lca(BTNode root, BTNode n1, BTNode n2){
		
		BTNode result = lca_helper(root, n1, n2);
		
		if (n1Present && n2Present){
			
			return result;
			
		}
		
		return null;
	}
	
	
	public static BTNode lca_helper(BTNode root, BTNode n1, BTNode n2){
		
		if(root == null) return null;
		
		if(root.getLeft() == null && root.getRight() == null){
			
			return null;
		}
		
		
		if( (root.getLeft() == n1)  ||  (root.getRight() == n1) ){
		    n1Present = true;
			return root;
		}
		
		if( (root.getLeft() == n2)  ||  (root.getRight() == n2) ){
		    n2Present = true;
			return root;
		}
		
		
		
		BTNode left = BinaryTree.lca_helper(root.getLeft(), n1, n2);
		BTNode right = BinaryTree.lca_helper(root.getRight(), n1, n2);
		
		if( (left != null) && (right != null)) return root;
		if(left == null) return right;
		if(right == null) return left;
		
		return null;
		
	}

}
