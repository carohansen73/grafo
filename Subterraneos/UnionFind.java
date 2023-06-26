
package Subterraneos;

public class UnionFind {
	
    private int[] parent;
    
    public UnionFind(int n) {
        parent = new int[n];
        for (var i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
 
    public int Find(int x) {
        if (x == parent[x]) {
            return x;
        }
        // compress the paths
        return parent[x] = Find(parent[x]);
    }
 
    public void Union(int x, int y)  {
        var px = Find(x);
        var py = Find(y);
        if (px != py) {
            parent[px] = py;
        }
    }
 
    public int size() { // number of groups
        int ans = 0;
        for (int i = 0; i < parent.length; ++ i) {
            if (i == parent[i]) ans ++;
        }
        return ans;
    }  
    
  //Método que me determina si 2 vértices estan o no en la misma componente conexa
  	public boolean sameComponent( int x , int y ){
  	    if( Find( x ) == Find( y ) ) return true;   //si poseen la misma raíz
  	    return false;
  	}
  	
  	public void copiarUnion(UnionFind u) {
  		this.parent = u.parent.clone();
  	}
}