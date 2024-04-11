package setAndMap;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solve14425 {
    public static void main(String[] args) throws IOException {
        // 문제 : 문자열 집합
        // 해결책 : 문자를 hashSet에 넣고, 입력받는 문자가 있는지 탐색한다.
        //
        // H : 문자를 저장할 hashSet
        // N : 저장된 문자 개수
        // M : 테스트 문자 개수
        //
        // 1. 입력받은 문자 N개를 저장한다.
        // 복잡도 : N
        // 2. 테스트 문자가 H에 저장되어있는지 확인하고 결과를 카운트한다. 최종적으로 카운트를 출력한다.
        // 복잡도 : M
        //
        // 시간복잡도 : O(N)
        HashSet<Object> hm = new HashSet<>();
        Integer inputCnt = 0;
        Integer testCnt = 0;
        Integer count = 0;

        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            try (BufferedReader br = new BufferedReader(isr)) {
                // Logic 구현부
                StringTokenizer st = new StringTokenizer(br.readLine());


                while (st.hasMoreTokens()) {
                    inputCnt = Integer.parseInt(st.nextToken());
                    testCnt = Integer.parseInt(st.nextToken());
                }
                // 저장
                for(int i = 0; i < inputCnt; i++){
                    String inputWord = br.readLine();
                    hm.add(inputWord);
                }

                for(int j = 0; j < testCnt; j++){
                    String testWord = br.readLine();
                    if(hm.contains(testWord)){
                        count++;
                    }
                }
            }
        }

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            try (BufferedWriter bw = new BufferedWriter(osw)) {
                bw.write(count + "");
            }
        }
    }
}
