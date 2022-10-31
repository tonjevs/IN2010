import java.util.Map;
import java.util.Queue;

class Alt{
    class Node{
        Node l, r;
        int b;
    }
    void writePathToNode(Node a, int b, String path){
        if(a == null){
            System.out.println("Verdien" + b + "finnes ikke i treet");
            if(a.b == b){
                System.out.println(path + " " + b);
            }
            else if (a.b > b){
                writePathToNode(a.l, b, path+"L");
            }
            else if(a.b < b){
                writePathToNode(a.r, b, path+"R");
            }
            else{
                System.out.println("Verdien " + v + " finnes ikke i treet");
            }
        }
    } 
    Node removeLessThan(Node n, int value){
        if(n == null){
            return null;
        }
        if(n.b >= value){
            n.l = removeLessThan(n.l, value);
            return n;
        }
        else{
           return removeLessThan(n.r, value);
        }
    }
}

class mapping{
    void put(Element e, int n){
        Map<Integer, Integer> hashTable = new HashMap<>(n);
        int verdi = e.k;
        int mod = verdi % 11;
        while(hashTable.get(mod) != null){
            if(mod > hashTable.length){
                mod = 0;
            }
            else{
                mod++;
            }
        }
        hashTable.put(mod,verdi);
    }
}
class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v){
        V = v;
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i){
            adj[i] = new LinkedList(); 
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    Boolean isTree(){
        Boolean visited[] = newBoolean[V];
        for(int i = 0; i < V; i++){
            visited[i] = false;
        }
        if(isCyclic(0,visited,-1)){
            return false;
        }
        for(int u = 0; u < V; u++){
            if(!visited[u]){
                return false;
            }
        }
        return true;
    }

    Boolean isCyclic(int v, Boolean visited[], int parent){
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();
        while(it.hasNext()){
            i = it.next();
            if(!visited[i]){
                if(isCyclic(i,visited,v)){
                    return true;
                }
            }
            else if(i != parent){
                return true;
            }
            return false;
        }
    }
    int numberOfSemesters(){
        int indegree[] = new int[V];
        
        for(int i = 0; i < V; i++){
            LinkedList<Integer> temp = LinkedList<Integer>();
            for(int node : temp){
                indegree[node]++;
            }
        }

        Queue<Integer> q = new LInkedList<Integer>();
        for(int i = 0; i < V; i++){
            if(indegree[i] = 0){
                q.add(i);
            }
        }
        int semester = 0;

        while(!q.isEmpty()){
            int sice = q.size();
            for(int i = 0; i < 3 && i < size; i++){
                int v = q.poll();
                for(int node : adj[v]){
                    if(--indegree[node] == 0){
                        q.add(node);
                    }
                }
            }
            semester++;
        }
        return semester;
    }
}

Procedure BucketSort(A):
	La B være et array med 6 tomme lister 
	for i ← 0 to n − 1 do
		La k være nøkkelen assosiert med A[i]
		Legg til A[i] på slutten av listen B[k] 
	end
	j ← 0 
	for k ← 0 to N − 1 do
		for hver x i listen B[k] do 
			A[j] ← x
			j ← j + 1 
		end
	end 
	return A