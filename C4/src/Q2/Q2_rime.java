package Q2;
import java.lang.*;
import java.util.ArrayList;

class MST {
    int minKey(int[] key, Boolean[] T_F_set, int length) {
        int min_value = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < length; i++)
            if (!T_F_set[i] && key[i] < min_value) {
                min_value = key[i];
                min_index = i;
            }

        return min_index;
    }
    void printMST(int[] parent, int[][] graph) {
        int length=graph.length;
        System.out.println("Edge \tWeight");
        ArrayList<Integer> answer=new ArrayList<>();
        for (int i = 1; i < length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            if (!answer.contains(parent[i])){
                answer.add(parent[i]);
            }
            if (!answer.contains(i)){
                answer.add(i);
            }
        }
        System.out.println(answer);
    }
    void primMST(int[][] graph) {
        int length=graph.length;
        int[] parent_list = new int[length];
        int[] key_value = new int[length];
        Boolean[] T_F_set = new Boolean[length];
        for (int i = 0; i < length; i++) {
            key_value[i] = Integer.MAX_VALUE;
            T_F_set[i] = false;
        }
        key_value[0] = 0;
        parent_list[0] = -1;
        for (int count = 0; count < length - 1; count++) {
            int x = minKey(key_value, T_F_set,length);
            T_F_set[x] = true;
            for (int y = 0; y < length; y++)
                if (graph[x][y] != 0 && !T_F_set[y] && graph[x][y] < key_value[y]) {
                    parent_list[y] = x;
                    key_value[y] = graph[x][y];
                }
        }
        printMST(parent_list, graph);
    }


}

