
public class Ancestor implements Comparable<Ancestor>  {
	
	public int vertexNo;
	public int depth;
	
	public Ancestor(int vertexNo, int depth){
		this.vertexNo = vertexNo;
		this.depth = depth;
	}
	
	public int compareTo(Ancestor other){
		
		if(this.depth < other.depth) return 1;
		if(this.depth > other.depth) return -1;
		else                         return 0;
	}
	
}