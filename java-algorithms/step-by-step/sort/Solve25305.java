package sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solve25305 {
    public static void main(String[] args) throws IOException {
        /*
         문제 : 커트라인
         수를 입력받고 정렬한 후 결과 출력

         1. 수를 입력받은후 내림차순으로 정렬
         2. 해당하는 커트라인에 해당하는 사람 점수를 출력

         시간복잡도 : N + NlogN
         O(NlogN)
        */
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> numArr = new ArrayList<>();

        Integer peopleCnt = scan.nextInt();
        Integer cutLine = scan.nextInt();

        IntStream.range(0, peopleCnt).forEach(s -> numArr.add(scan.nextInt()));
        // 내림차순으로 정렬
        Collections.sort(numArr, Comparator.reverseOrder());
        System.out.println(numArr.get(cutLine - 1));
    }
}
