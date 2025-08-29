package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_10868 {
    static int N,M;
    static int[] arr;
    static int[] seg;
    static void build(int node,int l,int r) {
        if (l==r) {
            seg[node]=arr[l];
            return;
        }
        int mid=(l+r)/ 2;
        int left=node*2;
        int right=node*2+1;
        build(left,l,mid);
        build(right,mid+1,r);
        seg[node] = Math.min(seg[left],seg[right]); // 두 자식의 최솟값
    }

    static int query(int node,int l,int r,int ql,int qr) {
        if (qr<l||r<ql) return Integer.MAX_VALUE;
        if (ql<=l&&r<=qr) return seg[node];
        int mid=(l+r)/2;
        int leftMin=query(node*2,l,mid,ql,qr);
        int rightMin=query(node*2+1,mid+1,r,ql,qr);
        return Math.min(leftMin,rightMin);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        seg = new int[4 * N];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        build(1,1,N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a>b){int t=a;a=b;b=t;}
            System.out.println(query(1, 1, N, a, b));
        }
    }

}