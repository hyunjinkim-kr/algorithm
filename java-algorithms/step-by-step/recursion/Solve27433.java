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
            Integer N = Integer.parseInt(br.readLine());
            result = getFactorial(N,(long)1);
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }

    public static Long getFactorial(Integer N, Long result){
        if(N > 1){
            return getFactorial(N-1, result * N);
        }
        return result;
    }
}
