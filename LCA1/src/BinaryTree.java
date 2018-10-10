/*
 * Note this version of the lca algorithm assumes a node cannot be an ancestor of itself.
 * 
 * The worst case time complexity for the currently implemented algorithm is O(n).
 * A more efficient implementation should be considered if it is to be used with
 * large binary trees.
 * 
 * 
 *  Approach:
 *    The basic algorithm used is based on that at www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/ (Method 2)
 *    
 *    The tree is traversed, starting with the root. If root is a parent of either node, n1 or n2, then root is the LCA
 *    (assuming both nodes are present). After all, the lowest common ancestor could not be lower in the tree than the lowest
 *    ancestor (parent) of one of the nodes.
 *    
 *    Otherwise, (where the root is not a parent of n1 nor n2), we recursively find the LCA (of n1 and n2) in the left subtree
 *    and in the right subtree. If one node is present in each of these left and right subtrees (i.e. LCA returns non-null for both),
 *    then root is the LCA. If both nodes are in the left subtree (i.e. LCA returns non-null for left subtree but null for right) 
 *    then the LCA of n1 and n2 in the root tree is equal to the LCA of these nodes in the left subtree. Similarly, when both nodes 
 *    are in right subtree, LCA is equal to LCA of right subtree. If LCA returns null for both left and right subtree (i.e. n1 and 
 *    n2 are absent in both subtrees), then null is returned.
 *    
 *    Modification: 
 *     To ensure that null is returned as LCA where only one node is present, we have two boolean variables, n1Present and n2Present,
 *     initially set to false. These get set to true on traversing n1 and n2, respectively.
 *       If, however, at the end of the above algorithm, one of n1Present or n2Present is still false, it is not always the case that 
 *     the corresponding node is absent. For this node could actually be present in the tree at a position below the parent (i.e., 
 *     lowest ancestor) of the other node. For this reason, we search below this point in this case.
 *     
 *    Only if both n1 and n2 have been shown to be present, do we return the lca node found. Otherwise, we return null.
 *    
 */
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
			
			if( search(result.getLeft(), n2) || search(result.getRight(), n2) ){
				
				n1Present = false;   //reset n1Present for next time
				return result;       
			}
			
			else{ 
				
				n1Present = false;   //reset n1Present for next time
				return null;
			}
			
		}
		
		if(n2Present && !n1Present){
			
			if( search(result.getLeft(), n1) || search(result.getRight(), n1) ){
				
				n2Present = false;     //reset n2Present for next time
				return result;
			}
			
			else{
				
				n2Present = false;     //reset n2Present for next time
				return null;
			}
		}
		
		//if(!n1Present && !n2Present)
		return null;         
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
	
	
	public static Boolean search(BTNode root, BTNode node){
		
		if(root == null)   return false;
		if(root == node)   return true;
		return (search(root.getLeft(), node) || search(root.getRight(), node));
		
	}

}
