package Q2;
import java.util.*;
class Q2 {
    int src, dest, weight;
    public Q2(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + src + ", " + dest + ", " + weight + ")";
    }
}
class DisjointSet{
    Map<Integer, Integer> parent = new HashMap<>();
    public void makeSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.put(i, i);
        }
    }
    private int find(int k) {
        if (parent.get(k) == k) {
            return k;
        }
        return find(parent.get(k));
    }
    private void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        parent.put(x, y);
    }
    public static List<Q2> runKruskalAlgorithm(List<Q2> edges, int n) {
        List<Q2> MST = new ArrayList<>();
        DisjointSet ds = new DisjointSet();
        ds.makeSet(n);
        int index = 0;
        edges.sort(Comparator.comparingInt(e -> e.weight));
        while (MST.size() != n - 1) {
            Q2 next_edge = edges.get(index++);
            int x = ds.find(next_edge.src);
            int y = ds.find(next_edge.dest);
            if (x != y) {
                MST.add(next_edge);
                ds.union(x, y);
            }
        }
        return MST;
    }
}

class Main {
    public static void main(String[] args) {
        List<Q2> edges = Arrays.asList(
                new Q2(0, 1, 7), new Q2(1, 2, 8), new Q2(0, 3, 5),
                new Q2(1, 3, 9), new Q2(1, 4, 7), new Q2(2, 4, 5),
                new Q2(3, 4, 15), new Q2(3, 5, 6), new Q2(4, 5, 8),
                new Q2(4, 6, 9), new Q2(5, 6, 11));
        int n = 7;
        List<Q2> e = DisjointSet.runKruskalAlgorithm(edges, n);
        System.out.println(e);
    }
}
