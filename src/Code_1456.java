import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//거의 소수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	256 MB	23171	5933	4045	24.201%
//문제
//어떤 수가 소수의 N제곱(N ≥ 2) 꼴일 때, 그 수를 거의 소수라고 한다.
//
//두 정수 A와 B가 주어지면, A보다 크거나 같고, B보다 작거나 같은 거의 소수가 몇 개인지 출력한다.
//
//입력
//첫째 줄에 왼쪽 범위 A와 오른쪽 범위 B가 공백 한 칸을 사이에 두고 주어진다.
//
//출력
//첫째 줄에 총 몇 개가 있는지 출력한다.
//골드5
public class Code_1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int sqrtB = (int) Math.sqrt(b);
        boolean[] isPrime = new boolean[sqrtB+1];
        isPrime[0] = true;
        isPrime[1] = true;
        for (int i=2;i*i<=sqrtB;i++) {
            if (!isPrime[i]) {
                for (int j=i*i;j<=sqrtB;j+=i) {
                    isPrime[j] = true;
                }
            }
        }
        int count=0;
        for (int i=2;i<=sqrtB;i++) {
            if (!isPrime[i]) {
                long num=(long)i*i;
                while (num<=b) {
                    if (num>=a) count++;
                    if (num>b/i) break;
                    num*=i;
                }
            }
        }
        System.out.println(count);
    }
}
