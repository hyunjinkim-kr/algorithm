package advanced2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solve1037 {
    public static void main(String[] args) throws IOException {
        Integer result;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            // 입력 수
            Integer T = Integer.parseInt(br.readLine());
            ArrayList<Integer> numList = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < T; i++) {
                Integer A = Integer.parseInt(st.nextToken());
                numList.add(A);
            }

            Collections.sort(numList);
            result = numList.get(0) * numList.get(numList.size()-1);
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }
}
