import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//제곱 ㄴㄴ 수
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	76180	15798	11242	22.810%
//문제
//어떤 정수 X가 1보다 큰 제곱수로 나누어 떨어지지 않을 때, 그 수를 제곱ㄴㄴ수라고 한다. 제곱수는 정수의 제곱이다. min과 max가 주어지면, min보다 크거나 같고, max보다 작거나 같은 제곱ㄴㄴ수가 몇 개 있는지 출력한다.
//
//입력
//첫째 줄에 두 정수 min과 max가 주어진다.
//
//        출력
//첫째 줄에 min보다 크거나 같고, max보다 작거나 같은 제곱ㄴㄴ수의 개수를 출력한다.
//
//제한
//1 ≤ min ≤ 1,000,000,000,000
//min ≤ max ≤ min + 1,000,000
//골드 1
public class Code_1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int size=(int)(max-min+1);
        boolean[] isNo=new boolean[size];

        Arrays.fill(isNo,true);

        for(long i=2;i*i<=max;i++){
            //제곱수
            long square=i*i;
            //min 이상의 제곱수중에 가장 작은값
            //ex) min=15이면 16
            long start =((min+square-1)/square)*square;
            for(long j=start;j<=max;j+=square){
                //max-min이므로 실제로 j-min을 해야 위치에 맞는 false
                isNo[(int)(j-min)]=false;
            }
        }

        int count=0;
        for(boolean b:isNo){
            if(b){count++;}
        }
        System.out.println(count);
    }
}
