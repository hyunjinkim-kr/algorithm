package stackQueueDeque;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solve10773 {
    // 문제 : 제로
    //
    // 해결책 : 0들어오면 마지막 숫자를 뺀다. 그 이외에는 숫자를 더한다.
    // N : 실행되는 명령의 수
    //
    //  1. 입력받은 명령 개수 N만큼 반복문을 수행한다.
    //  2. 숫자가 입력되면 stack 배열에 넣는다. 0이 되면 마지막 인덱스의 배열값을 제거한다.
    //  3. stack 배열에 있는 숫자의 합을 출력한다.
    //
    // 시간복잡도 : O(N)
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> stackArr = new ArrayList<>();

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)
        ) {
            Integer cnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < cnt; i++) {
                Integer checkNum = Integer.parseInt(br.readLine());

                if(checkNum.equals(0)){
                    int lastIdx = stackArr.size() - 1;
                    stackArr.remove(lastIdx);
                } else {
                    stackArr.add(checkNum);
                }
            }
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)) {
            Integer  result = 0;
            for (Integer val : stackArr) {
                result += val;
            }
            bw.write(result + "");
        }
    }
}
