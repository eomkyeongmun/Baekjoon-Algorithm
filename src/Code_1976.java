import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//여행 가자
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	58580	23195	16856	37.823%
//문제
//동혁이는 친구들과 함께 여행을 가려고 한다. 한국에는 도시가 N개 있고 임의의 두 도시 사이에 길이 있을 수도, 없을 수도 있다. 동혁이의 여행 일정이 주어졌을 때, 이 여행 경로가 가능한 것인지 알아보자. 물론 중간에 다른 도시를 경유해서 여행을 할 수도 있다. 예를 들어 도시가 5개 있고, A-B, B-C, A-D, B-D, E-A의 길이 있고, 동혁이의 여행 계획이 E C B C D 라면 E-A-B-C-B-C-B-D라는 여행경로를 통해 목적을 달성할 수 있다.
//
//도시들의 개수와 도시들 간의 연결 여부가 주어져 있고, 동혁이의 여행 계획에 속한 도시들이 순서대로 주어졌을 때 가능한지 여부를 판별하는 프로그램을 작성하시오. 같은 도시를 여러 번 방문하는 것도 가능하다.
//
//        입력
//첫 줄에 도시의 수 N이 주어진다. N은 200이하이다. 둘째 줄에 여행 계획에 속한 도시들의 수 M이 주어진다. M은 1000이하이다. 다음 N개의 줄에는 N개의 정수가 주어진다. i번째 줄의 j번째 수는 i번 도시와 j번 도시의 연결 정보를 의미한다. 1이면 연결된 것이고 0이면 연결이 되지 않은 것이다. A와 B가 연결되었으면 B와 A도 연결되어 있다. 마지막 줄에는 여행 계획이 주어진다. 도시의 번호는 1부터 N까지 차례대로 매겨져 있다.
//
//        출력
//첫 줄에 가능하면 YES 불가능하면 NO를 출력한다.
//골드4
public class Code_1976 {
    static int[] parent;
    static int[] size;
    // 대표자 찾기
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    // 합집합
    static void union(int a, int b) {
        int parent1 = find(a);
        int parent2 = find(b);
        if (parent1 == parent2) return;

        if (size[parent1] < size[parent2]) {
            int t=parent1;parent1=parent2;parent2=t;
        }
        parent[parent2]=parent1;
        size[parent1]+=size[parent2];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int [][] a = new int[n][n];
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;   // ★ 초기화
            size[i] = 1;     // ★ 초기화
        }
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
            a[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
              if(a[i][j]==1){union(i,j);}
            }
        }
        boolean flag=false;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] b=new int[m];
        for(int i=0;i<m;i++){
            b[i]=Integer.parseInt(st.nextToken())-1;
        }
        int par =parent[b[0]];
        for(int i=0;i<m;i++){
            if(parent[b[i]]!=par){
                flag=true;
            }
        }
        if(flag){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }

    }
}
