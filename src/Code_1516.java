import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Code_1516 {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] time = new int[n + 1];
    int[] index = new int[n + 1];
    ArrayList<Integer> [] build = new ArrayList[n+1];

    for(int i = 0; i < n+1; i++) {
        build[i] = new ArrayList<>();
    }

    // 입력 처리
    for (int i = 1; i <= n; i++) {
        st = new StringTokenizer(br.readLine());
        time[i]=Integer.parseInt(st.nextToken());
        while(true) {
            int p=Integer.parseInt(st.nextToken());
            if(p==-1) break;
            build[p].add(i);
            index[i]++;
        }
    }
    // 위상 정렬
    int[] result=new int[n + 1];
    Queue<Integer> q = new ArrayDeque<>();

    // 선행이 없는 노드부터 시작: 결과는 곧 자기 시간
    for (int i = 1; i <= n; i++) {
        result[i] = time[i];
        if (index[i] == 0) q.offer(i);
    }

    while (!q.isEmpty()) {
        int u = q.poll();
        for (int v : build[u]) {
            if(result[v] < result[u] + time[v]) {
                result[v] = result[u] + time[v];
            }
            if(--index[v] == 0) q.offer(v);
        }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) sb.append(result[i]).append('\n');
    System.out.print(sb);
}
}
