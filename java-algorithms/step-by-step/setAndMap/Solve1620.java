package setAndMap;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solve1620 {
    public static void main(String[] args) throws IOException {
        // 문제 : 나는야 포켓몬 마스터 이다솜
        // 해결책 : 번호와 이름, 이름과 번호를 각각 key, value로 하는 hashMap 두개에서 key로 탐색한다.
        // ** Map의 Entry를 순회하여 value로 .getKey()를 할수도 있으나, N^2이 되므로 map을 두개 만듬.
        //
        // N : 입력받은 개수
        // M : 테스트 개수
        //
        // 1. 입력받은 숫자와 번호를 저장하는 map을 두개 만들고 저장한다.
        //  map1 - key : 번호, value : 이름
        //  map2 - key : 이름, value : 번호
        // -- 복잡도 : N
        // 2. 테스트 값이 숫자일때 map1에서 이름을, 이름일때 map2에서 숫자를 출력한다.
        // -- 복잡도 : M
        //
        // 시간복잡도 : O(N)

        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        Integer inputCnt = 0;
        Integer testCnt = 0;

        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            try (BufferedReader br = new BufferedReader(isr)) {
                // Logic 구현부
                StringTokenizer st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens()) {
                    inputCnt = Integer.parseInt(st.nextToken());
                    testCnt = Integer.parseInt(st.nextToken());
                }
                // 저장
                for (int i = 1; i <= inputCnt; i++) {
                    String poketMonNm = br.readLine();
                    map.put(i, poketMonNm);
                    map2.put(poketMonNm, i);
                }

                try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
                    try (BufferedWriter bw = new BufferedWriter(osw)) {
                        for (int j = 0; j < testCnt; j++) {
                            String testValue = br.readLine();

                            if (isNaN(testValue)) {
                                bw.write(map.get(Integer.parseInt(testValue)) + "\n");
                            } else {
                                bw.write(map2.get(testValue) + "\n");
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isNaN(String testValue) {
        return testValue.matches("\\d+");
    }
}
