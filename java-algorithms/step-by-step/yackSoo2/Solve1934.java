package yackSoo2;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solve1934 {
    public static void main(String[] args) throws IOException {
        // 문제 : 최소공배수
        // 최소공배수 LCM -> least common multiplier
        // 최대공약수 GCD -> greatest common divisor

        // 해결책 : 소인수분해의 곱을 했을때, 메모리초과가 떴다.
        //  -> 유클리드 호재법 사용해서 최대공약수를 구한 후, 두수의 곱을 나눈값이 최소공배수이다.
        //
        //  N : 입력받은 수 1
        //  M : 입력받은 수 2
        //
        // 1. 두 수를 입력받아, 최대 공약수를 구한다.
        // 2. 입력받았던 두 수를 곱한뒤 최대공약수로 나눈값을 출력한다.
        // -- 유클리드 호제법 시간복잡도 최악 : 두 수가 서로소인 경우 (최대공약수가 1),
        // -- 두 수 n,m 일때 작은수 만큼 연산이 이루어져야함
        // -- 연속된 피보나
        // 시간복잡도 : O(log min(N, M))

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)
        ) {
            // Logic 구현부
            Integer inputCnt = Integer.parseInt(br.readLine());
            // 저장
            for (int i = 0; i < inputCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Integer inputNum1 = Integer.parseInt(st.nextToken());
                Integer inputNum2 = Integer.parseInt(st.nextToken());
                bw.write(getLCM(inputNum1, inputNum2) + "\n");
            }
        }
    }

    public static Integer getLCM(Integer inputNum1, Integer inputNum2) {

        Integer gcbNum = getGCD(inputNum1, inputNum2);
        Integer lcmNum = inputNum1 * inputNum2 / gcbNum;

        return lcmNum;
    }

    public static Integer getGCD(Integer inputNum1, Integer inputNum2) {
        // GCD(A,B) = B*x + R = GCD(B,R)
        Integer A = inputNum1;
        Integer B = inputNum2;

        while (!B.equals(0)) {
            Integer modNum = A % B;
            A = B;
            B = modNum;
        }
        return A;
    }
}
