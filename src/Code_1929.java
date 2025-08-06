import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//소수 구하기
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	256 MB	322427	99841	70168	28.814%
//문제
//M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
//
//        입력
//첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
//
//출력
//한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
//실버3
public class Code_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean []isPrime = new boolean[n+1];
        isPrime[0] = true;
        isPrime[1] = true;
        for (int i=2;i*i<=n;i++) {
            if (!isPrime[i]) {
                for (int j=i*i;j<=n;j+=i) {
                    isPrime[j]=true; //j는 소수가 아니다
                }
            }
        }
        for (int i=m;i<=n;i++) {
            if (!isPrime[i]) {
                System.out.println(i);
            }
        }

        }
    }

