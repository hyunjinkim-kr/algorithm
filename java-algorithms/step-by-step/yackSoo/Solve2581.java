package yackSoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solve2581 {
    public static void main(String[] args) throws IOException {
        // 문제 : 소수
        // 해결책 : M이상 N 이하의 소수들의 합과, 소수의 최소값을 리턴한다.
        // M : 소수 탐색 시작값
        // N : " 끝값
        // arr1 : N 이하의 소수 집합
        // I : M이상 N 이하의 소수
        //
        // 1. 최대값 N의 제곱근 범위의 소수를 구한다.
        //  -- 복잡도 : 루트 N
        // 2. 소수로 판별된 숫자를 리스트 arr1에 저장한다. 0부터 루트 N 사이의 숫자를 반복체크하며 이전 리스트를 참고한다.
        //  -- 복잡도 : 루트 N
        // 3. M, N의 범위에서 arr1로 소수를 탐색한다.
        //  -- 복잡도 : 루트 N
        // 4. 첫번째 I값과 I의 합을 리턴한다.
        //
        // -- 시간복잡도 : O( 루트 N )
        
        Scanner scan = new Scanner(System.in);
        Integer M = scan.nextInt(); // 범위 시작
        Integer N = scan.nextInt(); // 범위 끝

        // 제곱근 이하의 소수를 구하면 되므로, 최대 범위의 제곱근으로 변경한다.
        Integer maxInput = (int) Math.sqrt(N);
        ArrayList<Integer> primeList = getSmallerPrimeList(maxInput);
        showAnswer(primeList, M,N);
    }

    public static void showAnswer(ArrayList<Integer> primeList,Integer StartM, Integer endN){
        Integer fstPrimeBtwMN = -1;
        Integer primeSumBtwMn = 0;

        for (int i = StartM; i <= endN; i++) {
            if (isPrime(i,primeList)) {
                primeSumBtwMn += i;
                if (fstPrimeBtwMN < 0) {
                    fstPrimeBtwMN = i;
                }
            }
        }

        if(fstPrimeBtwMN < 0){
            System.out.print(fstPrimeBtwMN);
        } else {
            System.out.println(primeSumBtwMn);
            System.out.print(fstPrimeBtwMN);
        }
    }

    // upperBound 이하의 소수 리스트를 반환한다.
    public static ArrayList<Integer> getSmallerPrimeList(Integer upperBound) {
        ArrayList<Integer> primeList = new ArrayList<>();

        // M 이하의 소수를 모두 구해놓는다.
        for (int i = 0; i <= upperBound; i++) {
            if (isPrime(i, primeList)) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    public static boolean isPrime(Integer N, ArrayList<Integer> primeList) {
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
