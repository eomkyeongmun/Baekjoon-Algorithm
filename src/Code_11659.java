import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//문제
//수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
//
//        입력
//첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
//
//        출력
//총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
//제한
//        1 ≤ N ≤ 100,000
//        1 ≤ M ≤ 100,000
//        1 ≤ i ≤ j ≤ N       실버3
public class Code_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] sum = new long[N+1];
        long[] part = new long[M];
        long[] a = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <=N ; n++) {
            a[n] = Long.parseLong(st.nextToken());
            sum[n] = sum[n-1]+ a[n];
        }
        for (int n = 0; n < M; n++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (q == 1)
                part[n] = sum[r];
            else {
                part[n] = sum[r] - sum[q - 1];
            }

            System.out.println(part[n]);
        }
    }

}
