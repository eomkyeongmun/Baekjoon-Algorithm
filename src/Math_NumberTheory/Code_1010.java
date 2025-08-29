package Math_NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int [][]a=new int[31][31];

        for(int i=1;i<=30;i++){
        for(int j=1;j<=i;j++){
            if(i==j) {
                a[i][j]=1;
            }
            else if(j==1) {
                a[i][j]=i;
            }
            else {
                a[i][j]=a[i-1][j-1]+a[i-1][j];
            }
        }
        }
        for(int i=1;i<=N;i++){
            st= new StringTokenizer(br.readLine());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            System.out.println(a[c][b]);
        }

    }
}
