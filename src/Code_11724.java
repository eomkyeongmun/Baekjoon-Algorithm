import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//연결 요소의 개수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//3 초	512 MB	167129	76181	49771	42.343%
//문제
//방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
//
//        출력
//첫째 줄에 연결 요소의 개수를 출력한다.
//실버2
public class Code_11724 {
    static boolean[][] visit;
    static boolean[] visited;
    static int n, m;
    public static void DFS(int k) {
        if(visited[k]) return;
        visited[k] = true;
        for(int i=1; i<=n; i++) {
            if(!visited[i] && visit[k][i]) { DFS(i);}
        }
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       visit = new boolean[n+1][n+1];
        visited = new boolean[n+1];
       for(int i = 0; i < m; i++) {
           st = new StringTokenizer(br.readLine());
           int x = Integer.parseInt(st.nextToken());
           int y = Integer.parseInt(st.nextToken());
           visit[x][y]=true;
           visit[y][x]=true;
       }
       int count=0;
        for(int i = 1; i <= n; i++) {
            if(!visited[i]){
                count++;
                DFS(i);
            }

        }

        System.out.println(count);
    }

    }

