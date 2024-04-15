package setAndMap;

import java.io.*;
import java.util.*;

public class Solve1764 {
    public static void main(String[] args) throws IOException {
        // 문제 : 듣보잡
        // 해결책 : 듣못 명단에 사람을 넣고, 보못 명단에 추가될 사람이 있으면 결과 리스트에 넣은후 정렬한다.
        //
        // H : 듣도못한 사람을 저장할 hashSet
        // N : 듣도못한 사람 수
        // M : 보도못한 사람 수
        // R : 공통되는 사람의 이름이 저장되는 리스트
        // N" : 듣도보도못한 사람 수
        //
        // 1. 입력받은 숫자 N개만큼 듣도못한 사람을 저장한다.
        // 복잡도 : N
        // 2. 보도못한 사람을 M번 입력받는다. 듣도못한사람 H에 이름이 있으면, 공통되는 리스트 R에 저장한다.
        // 복잡도 : 2 * M
        // 3. R을 사전순으로 정렬한다.
        // 복잡도 : N"logN"
        //
        // 시간복잡도 : O(NlogN)
        HashSet<String> unknownSet = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

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
                unknownSet.add(inputName);
            }

            for (int j = 0; j < testCnt; j++) {
                String findName = br.readLine();
                if(unknownSet.contains(findName)){
                    result.add(findName);
                }
            }
        }

        result.sort(Comparator.naturalOrder());

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)
        ) {
            bw.write(result.size() + "\n");
            for (String val : result){
                bw.write(val + "\n");
            }
        }
    }
}
