package yackSoo2;

import java.io.*;

public class Solve13909 {
    // 문제 : 창문 닫기
    // 창문을 여닫는데, 해당하는 수의 배수에 대해서 닫거나 여는 행동을 하는것이다.
    // 해결책 : 입력된 숫자에 따른 창문이 여닫히는 패턴을 파악한다.
    //  접근1. 해당하는 창문 번호에 대하여 약수의 개수가 홀수일때 창문은 열린 상태가 된다.
    //  접근2. 약수의 개수가 홀수인 경우는, 제곱근 밖에 없다.
    //  접근3. 특정 범위 내의 제곱근의 개수는, 범위의 제곱근과 같다.
    //
    // N : 입력받은 수
    //
    // 1. 입력받은 수 N을 제곱근하여 출력한다.
    // 시간복잡도 : O(1)
    public static void main(String[] args) throws IOException {
        Integer no1Sqrt;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)
        ) {
            Integer maxSize = Integer.parseInt(br.readLine());
            no1Sqrt = (int) Math.sqrt(maxSize);
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(no1Sqrt + "");
        }
    }
}
