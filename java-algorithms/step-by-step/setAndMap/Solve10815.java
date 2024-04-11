package setAndMap;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solve10815 {
    public static void main(String[] args) throws IOException {
        // 문제 : 숫자 카드
        // 해결책 : 숫자를 hashSet에 넣고, 입력받는 숫자가 있는지 탐색한다.
        //
        // H : 숫자를 저장할 hashSet
        // N : 저장된 숫자 개수
        // R : 테스트 결과를 저장하는 리스트
        // M : 테스트 숫자 개수
        //
        // 1. 입력받은 숫자 N개를 저장한다.
        // 복잡도 : N
        // 2. 테스트 숫자가 H에 저장되어있는지 확인하고 결과를 R에 저장한다. 그후, R을 출력한다.
        // 복잡도 : M
        //
        // 시간복잡도 : O(N)
        HashSet<Object> hm = new HashSet<>();
        ArrayList<Integer> resultArr = new ArrayList<>();

        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            try (BufferedReader br = new BufferedReader(isr)) {
                // Logic 구현부
                Integer numCnt = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int i = 0; i < numCnt; i++) {
                    Integer inputNum = Integer.parseInt(st.nextToken());
                    hm.add(inputNum);
                }

                Integer findNumCnt = Integer.parseInt(br.readLine());
                StringTokenizer st2 = new StringTokenizer(br.readLine());

                for(int j = 0; j < findNumCnt; j++){
                    Integer testNum = Integer.parseInt(st2.nextToken());
                    if(hm.contains(testNum)){
                        resultArr.add(1);
                        continue;
                    }
                    resultArr.add(0);
                }
            }
        }

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            try (BufferedWriter bw = new BufferedWriter(osw)) {
                final String resultStr = resultArr.stream().map(String::valueOf).collect(Collectors.joining(" "));
                bw.write(resultStr);
            }
        }
    }
}
