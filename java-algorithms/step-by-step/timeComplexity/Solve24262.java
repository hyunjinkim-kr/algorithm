package timeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solve24262 {
    public static void main(String[] args) throws IOException {
        // 문제 : 알고리즘 수업 - 알고리즘의 수행 시간 1
        //
        // 해결책 : 함수 호출횟수와 수행횟수를 출력한다.
        //
        // 1. menOfPassion 이라는 함수가 수행된다고 가정한다.
        // 2. for문이 수행될때 최고차항은 1이다.
        // 3. for문이 수행된 횟수를 출력하고, 최고차항을 출력한다.

        Scanner scan = new Scanner(System.in);
        Integer inputN = scan.nextInt();
        Integer result = 0;
        result += menOfPassion(inputN);

        // 최고차항 출력
        System.out.println(result);
    }

    public static Integer menOfPassion(Integer inputN) {
        // 수행횟수
        Integer sum = 0;
        // 최고차항
        Integer count = 0;

        sum += 1;
        System.out.println(sum);

        return count;
    }
}

