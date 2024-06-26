package combinatorics;

import java.io.*;
import java.util.StringTokenizer;

public class Solve11050 {

    public static void main(String[] args) throws IOException {
        Integer result = 1;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            // 입력 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer N = Integer.parseInt(st.nextToken());
            Integer K = Integer.parseInt(st.nextToken());

            Integer resultN = 1;
            Integer resultK = 1;

            for (int i = K; i > 0; i--) {
                resultN *= N;
                resultK *= i;

                N--;
            }
            result = resultN / resultK;

        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }
}
