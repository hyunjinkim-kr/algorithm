package yackSoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solve11653 {
    public static void main(String[] args) throws IOException {
        // 문제 : 소인수분해
        //
        // N : 입력받은 수
        // M : 나눌 수
        // R : N을 M으로 나눈 수
        //
        // 해결책 : 입력받은 수 N을 M으로 나뉠 때까지 반복하며 나눈다.
        // 1. N을 입력받고 R의 초기값으로 설정한다. 나눌 M은 2로 설정한다. (가장 작은 소수)
        // 2. R을 M으로 나누기 시작한다.
        //  - 나누어지는 경우 : M을 출력하고, R은 나뉜 값으로 초기화한다.
        //  - 나누어지지 않는 경우 : M을 1 증가시킨다.
        // 3. 위 과정을 N과 M이 같을 때까지 반복한다.
        //  - 복잡도 : N
        //
        //  - 시간복잡도 : O(N)
        
        Scanner scan = new Scanner(System.in);
        Integer N = scan.nextInt();

        // 기존로직 사용 X
        // 제곱근 이하의 소수를 구하면 되므로, 최대 범위의 제곱근으로 변경한다.
        //Integer sqrtedN = (int) Math.sqrt(N);
        //ArrayList<Integer> primeList = getSmallerPrimeList(sqrtedN);
        showAnswer(N);
    }

    public static void showAnswer(Integer n){
        Integer i = 2;
        while (i <= n){
            if(n % i == 0){
                n /= i;
                System.out.println(i);
            } else {
                i++;
            }
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
