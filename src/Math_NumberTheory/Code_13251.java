package Math_NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_13251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int sum=0;
        int []a = new int[M];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            a[i]=Integer.parseInt(st.nextToken());
            sum=sum+a[i];
        }

        int k=Integer.parseInt(br.readLine());

       double q=0.0;
       for(int i=0;i<M;i++){
           if(a[i]<k) continue;
           double p=1.0;
           for(int t=0;t<k;t++){
               p=p*(double)(a[i]-t)/(double)(sum-t);
           }
           q=q+p;
       }

            System.out.printf("%.15f%n", q);

    }
}
