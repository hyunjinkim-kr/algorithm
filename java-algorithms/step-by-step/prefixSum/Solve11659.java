package prefixSum;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solve11659 {
    // 문제 : 구간 합 구하기 4

    // 해결책 : 수가 주어질때 합을 저장한다. 필요한 구간에 따라 저장된 합을 사용한다.
    //
    // n : 주어지는 숫자의 갯수
    // m : 구간합을 계산하는 횟수
    // numArr : 재귀실행시 수행 횟수
    // prefixArr : 동적계획시 수행 횟수
    // start : 시작구간
    // end : 종료구간
    //
    //  1. n만큼 수를 numArr에 저장하고, prefixArr에 합을 저장한다.
    //   1-1. prefixArr 의 i 번째 수는, i-1 의 값과 i번째 주어진 수를 더한다.
    //
    //  2. 구간에 따라 합을 빼고 출력한다.
    //   2-1. end 구간의 합과에 start - 1 구간의 합을 뺀다.
    //    e.g) 5 4 3 2 1 에 대하여 1,3일때
    //     5 4 3(end : 3) - 0 (start -1) -> 12
    //
    //
    // -- 시간복잡도 O(N)
    public static void main(String[] args) throws IOException {
        ArrayList<String> resultArr = new ArrayList<>();
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer n = Integer.parseInt(st.nextToken());
            Integer m = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            ArrayList<Integer> numArr = new ArrayList<>();
            ArrayList<Integer> prefixArr = new ArrayList<>();
            numArr.add(0);
            prefixArr.add(0);

            for (int i = 1; i <= n; i++) {
                numArr.add(Integer.parseInt(st2.nextToken()));
                prefixArr.add(prefixArr.get(i - 1) + numArr.get(i));
            }

            for (int i = 0; i < m; i++) {
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                Integer start = Integer.parseInt(st3.nextToken());
                Integer end = Integer.parseInt(st3.nextToken());
                Integer result = prefixArr.get(end) - prefixArr.get(start - 1);
                resultArr.add(String.valueOf(result));
            }
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(String.join("\n", resultArr));
        }
    }
}
