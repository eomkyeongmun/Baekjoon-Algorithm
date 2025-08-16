import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code_11725 {
    static ArrayList<Integer>[] tree;
    static int [] answer;
    static boolean []visit;
    static void DFS(int n) {
        visit[n] = true;
        for(int i: tree[n]) {
            if(!visit[i]) {
                answer[i] = n;
                DFS(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n+1];
        answer = new int[n+1];
        visit = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
            visit[i] = false;
        }
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        DFS(1);
        for(int i = 2; i <= n; i++){
            System.out.println(answer[i]);
        }
    }
}
