import java.util.Scanner;
//소트인사이드
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	117548	77364	63570	66.080%
//문제
//배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
//
//        입력
//첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
//
//출력
//첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
//실버 5
public class Code_1427 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int [] a = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            a[i] = s.charAt(i)-'0';
        }
        int max;
        for(int i = 0; i < s.length(); i++){
            max=a[i];
            for(int j = i+1; j < s.length(); j++){
                if(a[j]>max){
                    max=a[j];
                    int temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }
        String b = sb.toString();
        System.out.println(b);
    }

}
// 내장정렬 사용하는 코드
// char[] arr = s.toCharArray();
// Arrays.sort(arr);                  // 오름차순 정렬
// String result = new StringBuilder(new String(arr))
//        .reverse()   // 뒤집어서 내림차순
//        .toString();
// System.out.println(result);
