package question_test;
import java.util.*;
class qu2 {
    private final int V;
    private final LinkedList<Integer> adj[];
    private String list="";
    qu2(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v,int w) {
        adj[v].add(w);
    }
    void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> BFS_list = new LinkedList<Integer>();
        visited[s]=true;
        BFS_list.add(s);
        int buffer;
        while (BFS_list.size() != 0){
            buffer = BFS_list.poll();
            list=list+buffer+"-->";
            Iterator<Integer> adj_list = adj[buffer].listIterator();
            while (adj_list.hasNext()) {
                int next_int = adj_list.next();
                if (!visited[next_int]){
                    visited[next_int] = true;
                    BFS_list.add(next_int);
                }
            }
        }
        if (Objects.equals(list, s + "-->")){
            System.out.println("the graph of "+s+" is acyclic, So its girth is infinite.");
        }
        else System.out.println(list);
    }
    public static void main(String args[]) {
        Random r =new Random();
        qu2 g = new qu2(r.nextInt(100)+100);
        for (int i=0;i<100;i++){
            g.addEdge(r.nextInt(100),r.nextInt(100));
        }
        g.BFS(r.nextInt(10));
    }
}
