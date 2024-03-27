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
        // 3. a1*n + a0 <= c * n 을 정리하고 a와 b에 대해 케이스 분류를 시작한다.
        //  : (a1-c)n + a0 <= 0
        //  a1-c가 음수일때 : n0 을 대입한 두 함수만 체크하고, 1을리턴한다.
        //  a1-c가 0일때 : 어떤 n이 들어와도 상관없으므로, a0의 값만 체크한다.
        //  a1-c가 양수일때 : 0을 리턴한다.
        //
        // 시간복잡도 : O(1)

        Scanner scan = new Scanner(System.in);
        Integer a1 = scan.nextInt();
        Integer a0 = scan.nextInt();
        Integer c = scan.nextInt();
        Integer n0 = scan.nextInt();

        Integer resultA = a1 * n0 + a0;
        Integer resultC = c * n0;

        // (a-c)n +b <= 0 가 성립하면 된다.
        if (a1 - c > 0) {
            System.out.println(0);  // 기울기가 C가 더 작다면 언젠가 결국 N에 대하여 만족되지 않는다.
            return;
        } else if (a1 == c) {    // 기울기가 같다면, B의 위치로 결정된다.
            if (a0 <= 0) {
                System.out.print(1);
                return;
            }
        }

        if (resultC < resultA) { // 기울기가 C가 더 크다면, 최소값 비교로 확인 가능하다.
            System.out.println(0);
            return;
        }
        System.out.print(1);
    }
}
