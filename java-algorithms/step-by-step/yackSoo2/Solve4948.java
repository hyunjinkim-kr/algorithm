package yackSoo2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solve4948 {
    // 문제 : 베르트랑 공준
    // 2N보다 작은 소수집합을 구하고, N보다 큰 경우에만 출력한다.
    //
    // N : 입력값. N 초과 소수를 찾아야한다.
    // M : 입력값*2. 2N 이하 소수를 찾아야한다.
    //
    // 1. 2부터 최대값 N 의 범위의 소수를 구한다.
    //   -- 복잡도 : (N-2) * 루트(N)
    // 2. 소수로 판별된 숫자를 리스트에 저장한다. 2부터 M 의 제곱근 사이의 숫자를 반복체크하며 이전 리스트를 참고한다.
    // 3. 리스트에 담긴 숫자중 N보다 큰 경우에만 출력한다.
    //
    // -- 시간복잡도 : O( N * 루트(N) )
    public static void main(String[] args) throws IOException {

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)
        ) {
            while (true) {
                Integer no1 = Integer.parseInt(br.readLine());
                Integer no2 = 2 * no1;
                Integer cnt = 0;

                if (no1.equals(0)) {
                    break;
                }
                ArrayList<Integer> primeList = getSmallerPrimeList(no2);

                for (Integer prime : primeList) {
                    if (prime > no1) {
                        cnt++;
                    }
                }
                bw.write(cnt + "\n");
            }
        }
    }

    public static ArrayList<Integer> getSmallerPrimeList(Integer upperBound) {
        ArrayList<Integer> primeList = new ArrayList<>();

        for (int i = 2; i <= upperBound; i++) {
            if (isPrime(i, primeList)) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    public static boolean isPrime(long N, ArrayList<Integer> primeList) {
        // 올바르게 동작하기 위한 primeList의 조건.
        // 1.primeList는 정렬되어야 한다.
        // 2.제곱근 N 이하의 모든 소수가 있어야한다.

        // 소수는 1을 제외한 자기 자신을 약수로 가지는놈.
        if (N < 2) {
            return false;
        }

        double no1Sqrt = Math.sqrt(N); //약수의 범위를 제곱근으로 제한한다

        for (Integer primeNum : primeList) {
            if (primeNum > no1Sqrt) {   // 범위를 벗어났음. 계산종료
                break;
            }

            if (N % primeNum == 0) {
                return false;
            }
        }
        return true;
    }
}
