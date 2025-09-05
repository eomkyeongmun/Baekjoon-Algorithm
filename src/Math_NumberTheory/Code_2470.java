package Math_NumberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] a = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) a[i] = Long.parseLong(st.nextToken());

        Arrays.sort(a); //정렬

        int l=0,r=N-1;
        long best = a[l] + a[r];
        long target1 = a[l], target2 = a[r];

        while (l<r){
            long s = a[l] + a[r];
            if (Math.abs(s)<Math.abs(best)) {
                best = s;
                target1 = a[l];
                target2 = a[r];
                if (best == 0) break;
            }
            if (s>0) r--;
            else     l++;
        }

        System.out.println(target1 + " " + target2);
    }
}
