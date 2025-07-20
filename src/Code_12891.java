import java.io.*;
import java.util.*;
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	33780	12553	9066	35.616%
//문제
//평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다. DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다. 예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다. 이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분문자열을 비밀번호로 사용하기로 마음먹었다.
//
//하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다. 임의의 DNA 문자열의 부분문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다. 그래서 민호는 부분문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.
//
//임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분문자열의 길이를 4라고 하자. 그리고 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자. 이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다. 하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다.
//
//민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이, 그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 순서대로 주어졌을 때 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자. 단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.
//
//        입력
//첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분문자열의 길이 |P| 가 주어진다. (1 ≤ |P| ≤ |S| ≤ 1,000,000)
//
//두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.
//
//세번 째 줄에는 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다. 각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.
//실버2
public class Code_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());     
        int size = Integer.parseInt(st.nextToken());  

        String a = br.readLine();  

        st = new StringTokenizer(br.readLine());
        int An = Integer.parseInt(st.nextToken());
        int Cn = Integer.parseInt(st.nextToken());
        int Gn = Integer.parseInt(st.nextToken());
        int Tn = Integer.parseInt(st.nextToken());
        
        int Ac = 0, Cc = 0, Gc = 0, Tc = 0;

       //시작 부분 체크
        for (int i = 0; i < size; i++) {
            char ch = a.charAt(i); 
            if (ch == 'A') Ac++;
            else if (ch == 'C') Cc++;
            else if (ch == 'G') Gc++;
            else Tc++;
        }

        int count = 0;
        if (Ac >= An && Cc >= Cn && Gc >= Gn && Tc >= Tn) count++;

        // 시간복잡도 O(n) 슬라이딩 윈도우
        for (int i = size; i < n; i++) {
            char remove = a.charAt(i - size); //빠지는 문자
            if (remove == 'A') Ac--;
            else if (remove == 'C') Cc--;
            else if (remove == 'G') Gc--;
            else Tc--;

            char add = a.charAt(i); //들어오는 문자
            if (add == 'A') Ac++;
            else if (add == 'C') Cc++;
            else if (add == 'G') Gc++;
            else Tc++;

            if (Ac >= An && Cc >= Cn && Gc >= Gn && Tc >= Tn) {
                count++;
            }
        }

        System.out.println(count);
    }
}
