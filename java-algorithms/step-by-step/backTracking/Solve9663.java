package backTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Solve9663 {
    // 문제 : N-Queen

    // 해결책 : 각 Row 별로 담기는 값을 배열에 저장하고 재귀를 하며 비교한다.
    //
    // N : 체스판 길이 (체스판 크기 : N * N)
    // M : 수열 개수
    // solve : 재귀실행 함수
    // acc : 재귀할때마다 숫자가 담기는 배열
    // rowNum : 재귀 수행시 1씩 증가(체스판 한줄씩 증가)
    //
    //  1. N과 acc, rowNum으로 solve의 스펙을 정의한다.
    //   1-1. N만큼 숫자를 탐색한다.
    //   1-2. acc에 숫자가 없다면 추가한다.
    //   1-3. acc에 새로운 숫자가
    //   1-3. acc에 있는 숫자를 x값, 있는 위치를 y로 가정하고, 새로운 수와 이전수의 대각선 위치인지 판별한다.
    //   1-3. N, acc, rowNum으로 재귀한다. (이전 acc에 담긴 수 부터 N까지 탐색하며 반복한다)
    //
    //  2. rowNum이 N이되면, N번 재귀가 끝났으므로 결과를 1 증가시킨다.
    //  3. 리턴된 결과를 출력한다.
    //
    //
    // -- 시간복잡도 O(N^M)
    public static void main(String[] args) throws IOException {
        AtomicInteger result = new AtomicInteger(0);
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            // 입력 수
            Integer n = Integer.parseInt(br.readLine());
            // 재귀 수행
            solve(result, new ArrayList<>() , n, 0);
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }

    public static void solve(AtomicInteger result,
                             ArrayList<Integer> acc,
                             Integer n,
                             Integer rowNum) {

        if (n.equals(rowNum)) {
            result.incrementAndGet(); // 결과값을 1 증가
            return;
        }

        for (int i = 0; i < n; i++) {
            if (acc.contains(i)){
                continue;
            }
            if (!isSafe(acc,i)) {
                continue;
            }

            acc.add(i);
            solve(result, acc, n, rowNum + 1);
            acc.remove(acc.size() - 1); // 재귀 호출이 끝난 후, 리스트에서 마지막 추가된 요소 제거
        }
    }

    public static boolean isSafe(ArrayList<Integer> acc,
                                 Integer newX){
        for(int i = 0; i < acc.size(); i++){
            Integer absX = Math.abs(newX - acc.get(i));
            Integer absY = Math.abs(acc.size() - i);

            if(absX.equals(absY)){
                return false;
            }
        }
        return true;
    }
}