package baseConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문제 : 중앙 이동 알고리즘
//해결책 : 수행을 할때마다 사각형이 두배로 늘어나므로, 2의 제곱근만큼 사각형이 늘어나는것에 기인한다.
// C : 입력된 계산 횟수
//
// 1. 사각형의 갯수는 횟수가 진행됨에 따라 두배씩 증가한다. 점의 개수는 사각형의 갯수에 1을 더하면 된다.
//    따라서 한 행의 점 갯수는, 수행만큼의 2의 제곱을 한 후 1을 더한다.
//  -- 복잡도 : 1
// 2. 정사각형이므로 한 행의 점 갯수를 제곱을한다.
//  -- 복잡도 : 1
//
// --시간복잡도 : 2
public class Solve2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer excuteCount = Integer.parseInt(br.readLine()); // 수행횟수 N
        final Integer squareDoubled = 2; // 사각형을 나누는 행위 기준값

        Integer dotRowCount = (int) Math.pow(squareDoubled, excuteCount) + 1;
        Integer answer = (int) Math.pow(dotRowCount, 2);
        System.out.print(answer);
    }
}
