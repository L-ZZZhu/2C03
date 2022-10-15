package question_test;
import java.util.*;
class qu4 {
    private final int V;
    private final ArrayList<Integer>[] adj;
    public qu4(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();
    }
    public void addEdge(int u, int v) {
        adj[u].add(v);
    }
    public void DAG() {
        int[] vertex_point_time = new int[V];
        for (int i = 0; i < adj.length; i++) {
            ArrayList<Integer> buffer = (ArrayList<Integer>) adj[i];//check each one vector have how much point
            for (int x : buffer) {
                vertex_point_time[x]++;
            }
        }//check each one number have how much edge.
        LinkedList<Integer> zero_input_vertex_point = new LinkedList<>();
        Scanner in=new Scanner(System.in);
        System.out.println("which two vertices of you want");
        int min=in.nextInt();
        zero_input_vertex_point.add(min);
        int max=in.nextInt();
        zero_input_vertex_point.add(max);
        int check_cycle=0;
        ArrayList<Integer> answers = new ArrayList<>();
        while (!zero_input_vertex_point.isEmpty()){
            int buffer = zero_input_vertex_point.poll();
            check_cycle++;
            answers.add(buffer);
            for (int node : adj[buffer]) {//check the no_input_point have of the output point
                if (--vertex_point_time[node] == 0)//which point will be the know input point
                    zero_input_vertex_point.add(node);
            }
        }
        if (check_cycle==V){//false for have cycled,true for no cycle
            for (int i : answers){
                System.out.print(i + " ");
            }
        }
        else System.out.println("have a acyclic in this graph which is ");
    }
    public boolean check(LinkedList<String> x){
        for (String i:x){
            if (i!="F"){
                return true;
            }
        }
        return false;
    }
    public int check_number(LinkedList<String> x){
        for (String i:x){
            if (i!="F"){
                return Integer.parseInt(i);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        qu4 g = new qu4(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.DAG();
        }

}
