package backTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solve15652 {
    // 문제 : N과 M (4)

    // 해결책 : 조합을 구하되, 같은수를 포함한다.
    //
    // N : 숫자 범위
    // M : 수열 개수
    // solve : 재귀실행 함수
    // acc : 재귀할때마다 숫자가 담기는 배열
    // resultArr : acc가 담기는 배열
    // start : 재귀할때 시작범위. 이전에 담긴 숫자만큼 늘어난다.
    //
    //  1. N과 M으로 solve의 스펙을 정의한다.
    //   1-1. N만큼 숫자를 탐색한다.
    //   1-2. acc에 숫자가 없다면 추가한다.
    //   1-3. N, acc, M - 1, acc에 담긴 수로 재귀한다. (이전 acc에 담긴 수 부터 N까지 탐색하며 반복한다)
    //
    //  2. M이 0이되면, M번 재귀가 끝났으므로 acc배열을 resultArr에 저장한다.
    //  3. 리턴된 resultArr을 출력한다.
    //
    //
    // -- 시간복잡도 O(N^M)
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> mutableArr = new ArrayList<>();
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            // 입력 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer n = Integer.parseInt(st.nextToken());
            Integer m = Integer.parseInt(st.nextToken());
            // 재귀 수행
            solve(mutableArr, new ArrayList<>(), n, m, 1);
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            for (ArrayList<Integer> obj : mutableArr) {
                // 모든 요소를 공백으로 구분하여 출력
                String result = obj.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "));
                bw.write(result + "\n");
            }
        }
    }

    public static void solve(ArrayList<ArrayList<Integer>> resultArr,
                             ArrayList<Integer> acc,
                             Integer n,
                             Integer m,
                             Integer start) {

        if (m.equals(0)) {
            resultArr.add(new ArrayList<>(acc));
            return;
        }
        for (int i = start; i <= n; i++) {
            acc.add(i);
            solve(resultArr, acc, n, m - 1, i);
            acc.remove(acc.size() - 1); // 재귀 호출이 끝난 후, 리스트에서 마지막 추가된 요소 제거
        }
    }
}
