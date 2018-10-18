/*
 * Definition of LCA in a DAG:
 *                                Define the height of a vertex v in a DAG to be the length of the longest path from
 *                                the root to v. Among the vertices that are common ancestors of v and w, the one 
 *                                with the greatest height is the LCA of v and w.   
 *                                
 *                                   Thus, for e.g., to find LCA(1,2) in the DAG 0->1, 0->2, 1->2, where 0 is the root
 *                                   we note that the common ancestors of 1 and 2 are 0 (height=0) and 1 (height = 1).
 *                                   Therefore LCA = 1.
 *                                                                   
 *                                                                      
 *                                
 *                                
 */







import java.util.*;

/*An instance of Digraph represents a directed graph. 
 * The graph is represented here by an array of sets containing
 * all the children of the corresponding node.
 */
public class Digraph {
	
	private final int root;
	private final int V;     //V is the no. of vertices in the graph
	private final Set<Integer>[] children;   //e.g. children[v] is the set of vertex v's children
	private final Set<Parent>[] parents;     //e.g. parent[v] is the set of vertex v's parents
	
	public Digraph(int V, int root)
	{
	  this.root = root;
	  this.V = V;
	  
	  children = (Set<Integer>[]) new LinkedHashSet[V];
	  for (int v = 0; v < V; v++){
		 children[v] = new LinkedHashSet<Integer>();
	  }
	  
	  parents = (Set<Parent>[]) new LinkedHashSet[V];
	  for (int v = 0; v < V; v++){
			 parents[v] = new LinkedHashSet<Parent>();
	  }
	}
	
	
	/*add edge v->w */
	public void addEdge(int v, int w)
	{
	  children[v].add(w);
	}
	
	
	/*returns the children of vertex v */
	public Iterable<Integer> children(int v)
	{ 
	  return children[v]; 
	}
	
	/*returns the parents of vertex v */
	public Iterable<Parent> parents(int v)
	{ 
	  return parents[v]; 
	}
	
	
	/*
	 * Traverses the graph and for every link from a parent to a child (in the
	 * children array) creates a corresponding link from child to parent (in the
	 * parents array 
	 */
	public void getParents(){
		getParents_helper(root,0);
	}
	
	private void getParents_helper(int vertex, int depth){
		
		for(int child: children[vertex]){
			parents[child].add(new Parent(vertex,depth));
		}
		
		for(int child: children[vertex]){
			getParents_helper(child, depth + 1);
		}
	}
	

	
	
	
	public String toString()
	{
	  String rtrn = "";
	  
	  for (int v = 0; v < V; v++){
		  
		rtrn = rtrn + "Children " + v + ": ";  
		
		for (Integer i: children(v)){
			
			rtrn = rtrn + i + " ";
		}
		
		rtrn = rtrn + "\n";
	  }
	  
	  return rtrn;
	}
	
	
	public String showParents()
	{
	  String rtrn = "";
	  
	  for (int v = 0; v < V; v++){
		  
		rtrn = rtrn + "Parents " + v + ": ";  
		
		for (Parent p: parents(v)){
			
			rtrn = rtrn + p.vertexNo + " depth: " + p.depth + "\n";
		}
		
		rtrn = rtrn + "\n";
	  }
	  
	  return rtrn;
	}

}


