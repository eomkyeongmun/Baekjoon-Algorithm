import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//ABCDE
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	66460	21549	14353	29.552%
//문제
//BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
//
//오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
//
//A는 B와 친구다.
//B는 C와 친구다.
//C는 D와 친구다.
//D는 E와 친구다.
//위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
//
//        입력
//첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
//
//둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
//
//        출력
//문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
//골드5 다시 풀어보기
public class Code_13023 {
    static int n,m;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean found;
    static void DFS(int k,int depth){
     if(depth==5 || found){
         found=true;
         return;
     }
     visited[k]=true;
       for(int i : A[k]){
           if(!visited[i]){
               DFS(i,depth+1);
           }
       }
        visited[k]=false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new ArrayList[n];
        for(int i=0;i<n;i++){
            A[i]=new ArrayList<Integer>();
        }
        visited = new boolean[n];
        found = false;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            DFS(i, 1);
           if(found)break;
        }

        System.out.println(found?1:0);
    }
}
