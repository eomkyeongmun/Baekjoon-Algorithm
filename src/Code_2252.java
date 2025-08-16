import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        int [] indegree = new int[n+1];
        for (int i = 0; i <= n; i++) {
            a.add(new ArrayList<>());
            indegree[i] = 0;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            a.get(u).add(v);
            indegree[v]++;
        }
        for(int i = 1; i <= n; i++)
        {
            if(indegree[i] == 0) {
                q.add(i);
            }

        }
        while(!q.isEmpty()) {
            int b=q.poll();
            System.out.print(b+" ");
            for(int i: a.get(b)) {
                indegree[i]--;
                if(indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
    }
}
