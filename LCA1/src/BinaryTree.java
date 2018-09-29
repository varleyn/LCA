
public class BinaryTree {
	
	//TODO: This algorithm will only work assuming both the nodes
	//      n1 and n2 are contained in the binary tree. If, for e.g,
	//      node n1 is not in the tree beginning at root but node
	//      n2 is, this algorithm will return the lowest ancestor (i.e parent) 
	//      of n2. As nodes n1 and n2 clearly have no common ancestors in this 
	//      situation, null should be returned.
	//         Fix this!!!
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
