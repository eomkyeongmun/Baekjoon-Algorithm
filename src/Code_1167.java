import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//나중에 풀기
public class Code_1167 {
    static boolean []visited;
    static ArrayList<Integer> []weight;
    static ArrayList<Edge> []A;
static class Edge{
    int e;
    int w;
    public Edge(int e, int w) {
        this.e = e;
        this.w = w;
    }
}
    static void BFS(int a) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(a);
        visited[a] = true;
        while (!queue.isEmpty()) {
            int node=queue.poll();
            for(Edge i:A[node]) {
                int e=i.e;
                int w=i.w;
                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    weight[e]=weight[node]+w;
                }
            }
        }
}


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        weight =new ArrayList[n+1];
        A= new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            A[i]=new ArrayList<Edge>();
        }

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int k=Integer.parseInt(st.nextToken());

        while(true){
            int a=Integer.parseInt(st.nextToken()); //노드
            if(a==-1)break;
            int b=Integer.parseInt(st.nextToken()); //weight
           A[k].add(new Edge(a, b));
        }
        }
        visited=new boolean[n+1];
        BFS(1);
        int Max=1;
        for(int i=2;i<=n;i++){
            if(weight[Max]<weight[i])
                Max=i;
        }
    }
}
