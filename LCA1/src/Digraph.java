import java.util.*;

/*An instance of Digraph represents a directed graph. 
 * The graph is represented here by an array of sets containing
 * all the children of the corresponding node.
 */
public class Digraph {
	
	private final int V;     //V is the no. of vertices in the graph
	private final Set<Integer>[] children;   //e.g. children[0] is the set of node 0's children
	
	public Digraph(int V)
	{
	  this.V = V;
	  children = (Set<Integer>[]) new LinkedHashSet[V];
	  for (int v = 0; v < V; v++){
		 children[v] = new LinkedHashSet<Integer>();
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



}
