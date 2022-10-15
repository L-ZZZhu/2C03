package Question_4;
import java.util.*;

public class Graph {
        private int V;
        private ArrayList<ArrayList<Integer>> adj;
        public Graph(int V){
            adj=new ArrayList<>();
            for (int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }
            this.V=V;
        }
        public void AddEdge(int x,int y){
            adj.get(x).add(y);
            adj.get(y).add(x);
        }


}