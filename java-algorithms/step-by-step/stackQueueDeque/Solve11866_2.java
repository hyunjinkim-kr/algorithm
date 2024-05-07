package stackQueueDeque;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solve11866_2 {
    // 문제 : 요세푸스 문제 0
    //
    // 해결책 : 덱으로 풀어보자.
    //
    // N : 입력되는 명령의 개수
    // M : 입력되는 명령에 따라 수정되는 리스트
    // R : 삭제되는 순서에따라 저장되는 리스트 (정답리스트)
    //
    //  1. N개 숫자를 입력받는다.
    //  2. N 개의 명령어에 따라 배열을 수정하거나 상태를 받는다.
    //  -- 복잡도 : 2*N
    //
    // 복잡도 : N
    // 시간복잡도 : O(N)
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder("<");
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer N = Integer.parseInt(st.nextToken());
            Integer K = Integer.parseInt(st.nextToken());

            Deque<Integer> dequeArr = new ArrayDeque<>();
            ArrayList<String> resultArr = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                dequeArr.add(i);
            }

            Integer cnt = 1;
            while (!dequeArr.isEmpty()) {
                Integer num = getTrdNum(dequeArr, K, cnt);
                if (num.equals(0)) {
                    cnt++;
                } else {
                    cnt = 1;
                    resultArr.add(String.valueOf(num));
                }
            }
            sb.append(String.join(", ", resultArr));
            sb.append(">");
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(String.valueOf(sb));
        }
    }

    public static Integer getTrdNum(Deque<Integer> dequeArr, Integer K, Integer cnt) {
        Integer num = dequeArr.peek();
        if (cnt.equals(K)) {
            dequeArr.removeFirst();
            return num;
        } else {
            dequeArr.removeFirst();
            dequeArr.addLast(num);
        }
        return 0;
    }
}
