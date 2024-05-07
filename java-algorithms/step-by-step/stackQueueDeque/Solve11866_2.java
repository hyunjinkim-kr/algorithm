package stackQueueDeque;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solve11866_2 {
    // 문제 : 요세푸스 문제 0
    //
    // 해결책 : 덱으로 풀어보자.
    //
    // N : 사람의 명수, 1~N 번 사람이 순서대로 앉는다.
    // K : 제거 되는 사람의 위치를 정하는 값
    // D : N명의 사람이 K 번쨰마다 수정될 덱
    //
    //  1. N명 사람을 입력받고, 덱 D 에 저장한다.
    //  -- 복잡도 : N
    //  2. 덱 D 의 길이가 0이 될때까지 다음 행위를 반복한 후 마지막 값을 출력한다.
    //     a) K 위치 이전의 값들은 모두 뒤로 보낸다.
    //     b) K 위치값을 지운다. 그리고 정답 리스트에 추가한다.
    //  -- 복잡도 : 2 * K * N
    //
    // 복잡도 : N^2
    // 시간복잡도 : O(N^2)
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

            getTrdNum(dequeArr, K, resultArr);
            sb.append(String.join(", ", resultArr));
            sb.append(">");
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(String.valueOf(sb));
        }
    }

    public static void getTrdNum(Deque<Integer> dequeArr, Integer K, ArrayList<String> resultArr) {
        while (!dequeArr.isEmpty()) {
            for (int i = 1; i <= K; i++) {
                Integer num = dequeArr.peek();
                dequeArr.removeFirst();
                if (i == K) {
                    resultArr.add(num.toString());
                } else {
                    dequeArr.addLast(num);
                }
            }
        }
    }
}
