package Question_3;
import java.util.*;

public class Graph {
    private final int V;
    private final Bag<Integer>[] adj;
    private String list="";

    public Graph(int v){
        this.V = v;
        adj = new Bag[V];
        for (int i = 0; i < v; ++i)
            adj[i] = new Bag();
    }
    public void addEdge(int x,int y){
        adj[x].add(y);
    }
    public void DFS (int v){
        boolean check[]=new boolean[V];
        DFS_inside_check(v,check);
        list=list+v;
        System.out.println(list);
    }
    public void DFS_inside_check(int v,boolean[] check){
        check[v]=true;
        list=list+v+"-->";
        Iterator<Integer> list_of_tf = adj[v].listIterator();
        while(list_of_tf.hasNext()){
            int number= list_of_tf.next();
            if (!check[number]){
                DFS_inside_check(number,check);
            }
        }
    }
    public static void main(String args[]){
        Random r =new Random();
        Graph g = new Graph(r.nextInt(100)+100);
        for (int i=0;i<100;i++){
            g.addEdge(r.nextInt(100),r.nextInt(100));
        }
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.DFS(1);
    }
}
