package combinatorics;

import java.io.*;

public class Solve10872 {
    public static void main(String[] args) throws IOException {
        Integer result = 1;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            // 입력 수
            Integer N = Integer.parseInt(br.readLine());
            for (int i = N; i > 0; i--) {
                result *= i;
            }

        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }
}
