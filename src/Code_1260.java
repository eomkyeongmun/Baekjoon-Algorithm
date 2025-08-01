import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//DFS와 BFS
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	339045	136835	80760	38.886%
//문제
//그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
//
//입력
//첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
//
//출력
//첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
//실버2
public class Code_1260 {
    static boolean []visited;

    static void DFS(int V, ArrayList<Integer>[] A) {
        visited[V] = true;
        if (visited[V]) {
            System.out.print(V + " ");
        }
        for (int i : A[V]) {
            if (!visited[i]) {
                DFS(i, A);
            }
        }

    }

    static void BFS(int V,ArrayList<Integer>[] A){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;
        System.out.print("\n");
        while (!queue.isEmpty()) {
            int out = queue.poll();
            System.out.print(out+" ");

            for (int n : A[out]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v=  Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] A= new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            A[i]=new ArrayList<Integer>();
        }

        visited = new boolean[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        for (int i=0;i<=n;i++) {
            Collections.sort(A[i]);
        }
        for(int i=0;i<n+1;i++){
            visited[i] = false;
        }
        DFS(v,A);
        for(int i=0;i<n+1;i++){
            visited[i] = false;
        }
        BFS(v,A);
    }
}
