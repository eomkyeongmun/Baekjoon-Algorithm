import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//나머지 합
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	68681	19337	13784	26.574%
//문제
//수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
//
//즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
//
//입력
//첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
//
//둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
//
//출력
//첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
//골드 3


public class Code_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] sum = new long[n + 1];  // 누적합
        long[] remainCount = new long[m];  // 나머지 카운트
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + num;

            int r = (int)(sum[i] % m);

            // 나머지가 0이면 (1~i) 구간이 바로 유효
            if (r == 0) answer++;

            // 나머지 카운트 증가
            remainCount[r]++;
        }

        // 같은 나머지끼리 2개 뽑는 조합 추가
        for (int i = 0; i < m; i++) {
            if (remainCount[i] > 1) {
                answer += (remainCount[i] * (remainCount[i] - 1)) / 2;
            }
        }

        System.out.println(answer);
    }
}
