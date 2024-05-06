package stackQueueDeque;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solve11866 {
    // 문제 : 요세푸스 문제 0
    //
    // 해결책 : N명이 있는 arr1 대하여 K의 요세푸스는 수행할떄마다 K만큼 증가한 위치를 정의한다.
    //
    // N : 사람의 명수, 1~N 번 사람이 순서대로 앉는다.
    // K : 제거 되는 사람의 위치를 정하는 값
    // arr1 : N명의 사람이 K 번쨰마다 수정될 배열
    //
    //
    //  1. N명 사람을 입력받고, arr1에 저장한다.
    //  -- 복잡도 : N
    //  2. 배열 arr1의 길이가 0이 될때까지 다음 행위를 반복한 후 마지막 값을 출력한다.
    //     a) K번째 위치를 버린다. (K는 정확히 K-1 인덱스를 지칭한다.)
    //     b) 그 다음 K번쨰 위치를 버린다. K를 두배 증가시킨 위치이다.
    //     ** 단, 사람들은 원형으로 둘러싸여있으므로
    //     ** arr1의 크기가 K보다 작으면 arr1.size() % K 위치의 값을 가져온다.
    //  -- 복잡도 : (N^2 + N) / 2
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

            LinkedList<Integer> arr1 = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                arr1.add(i);
            }

            Integer cnt = K - 1;
            while (!arr1.isEmpty()) {
                if (arr1.size() <= cnt) {
                    cnt = cnt % arr1.size();
                }
                sb.append(arr1.get(cnt));
                sb.append(", ");

                arr1.remove(arr1.get(cnt));
                cnt += K - 1;
            }
            sb.setLength(sb.length() - 2);
            sb.append(">");
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(String.valueOf(sb));
        }
    }
}
