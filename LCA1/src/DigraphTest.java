import static org.junit.Assert.*;

import org.junit.Test;


public class DigraphTest {

	
		
		/*
		 * Binary Tree Test 1
		 * Tests that the lca method returns the correct lowest common ancestor
		 * when both of the specified nodes are present in the given binary tree
		 */
		@Test
		public void bothNodesPresentTest() {
			
			Digraph myDigraph = new Digraph(7,0);   //                   0         
			myDigraph.addEdge(0, 1);              //                 /   \               
			myDigraph.addEdge(0, 2);              //                /     \
			myDigraph.addEdge(1, 3);              //               /       \
			myDigraph.addEdge(2, 4);              //              1         2
			myDigraph.addEdge(2, 5);              //               \       /  \
			myDigraph.addEdge(5, 6);              //                \     /    \
			                                      //                 3   4      5
			                                      //                           /
			                                      //                          /
			                                      //                         6
			                                      
			
			
			int result = myDigraph.lca(4, 6); //result is assigned the lca of nodes 4 and 6
			
			assertEquals(2,result);                             
		}
		
		
		
		
		/*
		 * Binary Tree Test 2
		 * Tests that the lca method returns null as the lowest common ancestor
		 * when the first node being searched for is not present in the given
		 * tree
		 */
		@Test
		public void firstNodeAbsent(){
			
			Digraph myDigraph = new Digraph(6,0);                                         
			myDigraph.addEdge(0, 1);   //                   0                              
			myDigraph.addEdge(0, 2);   //                 /   \ 
			myDigraph.addEdge(1, 3);   //                /     \
			myDigraph.addEdge(2, 4);   //               /       \
			myDigraph.addEdge(4, 5);   //              1         2
			                           //               \         \
			                           //                \         \
			                           //                 3         4
			                           //                          /
			                           //                         /
		                                   //                        5
			                         
			
			
	        int result = myDigraph.lca(6,5);
	      
	        assertEquals(null,result);
			
		}
		
		
		
		/*
		 * Binary Tree Test 3
		 * Tests that the lca method returns null as the lowest common ancestor
		 * when the second node being searched for is not present in the given
		 * tree
		 */
		@Test
		public void secondNodeAbsent(){
			
			Digraph myDigraph = new Digraph(6,0);
			myDigraph.addEdge(0, 1);   //                   0         
			myDigraph.addEdge(0, 2);   //                 /   \               
			myDigraph.addEdge(1, 3);   //                /     \
			myDigraph.addEdge(2, 4);   //               /       \
			myDigraph.addEdge(2, 5);   //              1         2
			                           //               \       /  \
			                           //                \     /    \
			                           //                 3   4      5
			
			
			int result = myDigraph.lca(1, 6);
			
			assertEquals(null,result);
		}
		
		
		
		/*
		 * Binary Tree Test 4
		 * Tests that the lca method returns null when both nodes being searched
		 * for are absent from the binary tree 
		 */
		@Test
		public void bothNodesAbsent(){
			
			Digraph myDigraph = new Digraph(5,0);
			myDigraph.addEdge(0, 1);   //                   0         
			myDigraph.addEdge(0, 2);   //                 /   \               
			myDigraph.addEdge(2, 3);   //                /     \
			myDigraph.addEdge(3, 4);   //               /       \
			                           //              1         2
			                           //                         \
			                           //                          \
			                           //                           3
			                           //                          /
			                           //                         /
			                           //                        4
		                              
			
			int result = myDigraph.lca(5, 6);
			
			assertEquals(null,result);
		}
		
		
		
		/*
		 * Binary Tree Test 5
		 * Tests the lca method where one of the nodes we are looking
		 * for the lowest common ancestor of is the root of the tree
		 */
		@Test
		public void oneNodeIsRoot(){
			
			Digraph myDigraph = new Digraph(2,0);  //           0                                              
			myDigraph.addEdge(0, 1);             //            \               
			                                     //             \
	                                                    //               \
	                                                    //                1
	        
	        int result = myDigraph.lca(0, 1);
	        assertEquals(0,result);
		}
		
		
		
