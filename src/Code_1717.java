import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//집합의 표현 성공스페셜
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	124855	41217	25184	29.073%
//문제
//        초기에
//$n+1$개의 집합
//$\{0\}, \{1\}, \{2\}, \dots , \{n\}$이 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
//
//집합을 표현하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에
//$n$,
//$m$이 주어진다.
//$m$은 입력으로 주어지는 연산의 개수이다. 다음
//$m$개의 줄에는 각각의 연산이 주어진다. 합집합은
//        $0$
//$a$
//$b$의 형태로 입력이 주어진다. 이는
//$a$가 포함되어 있는 집합과,
//$b$가 포함되어 있는 집합을 합친다는 의미이다. 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은
//$1$
//        $a$
//$b$의 형태로 입력이 주어진다. 이는
//        $a$와
//$b$가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
//
//        출력
//1로 시작하는 입력에 대해서
//$a$와
//$b$가 같은 집합에 포함되어 있으면 "YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.
//골드5
public class Code_1717 {
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

    //같은 출력
    static void print(int a, int b){
        System.out.println(find(a) == find(b) ? "YES" : "NO");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent=new int[n + 1];
        size=new int[n + 1];
        for(int i=0;i<=n;i++) {
            parent[i]=i;  // 초기엔 자기 자신이 대표
            size[i]=1;
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a==0) {
                union(b,c);
            } else {
                print(b,c);
            }
        }
    }
}

