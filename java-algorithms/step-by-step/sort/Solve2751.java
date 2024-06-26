package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solve2751 {
    public static void main(String[] args) throws IOException {
        // 문제 : 수 정렬하기 2
        // 수를 입력받고 정렬하기
        //
        // 1. 입력받은 수를 배열에 넣는다.
        // -- 복잡도 : N
        // 2. 수를넣은 배열을 정렬한다.
        // -- 복잡도 : NlogN
        // 3. 배열을 출력한다.
        // -- 복잡도 : N
        //
        // 시간복잡도 : 2N + NlogN
        // O(NlogN)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer numCnt = Integer.parseInt(br.readLine());
        ArrayList<Integer> numArr = new ArrayList<>();

        for (int i = 0; i < numCnt; i++) {
            numArr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(numArr);

        for (Integer value : numArr) {
            bw.write(value + "\n");
        }
        bw.flush();
        bw.close();
    }
}