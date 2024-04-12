package setAndMap;

import java.io.*;
import java.util.*;

public class Solve10816 {
    public static void main(String[] args) throws IOException {
        // 문제 : 숫자 카드 2
        // 해결책 : 입력된 번호를 key로 하고 입력된 횟수를 value로 저장한뒤 출력한다.
        //
        // N : 입력받은 개수
        // M : 테스트 개수
        //
        // 1. 입력받은 숫자를 key로 하여 value 1로 저장한다. 또 다시 입력되면, value를 1씩 증가한 값으로 바꿔준다.
        // -- 복잡도 : N
        // 2. 테스트 숫자를 key로 하는 value 값을 출력한다.
        // -- 복잡도 : M
        //
        // 시간복잡도 : O(N)
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
        ) {
            // Logic 구현부
            Integer inputCnt = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 저장
            for (int i = 0; i < inputCnt; i++) {
                Integer inputNum = Integer.parseInt(st.nextToken());
                if (map.containsKey(inputNum)) {
                    Integer numCount = map.get(inputNum);
                    map.put(inputNum, numCount + 1);
                    continue;
                }
                map.put(inputNum, 1);
            }

            try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
                 BufferedWriter bw = new BufferedWriter(osw)
            ) {
                Integer testCnt = Integer.parseInt(br.readLine());
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < testCnt; j++) {
                    Integer testValue = Integer.parseInt(st2.nextToken());
                    Integer result = map.getOrDefault(testValue, 0);
                    bw.write(result + " ");
                }
            }
        }
    }

    public static boolean isNaN(String testValue) {
        return testValue.matches("\\d+");
    }
}
