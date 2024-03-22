package yackSoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solve1978 {
    public static void main(String[] args) throws IOException {
        // 문제 : 소수찾기
        // 해결책 : 소수리스트를 구하고, 입력받은 숫자를 소수 리스트 이내에서 찾는다.
        //
        // M : 체크할 숫자의 개수
        // N : 2 ~ 최대값의 제곱근 사이의 정수
        // N" : 체크할 숫자
        // arr1 : 소수가저장되는 리스트
        //
        // 1. 2부터 최대값 1000의 제곱근 범위의 소수를 구한다.
        //  -- 복잡도 : 루트 1000 - 2
        // 2. 소수로 판별된 숫자를 리스트에 저장한다. 2부터 루트 1000 사이의 숫자 N을 반복체크하며 이전 리스트를 참고한다.
        //  -- 복잡도 : 루트 N
        // 3. M개만큼 입력받은 숫자 N"를 소수 리스트 범위내에서 탐색한다.
        //  -- 입력받은 숫자의 제곱근 만큼만 탐색하면 된다. 즉, 소수리스트를 탐색하다가 소수가 제곱근보다 커지면 멈춘다.
        //  -- 복잡도 : 루트 N"
        //
        // -- 시간복잡도 : O( (루트1000 - 2)*루트N + M * 루트N" )
        Scanner scan = new Scanner(System.in);
        Integer numCount = scan.nextInt(); // 체크할 숫자 개수
        Integer count = 0;

        Integer maxInput = (int)Math.sqrt(1000);
        ArrayList<Integer> primeList = new ArrayList<>();
        primeList = getPrimeList(maxInput);

        for (int i = 0; i < numCount; i++) {
            Integer N = scan.nextInt();
            if (isPrime(N,primeList)) {
                count++;
            }
        }
        System.out.print(count);
    }

    // Input 이내의 소수 리스트를 반환한다.
    public static ArrayList<Integer> getPrimeList(Integer maxInput) {
        ArrayList<Integer> primeList = new ArrayList<>();

        // 33.xx 아래의 소수를 찾아서 리스트에 넣는게 목표..
        for (int i = 2; i <= maxInput; i++) {
            boolean isAddList = isPrime(i,primeList);
            if (isAddList) {
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
        if (N == 1) {
            return false;
        }

        double no1Sqrt = Math.sqrt(N); //약수의 범위를 제곱근으로 제한한다

        for (int i = 0; i < primeList.size(); i++) {
            Integer primeNum = primeList.get(i);

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
