import java.io.*;
import java.util.*;
//최솟값 찾기 성공
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2.4 초 (하단 참고)	512 MB	51014	16751	10595	31.498%
//문제
//N개의 수 A1, A2, ..., AN과 L이 주어진다.
//
//        Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.
//
//입력
//첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)
//
//둘째 줄에는 N개의 수 Ai가 주어진다. (-109 ≤ Ai ≤ 109)
//
//출력
//첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.
//플레티넘 5
public class Code_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int now = a[i];


            while (!dq.isEmpty() && a[dq.peekLast()] > now) {
                dq.pollLast();
            }


            dq.offerLast(i);


            if (dq.peekFirst() <= i - L) {
                dq.pollFirst();
            }


            bw.write(a[dq.peekFirst()] + " ");
        }

        bw.close();
        br.close();
    }
}