		/*
		 * Binary Tree Test 6
		 * Tests what happens when we pass the same node twice to 
		 * the lca method rather than two different nodes.
		 * Should return the node passed in.
		 */
		@Test
		public void lcaSameNode(){
			
			Digraph myDigraph = new Digraph(4,0);
			myDigraph.addEdge(0, 1);   //                            
			myDigraph.addEdge(0, 2);   //                   0                              
			myDigraph.addEdge(1, 3);   //                 /   \ 
			                           //                /     \
			                           //               /       \
		                                   //              1         2
			                           //               \         
			                           //                \         
			                           //                 3 
			
			int result = myDigraph.lca(3, 3);
			assertEquals(3,result);
			
		}
		
		
		
		/*
		 * Binary Tree Test 7
		 * Tests case where the binary tree root passed to lca method is null
		 * Should return null.
		 */
		@Test
		public void nullTree(){
			
			Digraph myDigraph = null;
			int result = myDigraph.lca(2,3);
			assertEquals(null, result);
		}
		
		
		/*
		 * Binary Tree Test 8
		 * Tests case where first node passed to lca method is null.
		 * Should return null.
		 */
		@Test
		public void firstNodeIsNull(){
			
			Digraph myDigraph = new Digraph(4,0);
			myDigraph.addEdge(0, 1);   //                            
			myDigraph.addEdge(0, 2);   //                   0                              
			myDigraph.addEdge(1, 3);   //                 /   \ 
			                           //                /     \
			                           //               /       \
		                                   //              1         2
			                           //               \         
			                           //                \         
			                           //                 3 
			
			int result = myDigraph.lca(null, 2);
			assertEquals(null, result);
		}
		
		
		
		/*
		 * Binary Tree Test 9
		 * Tests case where second node passed to lca method is null.
		 * Should return null.
		 */
		@Test
		public void secondNodeIsNull(){
			
			Digraph myDigraph = new Digraph(4,0);
			myDigraph.addEdge(0, 1);   //                            
			myDigraph.addEdge(0, 2);   //                   0                              
			myDigraph.addEdge(1, 3);   //                 /   \ 
			                           //                /     \
			                           //               /       \
			                           //              1         2
			                           //               \         
			                           //                \         
			                           //                 3 
			
			int result = myDigraph.lca(3, null);
			assertEquals(null, result);
			
			
		}
		
		
		
		/*
		 * Binary Tree Test 10
		 * Test case where both nodes passed to lca method are null.
		 * Should return null.
		 */
		@Test
		public void bothNodesNull(){
			
			Digraph myDigraph = new Digraph(4,0);
			myDigraph.addEdge(0, 1);   //                            
			myDigraph.addEdge(0, 2);   //                   0                              
			myDigraph.addEdge(1, 3);   //                 /   \ 
			                           //                /     \
			                           //               /       \
		                                   //              1         2
			                           //               \         
			                           //                \         
			                           //                 3 
			
			int result = myDigraph.lca(null, null);
			assertEquals(null, result);
			
			
		}
		
		
		
		/*
		 * DAG Test 1
		 */
		@Test
		public void initialDAGTest(){
			
		Digraph myDigraph = new Digraph(8,0);
		myDigraph.addEdge(0, 1);                //                             0       
		myDigraph.addEdge(0, 2);                //                          /  |  \                    
		myDigraph.addEdge(0, 3);                //                         /   |   \
		myDigraph.addEdge(1, 4);                //                        /    |    \       
		myDigraph.addEdge(2, 4);                //                       /     |     \             
		myDigraph.addEdge(3, 4);                //                      1      2      3          
		myDigraph.addEdge(4, 5);                //                      \      |     /  
		myDigraph.addEdge(4, 6);                //                       \     |    /         
		myDigraph.addEdge(4, 7);                //                        \    |   /
                                                //                         \   |  /
		                                        //                          \  | /
		                                        //                             4
	    int result = myDigraph.lca(1, 7);       //                           / | \
	    assertEquals(1, result);                //                          /  |  \
		                                        //                         /   |   \
		                                        //                        /    |    \
		                                        //                       5     6     7
		
		
	   }
}		
