package DP;

import java.io.*;
import java.util.ArrayList;

public class Solve24416 {
    // 문제 : 알고리즘 수업 - 피보나치 수 1

    // 해결책 : 재귀 횟수와 동적계획 횟수를 각각 출력한다.
    //
    // n : 찾을 피보나치 n번째 수
    // resultRc : 재귀실행시 수행 횟수
    // resultDp : 동적계획시 수행 횟수
    //
    //  1. n을 입력받은 재귀함수를 수행한다.
    //   1-1. n이 2보다 작거나 같으면 1을 리턴한다.
    //   1-2. n이 2보다 크면, n-1과 n-2로 재귀한 값을 cnt로 리턴한다.
    //   -- 복잡도 O(2^N)
    //
    //  2. n을 입력받은 동적계획 함수를 실행한다.
    //   2-1. n이 2이상인 경우, n-2 번 cnt를 더하고 리턴한다.
    //   -- 복잡도 O(N)
    //
    //
    // -- 시간복잡도 O(2^N)
public static void main(String[] args) throws IOException {
    Integer resultRc;
    Integer resultDp;
    try (InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader br = new BufferedReader(isr)) {
        Integer n = Integer.parseInt(br.readLine());

        resultRc = fibo(n);
        resultDp = fiboDp(n);
    }
    try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
        bw.write(resultRc + " " + resultDp);
    }
}

    public static Integer fibo(Integer n) {
        if(n <= 2){
            return 1;
        }
        Integer cnt = fibo(n - 1) + fibo(n - 2);
        return cnt;
    }

    public static Integer fiboDp(Integer n) {
        Integer cnt = 0;
        for(int i = 2; i < n; i++){
            cnt++;
        }
        return cnt;
    }
}
