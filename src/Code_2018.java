import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	32 MB	32234	15617	11463	48.735%
//문제
//어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 이때, 사용하는 자연수는 N이하여야 한다.
//
//예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.
//
//N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.
//
//입력
//첫 줄에 정수 N이 주어진다.
//
//        출력
//입력된 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 출력하시오
//실버5
public class Code_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //투슬라이딩 윈도우
        int start = 1, end = 1, sum = 1;
        int count = 0;

        while (start <= n) {
            if (sum == n) {
                count++;
                end++;
                sum += end;
            } else if (sum < n) {
                end++;
                sum += end;
            } else { // sum > n
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
    }
}
