package combinatorics;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solve1010 {
    // 문제 : 다리놓기
    // 해결책 : 조합의 공식 mCn 을 이용하는데, mCn = m-1Cn-1 + m-1Cn 의 성질을 이용하자.(재귀)
    //  (N ≤ M)
    // M : 반대편다리 기점
    // N : 다리 기점
    //
    // 1. M과 N의 최대값인 30에 대하여 2차원 배열을 생성한다.
    // 2. mCn = m-1Cn-1 + m-1Cn 에 대하여 재귀함수를 수행한다.
    //  -- case 1. 2차원 배열에 값이 있는경우 -> 리턴
    //  -- case 2. M == N 또는 N이 0이면 1 리턴
    //  -- case 3. M-N == 1 또는 N이 1이면 M 리턴, 배열에 저장
    //  -- case 4. 어디에도 해당 되지 않으면 mCn = m-1Cn-1 + m-1Cn 재귀 호출, 2차원배열(M,N에) m-1Cn-1 + m-1Cn 저장.

    // -- 복잡도 (M * N) / 2
    // -- 시간복잡도 O(N^2)


    public static void main(String[] args) throws IOException {
        ArrayList<String> resultList = new ArrayList<>();
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            ArrayList<ArrayList<Integer>> sunyeolArr = new ArrayList<>();

            for (int i = 0; i < 31; i++) {
                ArrayList<Integer> innerList = new ArrayList<>(Collections.nCopies(i + 1, 0));
                sunyeolArr.add(innerList);
            }
            // 입력 수
            Integer T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Integer N = Integer.parseInt(st.nextToken());
                Integer M = Integer.parseInt(st.nextToken());

                int result = getSunyeol(M, N, sunyeolArr);
                resultList.add(String.valueOf(result));
            }

            // 결과 출력 (확인용)
//            for (ArrayList<Integer> innerList : sunyeolArr) {
//                System.out.println(innerList);
//            }
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(String.join("\n", resultList));
        }
    }

    public static int getSunyeol(Integer M, Integer N, ArrayList<ArrayList<Integer>> sunyeolArr) {

        if (sunyeolArr.get(M).get(N) > 0)  {
            return sunyeolArr.get(M).get(N);
        }
        if (sunyeolArr.get(M).get(M-N) > 0)  {
            return sunyeolArr.get(M).get(M-N);
        }

        if (N == M || N == 0) {
            return 1;
        } else if (N == 1 || M - N == 1) {
            sunyeolArr.get(M).set(N, M);
            return M;
        } else {
            sunyeolArr.get(M).set(N, getSunyeol(M - 1, N - 1, sunyeolArr) + getSunyeol(M - 1, N, sunyeolArr));
            return getSunyeol(M - 1, N - 1, sunyeolArr) + getSunyeol(M - 1, N, sunyeolArr);
        }
    }
}
