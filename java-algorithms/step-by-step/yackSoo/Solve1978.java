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
        // 해결책 : 입력받은 숫자가 1이 아니고, 약수가 2개인 경우를 판별한다.
        //
        // no1 : 입력받은 숫자
        //
        // 1. 입력받은 숫자가 1인지 판별한다.
        // 2. 1이 아니면, 제곱근만큼 수행하여 제곱근 이하의 약수의 갯수를 확인한다.
        // 3. 소수는 1과 자기 자신만 짝이되어야 하는데, 제곱근 이하의 약수가 1개를 넘으면 소수가 될 수 없다.
        // -- 복잡도 : 루트no1
        // -- 시간복잡도 : O(루트no1)
        Scanner scan = new Scanner(System.in);
        Integer numCount = scan.nextInt(); // 체크할 숫자 개수
        Integer count = 0;

        for (int i = 0; i < numCount; i++) {
            Integer no1 = scan.nextInt();
            if (isDecimal(no1)) {
                count++;
            }
        }
        System.out.print(count);
    }

    public static boolean isDecimal(Integer no1) {
        // 소수는 1을 제외한 자기 자신을 약수로 가지는놈.
        if (no1 == 1) {
            return false;
        }

        double no1Sqrt = Math.sqrt(no1); //약수의 범위를 제곱근으로 제한한다
        Integer count = 0;

        for (int i = 1; i <= no1Sqrt; i++) {
            //약수가 아니면 continue;
            if (no1 % i != 0) {
                continue;
            }
            count++;
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
