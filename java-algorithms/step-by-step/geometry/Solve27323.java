package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solve27323 {
    public static void main(String[] args) throws IOException {
        // 문제 : 직사각형
        //
        // N : 세로길이
        // M : 가로길이
        //
        // 해결책 : N * M 을 출력한다.
        // 1. N을 입력받고 R의 초기값으로 설정한다. 나눌 M은 2로 설정한다. (가장 작은 소수)
        // 2. R을 M으로 나누기 시작한다.
        //  - 나누어지는 경우 : M을 출력하고, R은 나뉜 값으로 초기화한다.
        //  - 나누어지지 않는 경우 : M을 1 증가시킨다.
        // 3. 위 과정을 N과 M이 같을 때까지 반복한다.
        //  - 복잡도 : N
        //
        //  - 시간복잡도 : O(1)

        Scanner scan = new Scanner(System.in);
        Integer n = scan.nextInt();
        Integer m = scan.nextInt();

        System.out.println(n * m);
    }
}
