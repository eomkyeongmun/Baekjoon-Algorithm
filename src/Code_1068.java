import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Code_1068 {
    static ArrayList<Integer> []tree;
    static int [] trees;
    static boolean [] visited;

    static void DFS(int node) {
        visited[node] = true;
        for(int i: tree[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        tree = new ArrayList[node];
        visited = new boolean[node];
        trees = new int[node];

        for (int i = 0; i < node; i++) {
            tree[i] = new ArrayList<>();
            visited[i] = false;
        }
        st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < node; i++) {
            int a = Integer.parseInt(st.nextToken());
            trees[i] = a;
            if (a == -1) {
                root = i;
            } else {
                tree[a].add(i);
            }
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        if (k == root) {
            System.out.println(0);
            return;
        }

        int p = trees[k];
        if (p != -1) {
            tree[p].remove(Integer.valueOf(k));
        }

        DFS(k);

        int count = 0;
        for (int i = 0; i < node; i++) {
            if (visited[i]) continue; // 삭제된 노드 패스
            boolean hasAliveChild = false;
            for (int child : tree[i]) {
                if (!visited[child]) { // 살아있는 자식이 있으면 리프 아님
                    hasAliveChild = true;
                    break;
                }
            }
            if (!hasAliveChild) count++;
        }
        System.out.println(count);
    }
}
