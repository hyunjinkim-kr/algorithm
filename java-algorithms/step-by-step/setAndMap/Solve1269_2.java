package setAndMap;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solve1269_2 {
    public static void main(String[] args) throws IOException {
        // 문제 : 대칭 차집합
        // 해결책 : 공통된 원소를 뺴자.
        //
        // N : 첫번째 집합의 수
        // M : 두번째 집합의 수
        //
        // 1. 입력받은 숫자 N개만큼 집합 H1에 저장한다.
        // 복잡도 : N
        // 2. 입력받은 숫자 M개만큼 확인한다. 이미 있으면 삭제시키고, 없으면 추가한다.
        // 복잡도 : M
        // 3. 집합의 갯수를 출력한다.
        //
        // 시간복잡도 : O(NlogN)
        HashSet<Integer> set1 = new HashSet<>();
        Integer inputCnt;
        Integer testCnt;

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)
        ) {
            // Logic 구현부
            StringTokenizer st = new StringTokenizer(br.readLine());
            inputCnt = Integer.parseInt(st.nextToken());
            testCnt = Integer.parseInt(st.nextToken());
            // 저장
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int i = 0; i < inputCnt; i++) {
                Integer inputNum1 = Integer.parseInt(st1.nextToken());
                set1.add(inputNum1);
            }

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCnt; j++) {
                Integer inputNum2 = Integer.parseInt(st2.nextToken());
                if(set1.contains(inputNum2)){
                    set1.remove(inputNum2);
                } else {
                    set1.add(inputNum2);
                }
            }
        }

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)
        ) {
            bw.write(set1.size() + "");
        }
    }
}
