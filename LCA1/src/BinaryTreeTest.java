import static org.junit.Assert.*;

import org.junit.Test;


public class BinaryTreeTest {

	
	/*
	 * Tests that the lca method returns the correct lowest common ancestor
	 * when both of the specified nodes are present in the given binary tree
	 */
	@Test
	public void bothNodesPresentTest() {
		
		BTNode a = new BTNode();   //                   a         
		BTNode b = new BTNode();   //                 /   \               
		BTNode c = new BTNode();   //                /     \
		BTNode d = new BTNode();   //               /       \
		BTNode e = new BTNode();   //              b         c
		BTNode f = new BTNode();   //               \       /  \
		BTNode g = new BTNode();   //                \     /    \
		                           //                 d   e      f
		a.setLeft(b);              //                           /
		a.setRight(c);             //                          /
		b.setRight(d);             //                         g
		c.setLeft(e);              //
		c.setRight(f);
		f.setLeft(g);
		
		BTNode result = BinaryTree.lca(a, e, g); //result is assigned the lca of nodes e and g
		                              //in the binary tree with root a
		assertEquals(c, result);
	}
	
	
	/*
	 * Tests that the lca method returns null as the lowest common ancestor
	 * when the first node being searched for is not present in the given
	 * tree
	 */
	@Test
	public void firstNodeAbsent(){
		
		BTNode a = new BTNode();   //                            
		BTNode b = new BTNode();   //                   a                              
		BTNode c = new BTNode();   //                 /   \ 
		BTNode d = new BTNode();   //                /     \
		BTNode e = new BTNode();   //               /       \
		BTNode f = new BTNode();   //              b         c
		BTNode g = new BTNode();   //               \         \
		                           //                \         \
		                           //                 d         f
		a.setLeft(b);              //                          /
		a.setRight(c);             //                         /
		b.setRight(d);             //                        g
		c.setRight(f);             //
		f.setLeft(g);
		
        BTNode result = BinaryTree.lca(a,e,g);
      
        assertEquals(null,result);
		
	}
	
	/*
	 * Tests that the lca method returns null as the lowest common ancestor
	 * when the second node being searched for is not present in the given
	 * tree
	 */
	@Test
	public void secondNodeAbsent(){
		
		BTNode a = new BTNode();   //                   a         
		BTNode b = new BTNode();   //                 /   \               
		BTNode c = new BTNode();   //                /     \
		BTNode d = new BTNode();   //               /       \
		BTNode e = new BTNode();   //              b         c
		BTNode f = new BTNode();   //               \       /  \
		BTNode g = new BTNode();   //                \     /    \
		                           //                 d   e      f
		a.setLeft(b);              //                           
		a.setRight(c);             //                          
		b.setRight(d);             //                         
		c.setLeft(e);              //
		c.setRight(f);
		
		BTNode result = BinaryTree.lca(a, b, g);
		assertEquals(null,result);
	}
	
	
	/*
	 * Tests that the lca method returns null when both nodes being searched
	 * for are absent from the binary tree 
	 */
	@Test
	public void bothNodesAbsent(){
		
		BTNode a = new BTNode();   //                   a         
		BTNode b = new BTNode();   //                 /   \               
		BTNode c = new BTNode();   //                /     \
		BTNode d = new BTNode();   //               /       \
		BTNode e = new BTNode();   //              b         c
		BTNode f = new BTNode();   //                         \
		BTNode g = new BTNode();   //                          \
		                           //                           f
		a.setLeft(b);              //                          /
		a.setRight(c);             //                         /
		c.setRight(f);             //                        g
		f.setLeft(g);              //
		
		BTNode result = BinaryTree.lca(a, d, e);
		assertEquals(null,result);
	}
	
	/*
	 * Tests the lca method where one of the nodes we are looking
	 * for the lowest common ancestor of is the root of the tree
	 * (and hence has no ancestors - in this implementation we
	 * assume a node cannot be an ancestor of itself). 
	 * Should return null.
	 */
	@Test
	public void oneNodeIsRoot(){
                                              //          a         
		BTNode a = new BTNode();             //            \               
		BTNode b = new BTNode();             //             \
                                            //               \
        a.setRight(b);                      //                b
        
        BTNode result = BinaryTree.lca(a, a, b);
        assertEquals(null,result);
	}
	
	/*
	 * Tests what happens when we pass the same node twice to 
	 * the lca method rather than two different nodes.
	 * Should return the parent of the node passed in.
	 */
	@Test
	public void lcaSameNode(){
		
		BTNode a = new BTNode();   //                            
		BTNode b = new BTNode();   //                   a                              
		BTNode c = new BTNode();   //                 /   \ 
		BTNode d = new BTNode();   //                /     \
		                           //               /       \
		a.setLeft(b)  ;            //              b         c
		a.setRight(c);             //               \         
		b.setRight(d) ;            //                \         
		                           //                 d 
		
		BTNode result = BinaryTree.lca(a, d, d);
		assertEquals(b,result);
		
	}
	
	
	/*
	 * Tests case where the binary tree root passed to lca method is null
	 * Should return null.
	 */
	@Test
	public void nullTree(){
		
		BTNode a = new BTNode();                              
		BTNode b = new BTNode();
		
		BTNode result = BinaryTree.lca(null, a, b);
		assertEquals(null, result);
	}
	
	
	/*
	 * Tests case where first node passed to lca method is null.
	 * Should return null.
	 */
	@Test
	public void firstNodeIsNull(){
		
		BTNode a = new BTNode();   //                            
		BTNode b = new BTNode();   //                   a                              
		BTNode c = new BTNode();   //                 /   \ 
		BTNode d = new BTNode();   //                /     \
		                           //               /       \
		a.setLeft(b)  ;            //              b         c
		a.setRight(c);             //               \         
		b.setRight(d) ;            //                \         
		                           //                 d 
		
		BTNode result = BinaryTree.lca(a, null, c);
		assertEquals(null, result);
	}
	
	/*
	 * Tests case where second node passed to lca method is null.
	 * Should return null.
	 */
	@Test
	public void secondNodeIsNull(){
		
		BTNode a = new BTNode();   //                            
		BTNode b = new BTNode();   //                   a                              
		BTNode c = new BTNode();   //                 /   \ 
		BTNode d = new BTNode();   //                /     \
		                           //               /       \
		a.setLeft(b)  ;            //              b         c
		a.setRight(c);             //               \         
		b.setRight(d) ;            //                \         
		                           //                 d 
		
		BTNode result = BinaryTree.lca(a, d, null);
		assertEquals(null, result);
		
		
	}
	

}
