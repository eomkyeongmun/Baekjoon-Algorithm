import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_1325 {
    static ArrayList<Integer>[] graph;
    static boolean [] visited;
    static int []count;
    static int counting;
    static int DFS(int s){
        visited[s] = true;
        for(int i: graph[s]){
            if(!visited[i]){
                counting++;
                DFS(i);
            }
        }
        return counting;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i=0;i<n+1;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<=m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }
        Arrays.fill(visited, false);
        count = new int[n+1];
        Arrays.fill(count, 0);
        for(int i=1;i<=n;i++){
            Arrays.fill(visited, false);
            counting=0;
            count[i]=DFS(i);
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(count[i]>max){
                max = count[i];
            }
        }
        for(int i=1;i<=n;i++){
            if(count[i]==max){
                System.out.print(i+" ");
            }
        }
    }
}
