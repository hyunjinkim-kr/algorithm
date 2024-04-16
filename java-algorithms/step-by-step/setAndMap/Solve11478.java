package setAndMap;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solve11478 {
    public static void main(String[] args) throws IOException {
        // 문제 : 서로 다른 부분 문자열의 개수
        // 해결책 : 어차피 set은 중복된 값이 없으므로, 문자열을 자르면서 계속 저장하자.
        //
        // S : 입력된 소문자로만 이루어진 문자열
        // N : 문자열 S의 길이
        // H : 저장되는 set
        //
        // 1. 입력받은 문자를 시작점과 S의 길이 N에 맞게 반복하며 자른다. 자른 문자열을 set H에 추가한다.
        // -- 복잡도 : N^2
        // 2. set H의 갯수를 출력한다.
        //
        // 시간복잡도 : O(N^2)
        HashSet<String> set1 = new HashSet<>();

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)
        ) {
            // Logic 구현부
            String inputStr = br.readLine();
            Integer strLength = inputStr.length();

            for (int i = 0; i < strLength; i++) {
                for (int j = i + 1; j < strLength + 1; j++) {
                    String addWord = inputStr.substring(i, j);
                    set1.add(addWord);
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
