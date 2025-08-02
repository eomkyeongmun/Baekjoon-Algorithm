import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//K번째 수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	53778	20308	14862	38.251%
//문제
//세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.
//
//배열 A와 B의 인덱스는 1부터 시작한다.
//
//입력
//첫째 줄에 배열의 크기 N이 주어진다. N은 105보다 작거나 같은 자연수이다. 둘째 줄에 k가 주어진다. k는 min(109, N2)보다 작거나 같은 자연수이다.
//
//출력
//B[k]를 출력한다.
//골드1
public class Code_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        long left=1;
        long right=(long)N*N;
        long answer=0;

        while(left<=right) {
            long mid=(left+right)/2;
            long count=0;
            for (int i=1;i<=N;i++) {
                count += Math.min(mid/i, N);
            }
            if (count<M) {
                left=mid+1;
            } else {
                answer=mid;
                right=mid-1;
            }
        }
        System.out.println(answer);
    }
}