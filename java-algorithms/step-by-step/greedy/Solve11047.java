package greedy;

import java.io.*;
import java.util.*;

public class Solve11047 {
    // 문제 : 동전 0

    // 해결책 : 총 금액에서 가장큰 동전만큼 빼고, 금액보다 동전이 큰 경우 작은동전으로 반복한다.
    //
    // N : 동전의 종류 개수
    // K : 금액
    // moneyArr : 동전 종류가 저장되는 배열
    // cnt : K에서 동전금액만큼 뺀 횟수
    //
    // 1. N과 K을 입력받는다.
    //
    // 2. N번 입력받은 동전종류를 moneyArr 에 저장한다.
    //    복잡도 N
    //
    // 3. 금액K에서, 가장 큰 단위의 금액부터 빼며 0이 될때까지 반복한 후 횟수를 리턴한다.
    //  - 3-1. moneyArr의 마지막 값 (가장 큰 동전)을 가져온다.
    //  - 3-2. K를 동전으로 나눈 값을 cnt에 저장한다.
    //  - 3-3. K % 동전 (나머지) 값을 K로 설정한다.
    //  - 3-4. K가 0이 될때까지 반복한다.
    //
    // 4. cnt를 출력한다.
    //
    // -- 시간복잡도 O(N)
    public static void main(String[] args) throws IOException {
        Integer result;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer n = Integer.parseInt(st.nextToken());
            Integer k = Integer.parseInt(st.nextToken());
            ArrayList<Integer> moneyArr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                Integer money = Integer.parseInt(st2.nextToken());
                moneyArr.add(money);
            }
            result = solve(moneyArr, k);
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }

    public static Integer solve(ArrayList<Integer> moneyArr, Integer k) {
        Integer idx = moneyArr.size() - 1;
        Integer cnt = 0;
        while (!k.equals(0)) {
            cnt += k / moneyArr.get(idx);
            k = k % moneyArr.get(idx);
            idx--;
        }
        return cnt;
    }
}
