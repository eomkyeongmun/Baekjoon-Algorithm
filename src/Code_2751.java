import java.io.*;
//수 정렬하기 2
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	256 MB	383998	120544	84579	31.684%
//문제
//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
//
//        출력
//첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
public class Code_2751 {
    public static int[] merge_sort(int[] a){
        if(a.length <=1){
            return a;
        }
        int mid= a.length/2;
        int [] left=new int[mid];
        int[] right=new int[a.length-mid];
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < a.length; i++) {
            right[i - mid] = a[i];
        }
        return merge(merge_sort(left),merge_sort(right));
    }

    public static int[] merge(int[] a, int[] b){
    int []merged=new int[a.length + b.length];
    int i=0,j=0,k=0;

    while(i<a.length && j<b.length){
        if(a[i]<b[j]){
            merged[k++]=a[i++];
        }
        else{
            merged[k++]=b[j++];
        }
    }
        while (i < a.length) {
            merged[k++] = a[i++];
        }
        while (j < b.length) {
            merged[k++] = b[j++];
        }

        return merged;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int []a = new int[N];
        for(int i=0;i<N;i++)
            a[i]= Integer.parseInt(br.readLine());

        int [] result = merge_sort(a);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<N;i++)
           bw.write(result[i]+"\n");

        bw.flush();
    }


}
