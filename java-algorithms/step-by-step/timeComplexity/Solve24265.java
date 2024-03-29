package timeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solve24265 {
    public static void main(String[] args) throws IOException {
        // 문제 : 알고리즘 수업 - 알고리즘의 수행 시간 4
        //
        // 해결책 : 함수 호출횟수와 수행횟수를 출력한다.
        //
        // 1. menOfPassion 이라는 함수가 수행된다고 가정한다.
        // 2. for문이 수행될때 최고차항은 1 증가한다.
        // 3. for문이 수행된 횟수를 출력하고, 최고차항을 출력한다.
        // 시간복잡도 : O(N^2)

        //        for i <- 1 to n - 1
        //        for j <- i + 1 to n
        //        sum <- sum + A[i] × A[j]; # 코드1
        //        return sum;

        Scanner scan = new Scanner(System.in);
        long inputN = scan.nextInt();

        MenOfPassion(inputN);

        // 최고차항
        System.out.print(2);
    }

    public static void MenOfPassion(long N) {

//        long sum = 0;
//
//        for (int i = 0; i < N - 1; i++) {
//            for (int j = 0; j < i + 1; j++) {
//                sum++;
//            }
//        }
//        System.out.println(sum);
        // N-1 에 대해 합을 구한다.
        System.out.println(N*(N-1)/2);
    }
}