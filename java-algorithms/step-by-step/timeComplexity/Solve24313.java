package timeComplexity;

import java.io.IOException;
import java.util.Scanner;

public class Solve24313 {
    public static void main(String[] args) throws IOException {
        // 문제 : 알고리즘 수업 - 점근적 표기 1
        //
        // 해결책 : 두개 함수에 대하여 g(n)이 최소값 n0 보다 크다는 것을 만족하는지 케이스를 분류한다.
        // 1. f(n) = an + b 이고 g(n) = c*n 이다.
        // 2. g(n) > f(n) 이 최소값 n0 보다 큰 n에 대해 항상 만족해야 한다.
        // 3. an + b <= c * n 을 정리하고 a와 b에 대해 케이스 분류를 시작한다.
        //  : (a-c)n + b <= 0
        //  a-c가 음수일때 : n0 을 대입한 두 함수만 체크하고, 1을리턴한다 (둘다 순 증가함수이므로)
        //  a-c가 0일때 : 어떤 n이 들어와도 상관없으므로, b의 값만 체크한다.
        //  a-c가 양수일때 : 0을 리턴한다.
        //
        // 시간복잡도 : O(N)

        Scanner scan = new Scanner(System.in);
        Integer inputN1 = scan.nextInt();
        Integer inputN2 = scan.nextInt();
        Integer inputC = scan.nextInt();
        Integer inputN0 = scan.nextInt();

        Integer resultN = inputN1 * inputN0 + inputN2;
        Integer resultC = inputC * inputN0;

        // (a-c)n +b <= 0 가 성립하면 된다.
        // a-c가 음수면 증가하는 함수이므로 최소값을 넣을때 값을 비교해야한다..
        // 음수면 무조건 -1을 뱉어야 할것같다..
        if (inputN1 - inputC < 0) {
            if (resultC < resultN) { // 기울기가 C가 더 크다면, 최소값 비교로도 확인 가능하다.
                System.out.println(0);
                return;
            }
            System.out.print(1);
            return;
        } else if (inputN1 == inputC) {    // 기울기가 같다면, B의 위치로 결정된다.
            if (inputN2 <= 0) {
                System.out.print(1);
                return;
            }
        }
        System.out.println(0);  // 기울기가 C가 더 작다면 언젠가 결국 N은 만족되지 않는다.
    }
}
