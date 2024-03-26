package timeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solve24264 {
    public static void main(String[] args) throws IOException {
        // 문제 : 알고리즘 수업 - 알고리즘의 수행 시간 3
        //
        // 해결책 : 함수 호출횟수와 수행횟수를 출력한다.
        //
        // 1. menOfPassion 이라는 함수가 수행된다고 가정한다.
        // 2. for문이 수행될때 최고차항은 1 증가한다.
        // 3. for문이 수행된 횟수를 출력하고, 최고차항을 출력한다.
        // 시간복잡도 : O(N^2)

//        MenOfPassion(A[], n) {
//            sum <- 0;
//            for i <- 1 to n
//            for j <- 1 to n
//            sum <- sum + A[i] × A[j]; # 코드1
//            return sum;
//        }

        Scanner scan = new Scanner(System.in);
        long inputN = scan.nextInt();

        System.out.println(inputN * inputN);
        // 수행횟수
        System.out.print(2);
    }
}