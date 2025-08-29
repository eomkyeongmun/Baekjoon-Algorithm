import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_2775 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int [][] home = new int[15][15];
        for(int i = 0; i <= 14; i++){
            home[0][i] = i;
        }
    for(int i = 1; i <= 14; i++) {
        home[i][1]=1;
        for(int j = 2; j <= 14; j++) {
        home[i][j]=home[i][j-1]+home[i-1][j];
        }
    }
    for(int i = 1; i <= N; i++) {
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.println(home[a][b]);
    }
    }
}
