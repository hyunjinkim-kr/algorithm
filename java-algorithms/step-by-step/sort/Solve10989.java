package sort;

import java.io.*;
import java.util.*;

public class Solve10989 {
    public static void main(String[] args) throws IOException {
        // 문제 : 수 정렬하기 3
        // 해결책 : 계수정렬 적용하기
        //
        // N : 숫자를 입력하는 횟수
        // arr : 10001개 짜리 수열 (수가 입력될때마다 카운트를 저장)
        //
        // 1. 수가 입력되면 해당하는 위치 배열을 1 증가시킨다.
        // -- 복잡도 : N
        // 3. 배열을 출력한다.
        // -- 복잡도 : N
        //
        // 시간복잡도 : 2N
        // O(N)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer numCnt = Integer.parseInt(br.readLine());
        // 1만 이하의 자연수를 저장하는 녀으석
        ArrayList<Integer> numArr = new ArrayList<Integer>(Collections.nCopies(10001, 0));

        for (int i = 0; i < numCnt; i++) {
            Integer number = Integer.parseInt(br.readLine());
            Integer arrValue = numArr.get(number);
            arrValue += 1;
            numArr.set(number,arrValue);
        }
        br.close();

        //Collections.sort(numArr);
        // 정렬을 할 필요가 없죠.

        for (int i = 1; i < numArr.size(); i++) {
            if ( numArr.get(i).equals(0)) {
                continue;
            }
            for (int j = 0; j < numArr.get(i); j++) {
                bw.write(i  + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
