import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_18352 {
    static ArrayList<Integer>[] graph;
    static int [] distance;
    static int n;
    static void BFS(int s){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        Arrays.fill(distance, -1);
        distance[s] = 0;
        q.offer(s);

        while(!q.isEmpty()) {
            int c=q.poll();
            for (int next : graph[c]) {
                if (distance[next]!=-1) continue;     // 이미 방문
                distance[next]=distance[c]+1;
                q.offer(next);
            }
        }
    }

    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph= new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<=m;i++){
         st=new StringTokenizer(br.readLine());
         int u = Integer.parseInt(st.nextToken());
         int v = Integer.parseInt(st.nextToken());
         graph[u].add(v);
        }
        distance = new int[n + 1];
        boolean flag = false;
        BFS(x);
        for(int i=1;i<=n;i++) {
            if (distance[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }
        if(!flag){
            System.out.println("-1");
        }

    }
}
