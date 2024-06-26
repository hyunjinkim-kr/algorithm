package combinatorics;

import java.io.*;

public class Solve24723 {
    public static void main(String[] args) throws IOException {
        Integer result = 1;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            // 입력 수
            Integer N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                result *= 2;
            }

        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }
}
