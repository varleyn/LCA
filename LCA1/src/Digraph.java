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
 * Algorithm for finding lca(x,y):
 * 	
 * 				Maintain an array of vectors called parents (storing parents of each node).
 *
 *              1. Do a bfs(keep storing parents of each vertex) and find all the ancestors of x 
 *                 (find parents of x and using parents, find all the ancestors of x) and store them in a vector. 
 *                 Also, store the depth of each parent in the vector.
 *
 *              2. Find the ancestors of y using same method and store them in another vector. 
 *              
 *              3. Now, you have two vectors storing the ancestors of x and y respectively along with their depth.
 *                 Sort the vectors in decreasing order of their depths and find out the LCA.                                                                    
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
	private final Set<Ancestor>[] parents;     //e.g. parent[v] is the set of vertex v's parents
	
	public Digraph(int V, int root)
	{
	  this.root = root;
	  this.V = V;
	  
	  children = (Set<Integer>[]) new LinkedHashSet[V];
	  for (int v = 0; v < V; v++){
		 children[v] = new LinkedHashSet<Integer>();
	  }
	  
	  parents = (Set<Ancestor>[]) new LinkedHashSet[V];
	  for (int v = 0; v < V; v++){
			 parents[v] = new LinkedHashSet<Ancestor>();
	  }
	}
	
	
	/*add edge v->w */
	public void addEdge(int v, int w)
	{
	  children[v].add(w);
	}
	
	
	
	/*returns the parents of vertex v */
	private Iterable<Ancestor> parents(int v)
	{ 
	  return parents[v]; 
	}
	
	
	/*
	 * Traverses the graph and for every link from a parent to a child (in the
	 * children array) creates a corresponding link from child to parent (in the
	 * parents array 
	 */
	private void getParents(){
		getParents_helper(root,0);
	}
	
	private void getParents_helper(int vertex, int depth){
		
		for(int child: children[vertex]){
			parents[child].add(new Ancestor(vertex,depth));
		}
		
		for(int child: children[vertex]){
			getParents_helper(child, depth + 1);
		}
	}
	
	
	public int lca(int v1, int v2){
		
		if( (v1 < 0) || (v1 >= V) || (v2 < 0) || (v2 >= V) ) return -1;  //v1 or v2 outside bounds of array representing graph
		
		getParents();
		
		Vector<Ancestor> ancestorsV1 = findAncestors(v1);
		Collections.sort(ancestorsV1);
		
		Vector<Ancestor> ancestorsV2 = findAncestors(v2);
		Collections.sort(ancestorsV2);
		
		for( Ancestor a: ancestorsV1 ){
			
			for(Ancestor b: ancestorsV2){
				if(a.vertexNo == b.vertexNo){
					return a.vertexNo;
				}
			}
		}
		
		return -1;
		
	}
	
	
	/*
	 * Returns all the ancestors of a given vertex along with their depths
	 */
	private Vector<Ancestor> findAncestors(int v){
		
		Vector<Ancestor> ancestors = new Vector<Ancestor>();
		
		int depthOfV = getParentGreatestDepth(v) + 1;
		ancestors.add(new Ancestor(v, depthOfV));     //add v to ancestors as v is an ancestor of itself
		
		return findAncestors_helper(ancestors, v);

	}
	
	
    private Vector<Ancestor> findAncestors_helper(Vector<Ancestor> ancestors, int v){
    	
		for(Ancestor p: parents(v)){
			ancestors.add(p);
			System.out.println("ADDED" + p.vertexNo + ":" + p.depth);
		}
		
		for(Ancestor p: parents(v)){
			ancestors = findAncestors_helper(ancestors, p.vertexNo);
		}
		
		return ancestors;

	}
	
    
    /*
     * returns the depth of the parent(s) of vertex v with greatest depth 
     */
    private int getParentGreatestDepth(int v){
    	
    	int deepest = -1;
    	
    	for(Ancestor parent: parents(v)){
    		if(parent.depth > deepest)  deepest = parent.depth;
    	}
    	
    	return deepest;
    }
	
	
	
	

}


