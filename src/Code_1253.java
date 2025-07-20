//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
// 왜 틀린지 모르겠음 다시 공부

//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//        2 초	256 MB	73660	18935	13473	24.611%
//        문제
//        N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
//
//        N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
//
//        수의 위치가 다르면 값이 같아도 다른 수이다.
//
//        입력
//        첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)
//
//        출력
//        좋은 수의 개수를 첫 번째 줄에 출력한다.
//골드4
////public class Code_1253 {
////    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        StringTokenizer st = new StringTokenizer(br.readLine());
////        int n = Integer.parseInt(st.nextToken());
////        int[] a = new int [n+1];
////        int count=0;
////
////        st = new StringTokenizer(br.readLine());
////        for(int i=1;i<=n;i++){
////            a[i] = Integer.parseInt(st.nextToken());
////        }
////
////        Arrays.sort(a);
////        int min=1;
////        int max=n;
////        if(a[min]>=0) //음수가없을때
////        {
////            for (int i = 3; i <= n; i++) {
////                min = 1;
////                max = i-1;
////                while (max>min) {
////                    if (a[min] + a[max] == a[i]) {
////                        count++;
////                        break;
////                    } else if (a[min] + a[max] < a[i]) {
////                        min++;
////                    } else if (a[min] + a[max] > a[i]) {
////                        max--;
////                    }
////
////
////                }
////
////
////            }
////        }
////
////        else {
////            for (int i = 1; i <= n; i++) {
////                min = 1;
////                max = n;
////                while (max > min) {
////                    if (a[min] + a[max] == a[i]) {
////                        if (min != i && max != i) {
////                            count++;
////                            break;
////                        } else if (min == i) {
////                            min++; // 자기 자신이면 건너뛰고 계속
////                        } else if (max == i) {
////                            max--;
////                        }
////                    } else if (a[min] + a[max] < a[i]) {
////                        min++;
////                    } else {
////                        max--;
////                    }
////                }
////
////                }
////
////
////            }
////        System.out.println(count);
////        }
////
////
////}


import java.io.*;
import java.util.*;

public class Code_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        int count = 0;

        for (int i = 0; i < n; i++) {
            int target = a[i];
            int left = 0, right = n - 1;

            while (left < right) {
                int sum = a[left] + a[right];

                if (sum == target) {
                    if (left != i && right != i) {
                        count++;
                        break; // target 만드는 두 수 찾았으니 break
                    } else if (left == i) {
                        left++;
                    } else if (right == i) {
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(count);
    }
}
