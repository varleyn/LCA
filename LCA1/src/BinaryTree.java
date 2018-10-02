
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
	
	
	public static Boolean search(BTNode root, BTNode node){
		
		if(root == null)   return false;
		if(root == node)   return true;
		return (search(root.getLeft(), node) || search(root.getRight(), node));
		
	}

}
