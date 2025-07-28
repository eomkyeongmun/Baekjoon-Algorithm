import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//버블 소트 
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	512 MB	38666	11157	7711	31.084%
//문제
//N개의 수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에 대해서 버블 소트를 수행할 때, Swap이 총 몇 번 발생하는지 알아내는 프로그램을 작성하시오.
//
//버블 소트는 서로 인접해 있는 두 수를 바꿔가며 정렬하는 방법이다. 예를 들어 수열이 3 2 1 이었다고 하자. 이 경우에는 인접해 있는 3, 2가 바뀌어야 하므로 2 3 1 이 된다. 다음으로는 3, 1이 바뀌어야 하므로 2 1 3 이 된다. 다음에는 2, 1이 바뀌어야 하므로 1 2 3 이 된다. 그러면 더 이상 바꿔야 할 경우가 없으므로 정렬이 완료된다.
//
//        입력
//첫째 줄에 N(1 ≤ N ≤ 500,000)이 주어진다. 다음 줄에는 N개의 정수로 A[1], A[2], …, A[N]이 주어진다. 각각의 A[i]는 0 ≤ |A[i]| ≤ 1,000,000,000의 범위에 들어있다.
//
//        출력
//첫째 줄에 Swap 횟수를 출력한다
//다시 풀기
public class Code_1517 {
    public static long merge_sort(int[] a,int left,int right){
        if(left>=right) return 0;
        long count=0;
        int mid=(left+right)/2;
        count+= merge_sort(a,left,mid);
        count+= merge_sort(a,mid+1,right);
        count+= merge(a,left,mid,right);
        return count;
    }
    public static long merge(int[] a,int left,int mid,int right){
        int[] temp=new int[right-left+1];
        int i=left,j=mid+1,k=0;
        long count=0;
        while(i<=mid && j<=right){
            if(a[i]<=a[j]){
                temp[k++]=a[i++];
            }
            else{
                count+=(mid-i+1);
                temp[k++]=a[j++];
            }
        }

        while(i<=mid){
            temp[k++]=a[i++];
        }
        while(j<=right){
            temp[k++]=a[j++];
        }
        System.arraycopy(temp, 0, a, left, temp.length);
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        long result= merge_sort(a,0,n-1);

        System.out.println(result);
    }
}
