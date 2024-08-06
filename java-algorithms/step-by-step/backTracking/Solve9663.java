package backTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Solve9663 {
    // 문제 : N-Queen

    // 해결책 : 체스판 윗줄부터 퀸의 위치를 하나씩 저장한다. 그 뒤, 모든 퀸이 공격받지 않는경우를 찾아서 누적한다.
    //
    // N : 체스판 길이 (체스판 크기 : N * N)
    // solve : 재귀실행 함수
    // acc : 재귀할때마다 숫자가 담기는 배열 : 1번째 줄부터 N번째 줄까지 퀸의 위치가 저장된다.
    // e.g) [1,2,3]
    //    o x x
    //    x o x
    //    x x o
    //
    // rowNum : 재귀 수행시 1씩 증가(체스판 한줄씩 증가)
    //
    //  1. N과 acc, rowNum으로 solve의 스펙을 정의한다.
    //   1-1. N만큼 숫자를 저장하기 시작한다.
    //   1-2. acc에 숫자가 없다면 추가한다.
    //   1-3. acc에 새로운 숫자가 기존 숫자와 일치한다면, 직선 위치에 있으므로 다른 숫자를 탐색한다.
    //   e.g) [1,1] 과 같이 같은숫자일때 퀸은 공격받음.
    //    o x x
    //    o x x
    //
    //   1-4. acc에 있는 숫자를 x값, 있는 위치를 y로 가정하고, 새로운 수와 이전수의 대각선 위치인지 판별한다.
    //   e.g) (x값 : 1~N, y값 : 0 ~ N-1) -> (1,0) 과 (2,1)
    //    o x x
    //    x o x
    //    |2-1| = |1-0| -> x를 뺀 값과 y뺀 값이 같으므로, 대각선 위치로 판별.
    //
    //   1-5. N, acc, rowNum + 1 으로 재귀한다.
    //
    //  2. rowNum이 N이되면 퀸이 공격당하지 않는 배치가 N번 줄만큼 완료되었으므로, 결과를 1 증가시킨다.
    //  3. 리턴된 결과를 출력한다.
    //
    //
    // -- 시간복잡도 O(N^M)
    public static void main(String[] args) throws IOException {
        Integer result;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            // 입력 수
            Integer n = Integer.parseInt(br.readLine());
            // 재귀 수행
            result = solve(n);
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }

    public static Integer solve(Integer n){
        return solveInner(new ArrayList<>() , n, 0);
    }

    public static Integer solveInner(ArrayList<Integer> acc,
                                      Integer n,
                                      Integer rowNum) {
        Integer cnt = 0;
        if (n.equals(rowNum)) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            if (!isSafe(acc,i)) {
                continue;
            }
            acc.add(i);
            cnt += solveInner( acc, n, rowNum + 1);
            acc.remove(acc.size() - 1); // 재귀 호출이 끝난 후, 리스트에서 마지막 추가된 요소 제거
        }
        return cnt;
    }

    public static boolean isSafe(ArrayList<Integer> env,
                                 Integer newX){
        if (env.contains(newX)){
            return false;
        }

        for(int i = 0; i < env.size(); i++){
            Integer absX = Math.abs(newX - env.get(i));
            Integer absY = Math.abs(env.size() - i);

            if(absX.equals(absY)){
                return false;
            }
        }
        return true;
    }
}
