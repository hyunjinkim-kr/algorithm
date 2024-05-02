package stackQueueDeque;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solve28278 {
    // 문제 : 스택2
    //
    // 해결책 : 명령에따라 stack 배열에 값을 수정하고, Result 배열에 결과를 넣은후 출력한다.
    // N : 실행되는 명령의 수
    //
    //  1. 입력받은 명령 개수 N만큼 반복문을 수행한다.
    //  2. 명령을 확인하고 해당하는 수행을 한 후 stack 배열과 Result 배열에 값을 넣는다.
    //  3. Result 배열을 출력한다.
    //
    // 시간복잡도 : O(N)
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> stackArr = new ArrayList<>();
        ArrayList<Integer> resultArr = new ArrayList<>();

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)
        ) {
            Integer cnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < cnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Integer checkNum = Integer.parseInt(st.nextToken());

                switch (checkNum) {
                    case 1:
                        Integer pushNum = Integer.parseInt(st.nextToken());
                        stackArr.add(pushNum);
                        break;
                    case 2:
                        if (stackArr.isEmpty()) {
                            resultArr.add(-1);
                        } else {
                            int popIdx = stackArr.size() - 1;
                            Integer popNum = stackArr.get(popIdx);
                            resultArr.add(popNum);
                            stackArr.remove(popIdx);
                        }
                        break;
                    case 3:
                        resultArr.add(stackArr.size());
                        break;
                    case 4:
                        if (stackArr.isEmpty()) {
                            resultArr.add(1);
                        } else {
                            resultArr.add(0);
                        }
                        break;
                    case 5:
                        if (stackArr.isEmpty()) {
                            resultArr.add(-1);
                        } else {
                            Integer popIdx = stackArr.size() - 1;
                            Integer popNum = stackArr.get(popIdx);
                            resultArr.add(popNum);
                        }
                        break;
                    default:
                        throw new RuntimeException("해당 타입 없음.");
                }
            }
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)) {
            for (Integer val : resultArr) {
                bw.write(val + "\n");
            }
        }
    }
}
