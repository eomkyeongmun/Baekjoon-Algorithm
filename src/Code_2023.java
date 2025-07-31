import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//신기한 소수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	4 MB	31093	15193	10651	46.359%
//문제
//수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 가지고 노는 것이다. 요즘 수빈이가 가장 관심있어 하는 소수는 7331이다.
//
//7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다. 즉, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.
//
//수빈이는 N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 궁금해졌다. N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두 찾아보자.
//
//        입력
//첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
//
//출력
//N자리 수 중에서 신기한 소수를 오름차순으로 정렬해서 한 줄에 하나씩 출력한다.
//골드5
public class Code_2023 {
    static int N ;

    static boolean isPrime(int n) {
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void DFS(int n,int j){
        if(j==N){
            if(isPrime(n)){
                System.out.println(n);
            }
            return;
        }
        for(int i=1;i<10;i++){
            if(i%2==0){
                continue;
            }
            if(isPrime(n*10+i)){
                DFS(n*10+i,j+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }
}
