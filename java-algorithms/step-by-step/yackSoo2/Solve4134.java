package yackSoo2;

import java.io.*;
import java.util.ArrayList;

public class Solve4134 {
    // 문제 : 다음 소수
    // 해결책 : 소수로 판별날때까지 입력된 숫자에 1을 더하면서 체크한다.
    //
    // M : 테스트케이스 개수
    // N : 입력받은 숫자
    //
    // 1. 2부터 최대값 4 * 10^9 의 제곱근(63245.5) 범위의 소수를 구한다.
    //   -- 복잡도 : 루트(4 * 10^9) - 2
    // 2. 소수로 판별된 숫자를 리스트에 저장한다. 2부터 4 * 10^9 의 제곱근(63245.5) 사이의 숫자를 반복체크하며 이전 리스트를 참고한다.
    // 3. 숫자 N를 소수 리스트 범위내에서 탐색한다.
    //  -- 입력받은 숫자의 제곱근 만큼만 탐색하면 된다. 즉, 소수리스트를 탐색하다가 소수가 제곱근보다 커지면 멈춘다.
    //  -- 복잡도 : 루트 N
    //
    // -- 시간복잡도 : O( M * 루트N )

    public static void main(String[] args) throws IOException {
        // 제곱근 이하의 소수를 구하면 되므로, 최대 범위의 제곱근으로 변경한다.
        Integer maxInput = 63245; // 4 * 10^9 의 제곱근은 63245.5
        ArrayList<Integer> primeList = getSmallerPrimeList(maxInput);

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)
        ) {
            // Logic 구현부
            Integer numCnt = Integer.parseInt(br.readLine());

            for (int i = 0; i < numCnt; i++) {
                long num = Long.parseLong(br.readLine());
                long result = getPrime(num, primeList);
                bw.write(result + "\n");
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

    public static long getPrime(long num, ArrayList<Integer> primeList) {
        // 올바르게 동작하기 위한 primeList의 조건.
        // 1.primeList는 정렬되어야 한다.
        // 2.제곱근 N 이하의 모든 소수가 있어야한다.

        // 소수는 1을 제외한 자기 자신을 약수로 가지는놈.
        while (!isPrime(num, primeList)) {
            num++;
        }
        return num;
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
