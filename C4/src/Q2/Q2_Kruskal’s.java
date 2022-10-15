package Q2;
import java.util.*;
import java.lang.*;
class Graph {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }
    static class subset {
        int parent, rank;
    }
    int vertices,edges;
    Edge[] edge_list;
    Graph(int v, int e) {
        vertices = v;
        edges = e;
        edge_list = new Edge[edges];
        for (int i = 0; i < e; ++i)
            edge_list[i] = new Edge();
    }
    int find(subset[] subsets, int i){
        if (subsets[i].parent != i) subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
    void Union_for_MST(subset[] subsets, int x, int y) {
        int X_point = find(subsets, x);
        int Y_point = find(subsets, y);
        if (subsets[X_point].rank < subsets[Y_point].rank) subsets[X_point].parent = Y_point;
        else if (subsets[X_point].rank > subsets[Y_point].rank) subsets[Y_point].parent = X_point;
        else {
            subsets[Y_point].parent = X_point;
            subsets[X_point].rank++;
        }
    }
    void KruskalMST() {
        Edge[] answer = new Edge[vertices];
        for (int i = 0; i < vertices; ++i) answer[i] = new Edge();
        Arrays.sort(edge_list);
        subset[] subsets = new subset[vertices];
        for (int i = 0; i < vertices; ++i) subsets[i] = new subset();
        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;}
        int i = 0;
        int buffer_number = 0;
        while (buffer_number < vertices - 1) {
            Edge buffer = edge_list[i++];
            int x = find(subsets, buffer.src);
            int y = find(subsets, buffer.dest);
            if (x != y) {
                answer[buffer_number++] = buffer;
                Union_for_MST(subsets, x, y);
            }
        }
        print(buffer_number, answer);
    }
    void print(int number, Edge[] result){
        int minimumCost = 0;
        ArrayList<Integer> answer=new ArrayList<>();
        for (Edge x:result){
            if (!answer.contains(x.src)) answer.add(x.src);
        }
        for (Edge x:result){
            if (!answer.contains(x.dest)) answer.add(x.dest);
        }
        System.out.println(answer);
        System.out.println(String.format("%-10s","src")+String.format("%-10s","dest")+String.format("%-10s","weight"));
        for (int i = 0; i < number; ++i) {
            System.out.println(String.format("%-10d",result[i].src)
                    +String.format("%-10d",result[i].dest)
                    +String.format("%-10d",result[i].weight));
            minimumCost += result[i].weight;
        }
        System.out.print("   minimums cost is "+minimumCost);
    }

}

