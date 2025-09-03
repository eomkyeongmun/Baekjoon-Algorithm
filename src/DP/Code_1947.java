package DP;

import java.util.Scanner;

public class Code_1947 {
    static final long MOD = 1_000_000_000L;
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        if(n ==1) {
            System.out.println("0");
            return;
        }
        else if(n ==2) {
            System.out.println("1");
            return;
        }

        long d1=0; //1
        long d2=1; //
        //D(N)=(N-1)(D(N-1)+D(N-2))
        for(int i=3;i<=n;i++) {
            long next = ((d1+d2) % MOD) * (i-1) % MOD;
            d1= d2;
            d2= next;
        }
        System.out.println(d2 % MOD);

    }
}
