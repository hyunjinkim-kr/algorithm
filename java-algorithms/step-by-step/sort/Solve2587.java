package sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solve2587 {
    public static void main(String[] args) throws IOException {
        /*
         문제 : 대표값2
         수를 입력받고 정렬한 후 결과 출력

         1. 입력받은 수를 배열에 넣음
         2. 배열 전체의 합을 배열길이만큼 나눔 (평균)
         3. 배열을 정렬한 후, 배열 길이의 중간값을 출력 (중간)

         시간복잡도 : 2N + NlogN
         O(NlogN)
        */
        final Integer numCnt = 5;
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> numArr = new ArrayList<>();

        IntStream.range(0, numCnt).forEach(s -> numArr.add(scan.nextInt()));
        Collections.sort(numArr);
        showResult(numArr);
    }

    public static void showResult(ArrayList<Integer> numArr) {
        Integer sum = 0;
        for (Integer value : numArr) {
            sum += value;
        }
        // 평균
        System.out.println(sum / numArr.size());
        // 중간값
        System.out.println(numArr.get(numArr.size() / 2));
    }
}
