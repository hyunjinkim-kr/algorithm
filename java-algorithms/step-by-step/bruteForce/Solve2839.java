package bruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Function;

public class Solve2839 {
    public static void main(String[] args) throws Exception {
        // 문제 : 설탕 배달
        // 해결책 : 5로 나뉠수 있을 만큼 나뉘고, 3으로 나뉠때 나머지가 0인경우를 계산
        //
        // 1. 5봉투의 갯수가 가능한 범위를 탐색한다.
        // 2. 5로 담은 나머지 부분이 3으로 담기면 바로 반환한다.
        //
        // 복잡도 : O(N)
        Scanner scan = new Scanner(System.in);
        Integer num = scan.nextInt(); // 입력받은 숫자

        Integer result = isValidBongji(num);

        System.out.print(result);
    }

    public static Integer isValidBongji(Integer testNum) {
        for (int i = testNum / 5; i >= 0; i--) {
            if ((testNum - 5 * i) % 3 == 0) {
                return (testNum - 5 * i) / 3 + i;
            }
        }
        return -1;
    }
}