package Math_NumberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1256 {
    static final long CAP = 1_000_000_001L; // 상한값
    static long[][] comb; // 조합 수 DP (cap 적용)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // a 개수
        int M = Integer.parseInt(st.nextToken()); // z 개수
        long K = Long.parseLong(st.nextToken());  // K번째


        int MAX = N + M;
        comb = new long[MAX + 1][MAX + 1];
        for (int i = 0; i <= MAX; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = Math.min(CAP, comb[i-1][j-1] + comb[i-1][j]); //콤비네이션
            }
        }

        // 전체 경우의 수가 K보다 작으면 -1 출력
        long total = comb[N + M][N];
        if (total < K) {
            System.out.println(-1);
            return;
        }

        // 문자결정
        StringBuilder sb = new StringBuilder(N + M);
        int a = N, z = M;
        long k = K; // 진행용

        while (a > 0 || z > 0) {
            if (a == 0) { // 남은 건 모두 z
                sb.append('z');
                z--;
            } else if (z == 0) { // 남은 건 모두 a
                sb.append('a');
                a--;
            } else {
                // 첫 글자를 'a'로 두었을 때의 개수
                long count = comb[a + z - 1][a - 1]; //(N+M) C N에서 맨앞이 a이므로 -1씩빼서
                if (k <= count) {
                    sb.append('a');
                    a--;
                } else {
                    sb.append('z');
                    z--;
                    k -= count;
                }
            }
        }

        System.out.println(sb.toString());
    }

}
