package yackSoo2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Solve17103 {
    // 문제 : 골드바흐 파티션
    // 해결책 : 주어진 수가 소수 두개의 합이되는 경우를 찾는다.
    //
    // T : 입력되는 테스트 케이스의 개수.
    // N : 입력값. 소수 두개를 합쳐서 이루게 될 수.
    // p : 소수 리스트의 원소
    //
    // 1. 최대값 100만 까지의 소수 전체를 구해서 Set에 정렬하여 넣는다.
    //   -- 복잡도 : 100만 * 루트(100만)
    // 2. 소수로 판별된 숫자를 리스트에 저장한다. 2부터 M 의 제곱근 사이의 숫자를 반복체크하며 이전 리스트를 참고한다.
    // 3. 소수 리스트를 순회하며 소수 p 와 N - p 가 모두 리스트에 있을때 cnt를 출력.(단, p < N - p)
    //
    // -- 시간복잡도 : O( N * 루트(N) )
    public static void main(String[] args) throws IOException {
        final Integer maxNum = 1000000;

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)
        ) {
            Integer cnt = Integer.parseInt(br.readLine());
            TreeSet<Integer> primeList = getSmallerPrimeList(maxNum);

            for (int i = 0; i < cnt; i++) {
                Integer t1 = Integer.parseInt(br.readLine());
                Integer gbPdCnt = 0;

                for (Integer prime : primeList) {
                    Integer t2 = t1 - prime;
                    if (prime > t2) {
                        break;
                    }
                    if (primeList.contains(t2)) {
                        gbPdCnt++;
                    }
                }
                bw.write(gbPdCnt + "\n");
            }
        }
    }

    public static TreeSet<Integer> getSmallerPrimeList(Integer upperBound) {
        TreeSet<Integer> primeList = new TreeSet<>(Comparator.naturalOrder());

        for (int i = 2; i <= upperBound; i++) {
            if (isPrime(i, primeList)) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    public static boolean isPrime(long N, TreeSet<Integer> primeList) {
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
