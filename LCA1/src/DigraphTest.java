import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Vector;

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
	      
	        assertEquals(-1,result);
			
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
			
			assertEquals(-1,result);
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
			
			assertEquals(-1,result);
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
		 * DAG Test 1
		 */
		@Test
		public void DAGTest1(){
			
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
		
		
	   /*
	    * DAG Test 2
	    *      digraph with edges 0->1 0->2 0->3 3->4 and root 0
	    *         find LCA(4,2); should be 0
	    */
		@Test
		public void DAGTest2(){
		  Digraph myDigraph = new Digraph(5,0);
		  myDigraph.addEdge(0,1);
		  myDigraph.addEdge(0,2);
		  myDigraph.addEdge(0,3);
		  myDigraph.addEdge(3,4);
		  
		  int result = myDigraph.lca(4, 2);
		  assertEquals(0, result); 
		
		}
		
		
		/*
		    * DAG Test 3
		    *      digraph with edges 0->2 0->1 1->2 and root 0
		    *         find LCA(1,2); should be 1
		    *         
		    *      Note: One might think LCA(1,2) = 0 here since 0
		    *            is a parent of both nodes. However, 1 is
		    *            also an ancestor of both these nodes and 
		    *            has greater height so it is the lca
		    */
		    @Test
			public void DAGTest3(){
			  Digraph myDigraph = new Digraph(3,0);
			  myDigraph.addEdge(0,2);
			  myDigraph.addEdge(0,1);
			  myDigraph.addEdge(1,2);
			  
			  int result = myDigraph.lca(1, 2);
			  assertEquals(1, result); 
			  
			  int result2 = myDigraph.lca(2, 1);
			  assertEquals(1, result2); 
			
			}
			
			
			
			/*
			 * DAG Test 4
			 */
			@Test
			public void DAGTest4(){
				
			Digraph myDigraph = new Digraph(8,0);
			myDigraph.addEdge(0, 5);
			myDigraph.addEdge(0, 1);                //          ------------------ 0       
			myDigraph.addEdge(0, 2);                //          |               /  |  \                    
			myDigraph.addEdge(0, 3);                //          |              /   |   \
			myDigraph.addEdge(1, 4);                //          |             /    |    \       
			myDigraph.addEdge(2, 4);                //          |            /     |     \             
			myDigraph.addEdge(3, 4);                //          |           1      2      3          
			myDigraph.addEdge(4, 5);                //          |            \     |     /  
			myDigraph.addEdge(4, 6);                //          |             \    |    /         
			myDigraph.addEdge(4, 7);                //          |              \   |   /
	                                                //          |               \  |  /
			                                        //          |                \ | /
			                                        //          |                  4
		    int result = myDigraph.lca(5, 2);       //          |                / | \
		    assertEquals(5, result);                //          |               /  |  \
			                                        //          |              /   |   \
			                                        //          |             /    |    \
			                                        //          |-------------5    6     7
			                                                     
			
		   }
			
		
		
		
		
		
		
}		
