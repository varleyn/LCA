//TODO:  Refine lca algorithm to be able handle cases such as the following (1st test case):
                                 //                   a         
		                         //                 /   \               
		                         //                /     \
		                         //               /       \             lca(a, e, g)
		                         //              b         c
		                         //               \       /  \
		                         //                \     /    \
		                         //                 d   e      f
		                         //                           /
		                         //                          /
		                         //                         g

// where one of the nodes is below the parent (i.e. lowest ancestor) of the other node.
// Using the current algorithm, node g never gets visited. Upon visiting node e, the active recursive call returns 
// c because the lowest common ancestor of e and g could not be any lower than the lowest ancestor of e (which is c).
// Then because g has never been seen, the algorithm wrongly assumes it is not present in the tree and returns null
// as the lca instead of g.
//
// One possible solution would be (in the case where only one of the nodes has been visted at the end) to search the tree below 
// the lowest ancestor returned for the other node
	
public class BinaryTree {
	
	public static Boolean n1Present = false;  //will be set to true once node n1 has been seen
	public static Boolean n2Present = false;  //will be set to true once node n2 has been seen
	
	public static BTNode lca(BTNode root, BTNode n1, BTNode n2){
		
		BTNode result = lca_helper(root, n1, n2);
		
		if (n1Present && n2Present){
			
			n1Present = false;   //reset n1Present and n2Present for next time 
			n2Present = false;   //lca is called.
			
			return result;
			
		}
		
		if(n1Present && !n2Present){  //if n1 was found but not n2, check under result returned for n2
			                          //and if present return result. Otherwise, return null
			
			if(search(result, n2)){
				return result;
			}
			
			else{ 
				return null;
			}
		}
		
		if(n2Present && !n1Present){
			
			if(search(result, n1)){
				return result;
			}
			
			else{
				return null;
			}
		}
		
		n1Present = false;   //reset n1Present and n2Present for next time 
		n2Present = false;   //lca is called.
		
		return null;         //if(!n1Present && !n2Present)
	}
	
	
	private static BTNode lca_helper(BTNode root, BTNode n1, BTNode n2){
		
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
	
	
	private static Boolean search(BTNode root, BTNode node){
		
		if(root == node)   return true;
		if(root == null)   return null;
		return (search(root.getLeft(), node) || search(root.getRight(), node));
		
	}

}
