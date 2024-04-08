package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solve1427 {
    public static void main(String[] args) throws IOException {
        // 문제 : 소트인사이드
        // 해결책 : 내림차순 정렬
        //
        // N : 입력받은 숫자의 길이
        // arr : N 짜리 수열
        //
        // 1. 수가 입력되면 1글자씩 쪼개어 배열에 저장한다.
        // -- 복잡도 : N
        // 2. 배열을 내림차순으로 정렬한다.
        // -- 복잡도 : NlogN
        // 3. 배열을 출력한다.
        // -- 복잡도 : N
        //
        // 시간복잡도 : 2N + NlogN
        // O(NlogN)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numStr = br.readLine();
        ArrayList<Character> numArr = new ArrayList<>();

        for (int i = 0; i < numStr.length(); i++) {
            char number = numStr.charAt(i);
            numArr.add(number);
        }
        br.close();

        Collections.sort(numArr,Collections.reverseOrder());

        for (int i = 0; i < numArr.size(); i++) {
                bw.write(numArr.get(i));
        }
        bw.flush();
        bw.close();
    }
}
