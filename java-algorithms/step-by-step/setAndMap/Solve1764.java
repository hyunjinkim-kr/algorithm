package setAndMap;

import java.io.*;
import java.util.*;

public class Solve1764 {
    public static void main(String[] args) throws IOException {
        // 문제 : 듣보잡
        // 해결책 : 듣못 명단에 사람을 넣고, 보못 명단에 추가될 사람이 있으면 결과 리스트에 넣은후 정렬한다.
        //
        // T1 : 듣도못한 사람을 저장할 TreeSet
        // N : 듣도못한 사람 수
        // T2 : 듣도못한 사람을 저장할 TreeSet
        // M : 보도못한 사람 수
        //
        // 1. 입력받은 숫자 N개만큼 듣도못한 사람을 저장한다.
        // 복잡도 : N
        // 2. 입력받은 숫자 M개만큼 보도못한 사람을 저장한다.
        // 복잡도 : M
        // 3. 공통된 사람을 추려낸다.
        // 복잡도 : N * log M
        //
        // 시간복잡도 : O(NlogN)
        TreeSet<String> unknownSet1 = new TreeSet<>(Comparator.naturalOrder());
        TreeSet<String> unknownSet2 = new TreeSet<>();

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)
        ) {
            // Logic 구현부
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer inputCnt = Integer.parseInt(st.nextToken());
            Integer testCnt = Integer.parseInt(st.nextToken());
            // 저장
            for (int i = 0; i < inputCnt; i++) {
                String inputName = br.readLine();
                unknownSet1.add(inputName);
            }

            for (int j = 0; j < testCnt; j++) {
                String findName = br.readLine();
                unknownSet2.add(findName);
            }
        }

        // 공통된 사람 추려내기
        unknownSet1.retainAll(unknownSet2);

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)
        ) {
            bw.write(unknownSet1.size() + "\n");
            for (String val : unknownSet1){
                bw.write(val + "\n");
            }
        }
    }
}
