package stackQueueDeque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solve24511 {
    // 문제 : queuestack
    //
    // 해결책 : queue에 해당하는 자료구조만 추가하고 입력된값은 끝에 추가하고 맨 앞의 값만 return 받는다.
    //
    // N : 자료구조의 개수
    // M : 입력받는 숫자의 개수

    // A : 자료구조의 형태 수열
    // B : 자료구조의 초기 원소 수열
    // C : 입력되는 수열
    // Deque1 : 초기원소가 저장되는 deque배열
    // Arr1 : 최종결과 저장 Arr
    //
    //  1. N개 숫자를 입력받는다.
    //  2. N 개만큼 자료구조의 형태 A(i)와 초기원소 B(i)를 입력받는다.
    //   ** 자료구조 형태 A(i)이 0인 경우에만 초기원소 B(i)를 저장한다.
    //  -- 복잡도 : N
    //  3. M번 수 C(i)를 입력받으며 Deque1의 마지막에 저장한다. 첫번째 값은 제거 후 Arr1에 저장한다.
    //  4. Arr1 을 출력한다.
    //
    // 복잡도 : N + M

    // 시간복잡도 : O(N + M)
    public static void main(String[] args) throws IOException {
        ArrayList<String> resultArr = new ArrayList<>();
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            Deque<Integer> queueStackArr = new ArrayDeque<>();
            // 입력받은 자료구조 개수
            Integer N = Integer.parseInt(br.readLine());
            // 입력받은 자료구조의 형태
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 입력받은 자료구조 초기 원소
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                Integer isStack = Integer.parseInt(st.nextToken());
                Integer num = Integer.parseInt(st2.nextToken());
                // 어차피 스택이면 직전 삽입된 값이 바로 나오므로 추가 할 필요 없음.
                if (isStack == 0) {
                    queueStackArr.addLast(num);
                }
            }

            // 입력받은 숫자 개수
            Integer M = Integer.parseInt(br.readLine());
            StringTokenizer st3 = new StringTokenizer(br.readLine());

            for (int i = 1; i <= M; i++) {
                Integer num = Integer.parseInt(st3.nextToken());
                resultArr.add(getResultNum(queueStackArr, num));
            }
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(String.join(" ", resultArr));
        }
    }

    public static String getResultNum(Deque<Integer> queueStackArr, Integer inputNum) {
        queueStackArr.addFirst(inputNum);
        return queueStackArr.pollLast().toString();
    }
}