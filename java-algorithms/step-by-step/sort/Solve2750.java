package sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solve2750 {
    public static void main(String[] args) throws IOException {
        // 문제 : 수 정렬하기
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

        Scanner scan = new Scanner(System.in);
        Integer numCnt = scan.nextInt();
        ArrayList<Integer> numArr = new ArrayList<>();

        IntStream.range(0,numCnt).forEach(s -> numArr.add(scan.nextInt()));

        Collections.sort(numArr);

        for (Integer value : numArr) {
            System.out.println(value);
        }
    }
}
