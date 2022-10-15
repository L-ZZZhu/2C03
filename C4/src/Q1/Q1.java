package Q1;
import java.util.*;
class Graph {
    private int V;
    private ArrayList<ArrayList<Integer> > adj;
    Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }
    void addEdge(int v, int w) { adj.get(v).add(w); }
    void DAG_tool(int v, boolean[] T_or_F, Stack<Integer> stack){
        T_or_F[v] = true;
        for (Integer integer : adj.get(v)) if (!T_or_F[integer]) DAG_tool(integer, T_or_F, stack);
        stack.push(v);
    }
    String DAG_topologicalSort() {
        String topologicalSort="";
        Stack<Integer> stack = new Stack<>();
        boolean[] T_or_F = new boolean[V];// meaning is that element visited or not
                                          // if not visited that will be False
        for (int i = 0; i < V; i++) T_or_F[i] = false;
        for (int i = 0; i < V; i++) if (!T_or_F[i]) DAG_tool(i, T_or_F, stack);
        while (!stack.empty()) topologicalSort+=stack.pop()+" ";
        return topologicalSort;
    }
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println(g.DAG_topologicalSort());
    }
}
