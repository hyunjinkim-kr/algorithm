package backTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solve15649 {
    // 문제 : N과 M (1)

    // 해결책 : 숫자 N만큼 for문을 M만큼 재귀한다.
    //
    // N : 숫자 범위
    // M : 수열 개수
    // solve : 재귀실행 함수
    // acc : 재귀할때마다 숫자가 담기는 배열
    // resultArr : acc가 담기는 배열
    //
    //  1. N과 M으로 solve의 스펙을 정의한다.
    //   1-1. N만큼 숫자를 탐색한다.
    //   1-2. acc에 숫자가 없다면 추가한다.
    //   1-3. N, acc, M - 1 으로 재귀한다.
    //
    //  2. M이 0이되면, M번 재귀가 끝났으므로 acc배열을 resultArr에 저장한다.
    //  3. 리턴된 resultArr을 출력한다.
    //
    //
    // -- 시간복잡도 O(N^M)
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> resultArr;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            // 입력 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer n = Integer.parseInt(st.nextToken());
            Integer m = Integer.parseInt(st.nextToken());

            resultArr = solve(n, m, new ArrayList<>());
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {

            for (ArrayList<Integer> obj : resultArr) {
                // 모든 요소를 공백으로 구분하여 출력
                String result = obj.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "));
                bw.write(result + "\n");
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> solve(Integer n, Integer m, ArrayList<Integer> acc) {
        ArrayList<ArrayList<Integer>> resultArr = new ArrayList<>();

        if (m.equals(0)) {
            resultArr.add(new ArrayList<>(acc));
            return resultArr;
        }
        for (int i = 1; i <= n; i++) {
            if(acc.contains(i)){
                continue;
            }
            acc.add(i);
            resultArr.addAll(solve(n, m-1, acc));
            acc.remove(acc.size() - 1); // 재귀 호출이 끝난 후, 리스트에서 마지막 추가된 요소 제거
        }
        return resultArr;
    }
}




//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j <= n; j++) {
//                    if (i == j) {
//                       continue;
//                    }
//                    resultArr.add(new StringBuilder(i + " " + j));
//                }
//            }

//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j <= n; j++) {
//                    if(i == j ){
//                        continue;
//                    }
//                    for (int k = 1; k <= n; k++) {
//                        if (i==k || j==k) {
//                            continue;
//                        }
//                        for(int l = 1; l <= n; l++){
//                            if (i==l || j==l || k==l) {
//                                continue;
//                            }
//                            resultArr.add(new StringBuilder(i + " " + j + " " + k + " " + l));
//                        }
//
//                    }
//                }
//            }