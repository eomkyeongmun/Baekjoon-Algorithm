import java.io.*;
//수 정렬하기 3
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//5 초 (하단 참고)	8 MB (하단 참고)	358383	86386	66140	23.995%
//문제
//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
//
//출력
//첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
public class Code_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
       int []count = new int[10001]; //계수정렬

        for(int i = 0; i < n; i++){
            count[Integer.parseInt(br.readLine())]++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 10001; i++){
            while(count[i] > 0){
                bw.write(i + "\n");
                count[i]--;
            }
        }
        bw.flush();

    }
}
