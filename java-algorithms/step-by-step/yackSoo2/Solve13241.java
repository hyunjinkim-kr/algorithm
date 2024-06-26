package yackSoo2;

import java.io.*;
import java.util.StringTokenizer;

public class Solve13241 {
    public static void main(String[] args) throws IOException {
        // 문제 : 최소공배수
        // 최소공배수 LCM -> least common multiplier
        // 최대공약수 GCD -> greatest common divisor

        // 해결책 : 유클리드 호재법 사용해서 최대공약수를 구한 후, 두수의 곱을 나눈값이 최소공배수이다.
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            long inputNum1 = Long.parseLong(st.nextToken());
            long inputNum2 = Long.parseLong(st.nextToken());
            bw.write(getLCM(inputNum1, inputNum2) + "\n");
        }
    }

    public static long getLCM(long inputNum1, long inputNum2) {

        long gcbNum = getGCD(inputNum1, inputNum2);
        long lcmNum = inputNum1 * inputNum2 / gcbNum;

        return lcmNum;
    }

    public static long getGCD(long inputNum1, long inputNum2) {
        // GCD(A,B) = B*x + R = GCD(B,R)
        long A = inputNum1;
        long B = inputNum2;

        while (B!=0) {
            long modNum = A % B;
            A = B;
            B = modNum;
        }
        return A;
    }
}
