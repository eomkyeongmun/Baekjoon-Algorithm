import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_11050 {
    static int Combination(int n, int k) {
        if(k == 0 || n==k) return 1;
        else return Combination(n-1, k)+Combination(n-1, k-1);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //nCr=n-1Cr+n-1Cr-1
        int k=Combination(n, m);
        k=k%10007;
        System.out.println(k);
    }
}
