import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Code_1991 {
    static int[][] a;
static void preorder(int n){
    if(n==-1) return;
    System.out.print((char) (n + 'A'));
    preorder(a[n][0]);
    preorder(a[n][1]);
}
static void inorder(int n){
    if(n==-1) return;
    inorder(a[n][0]);
    System.out.print((char) (n + 'A'));
    inorder(a[n][1]);
}
static void postorder(int n){
    if(n==-1) return;
    postorder(a[n][0]);
    postorder(a[n][1]);
    System.out.print((char) (n + 'A'));
}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        a= new int[26][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0)-'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if(left == '.'){
                a[node][0] = -1;
            }
            else{
                a[node][0]= left -'A';
            }
            if(right == '.'){
                a[node][1] = -1;
            }
            else{
                a[node][1]= right -'A';
            }

        }
        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
        }

}
