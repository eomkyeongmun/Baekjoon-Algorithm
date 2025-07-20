import java.io.*;
import java.util.*;

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
