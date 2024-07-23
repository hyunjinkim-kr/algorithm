package recursion;

import java.io.*;

public class Solve27433 {
    // 문제 : 팩토리얼 2

    // 해결책 : 입력받은 숫자를 곱해가며 재귀를 반복한다.
    //
    // N : 입력받은 숫자
    // result : 재귀가 실행될때 리턴되는 값
    //
    // 1. N을 입력받는다.
    //
    // 2. N을 1씩 차감해가며 결과값을 리턴하는 재귀함수를 N번 수행한다.
    //      복잡도 N
    //
    // -- 시간복잡도 O(N)
    public static void main (String[] args) throws IOException {
        Long result;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            Long N = Long.parseLong(br.readLine());
            result = factorial(N);
//            result = getFactorial2((long)N);
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }

    public static Long factorial(Long N){
        return factorial_helper(N, (long)1);
    }

    private static Long factorial_helper(Long N, Long acc){
        if (N < 1) {
            return acc;
        }
        return factorial_helper(N-1, acc * N);
    }

    public static Long factorial2(Long N){
        if(N < 1){
            return (long)1;
        }
        return N * factorial2(N-1);
    }
}
