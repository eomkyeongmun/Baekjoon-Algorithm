import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//소수&팰린드롬
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	256 MB	36084	11983	8857	31.284%
//문제
//어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라 부른다. 예를 들어 79,197과 324,423 등이 팰린드롬 수이다.
//
//어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때, N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N이 주어진다.
//
//출력
//첫째 줄에 조건을 만족하는 수를 출력한다.
//실버1
public class Code_1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean []isPrime=new boolean[2000001];
        isPrime[0]=true;
        isPrime[1]=true;

        for(int i=2; i*i<=2000000; i++) {
            if (!isPrime[i]) {
                for (int j=i*i;j<=2000000;j+=i) {
                    isPrime[j] = true;
                }
            }
        }
        for (int i=N;i<=2000000; i++) {
                if(!isPrime[i]) {
                    int temp=i;
                    int p=0;
                    while(temp>0){
                        p=p*10+temp%10;
                        temp=temp/10;
                    }
                    if(i==p){
                        System.out.print(i);
                        break;
                    }
                }

            }

    }
}
