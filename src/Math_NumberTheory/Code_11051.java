package Math_NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int MOD = 10007;
        //nCr=n-1Cr+n-1Cr-1
        int[][] C = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= Math.min(i, m); j++) {
                if (j == i) C[i][j] = 1;
                else C[i][j] = (C[i-1][j] + C[i-1][j-1]) % MOD;
            }
        }
        System.out.println(C[n][m]);
    }
}
