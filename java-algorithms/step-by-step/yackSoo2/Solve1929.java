package yackSoo2;

import java.io.*;
import java.util.*;

public class Solve1929 {
    // 문제 : 소수 구하기
    // N보다 작은 소수집합을 구하고, M보다 큰 경우에만 출력한다.
    //
    // M : 첫번쨰 입력값. M 이상 소수를 찾아야한다.
    // N : 두번째 입력값. N 이하 소수를 찾아야한다.
    //
    // 1. 2부터 최대값 N 의 범위의 소수를 구한다.
    //   -- 복잡도 : (N-2) * 루트(N)
    // 2. 소수로 판별된 숫자를 리스트에 저장한다. 2부터 N 의 제곱근 사이의 숫자를 반복체크하며 이전 리스트를 참고한다.
    // 3. 리스트에 담긴 숫자중 N보다 큰 경우에만 출력한다.
    //
    // -- 시간복잡도 : O( N * 루트(N) )
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> primeList;
        Integer no1;

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)
        ) {
            // Logic 구현부
            StringTokenizer st = new StringTokenizer(br.readLine());

            no1 = Integer.parseInt(st.nextToken());
            Integer no2 = Integer.parseInt(st.nextToken());

            primeList = getSmallerPrimeList(no2);
        }

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)) {
            for (Integer prime : primeList) {
                if (prime >= no1) {
                    bw.write(prime + "\n");
                }
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
