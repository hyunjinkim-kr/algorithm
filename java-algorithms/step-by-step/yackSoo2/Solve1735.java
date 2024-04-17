package yackSoo2;

import java.io.*;
import java.util.StringTokenizer;

public class Solve1735 {
    public static void main(String[] args) throws IOException {
        // 문제 : 분수 합

        // 해결책 : 두 분수를 분모의 곱을 한 뒤 합하고, 유클리드 호재법으로 구한 최대공약수로 각각 나눈다.
        //
        //  A : 입력받은 첫번째 분자
        //  B : 입력받은 첫번째 분모
        //  C : 입력받은 두번째 분자
        //  D : 입력받은 두번째 분모
        //  N : A*D + B*C
        //  M : B*D
        //
        // 1. 두 분수를 입력받는다.
        // 2. 두 수를 합한다. 분모는 서로 곱하고, 분자는 대응되는 분모를 곱한 후 더한다.
        // 3. 분자와 분모를 최대공약수로 나눈 후 출력한다.
        //
        // -- 유클리드 호제법 시간복잡도 최악 : 두 수가 서로소인 경우 (최대공약수가 1),
        // -- 두 수 n,m 일때 작은수 만큼 연산이 이루어져야함
        // -- 연속된 피보나치 수열도 최악의 경우를 지님.
        // 시간복잡도 : O(log min(N, M))

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)
        ) {
            // Logic 구현부
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            Integer st1Mol = Integer.parseInt(st1.nextToken());
            Integer st1Denom = Integer.parseInt(st1.nextToken());

            Integer st2Mol = Integer.parseInt(st2.nextToken());
            Integer st2Denom = Integer.parseInt(st2.nextToken());

            Integer mol = (st1Mol * st2Denom) + (st1Denom * st2Mol);
            Integer denom = st1Denom * st2Denom;
            Integer gcdNum = getGCD(mol, denom);

            bw.write(mol / gcdNum + " " + denom / gcdNum);
        }
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
