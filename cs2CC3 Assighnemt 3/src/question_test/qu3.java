package question_test;
import java.util.Iterator;
import java.util.Random;
import java.util.*;
public class qu3 {
        private final int V;
        private final LinkedList<Integer> adj[];
        private String list="";

        public qu3(int v){
            this.V = v;
            adj = new LinkedList[V];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }
        public void addEdge(int x,int y){
            adj[x].add(y);
        }
        public void DFS (int v){
            boolean check[]=new boolean[V];
            DFS_inside_check(v,check);
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
            qu3 g = new qu3(r.nextInt(100)+100);
            for (int i=0;i<50;i++){
                g.addEdge(r.nextInt(100),r.nextInt(100));
            }
            g.DFS(1);
        }
    }

