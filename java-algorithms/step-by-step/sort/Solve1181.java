package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solve1181 {
    public static void main(String[] args) throws IOException {
        // 문제 : 단어 정렬
        // 해결책 : 단어를 입력받은 후 길이와 아스키코드로 오름차순 정렬
        //
        // N : 입력받은 단어 개수
        // arr : 저장되는 배열
        //
        // 1. 단어가 입력되면 배열에 저장한다.
        // -- 복잡도 : N
        // 2. 배열을 단어의 길이로 정렬하고, 단어길이가 같다면 아스키코드 정렬을한다.
        // -- 복잡도 : 2*NlogN
        // 3. 배열을 출력한다.
        // -- 복잡도 : N
        //
        // 시간복잡도 : 2N + 2*NlogN
        // O(NlogN)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer wordCnt = Integer.parseInt(br.readLine());
        ArrayList<String> wordArr = new ArrayList<>();

        for (int i = 0; i < wordCnt; i++) {
            String rowInfo = br.readLine();
            if(wordArr.contains(rowInfo)){
                continue;
            }
            wordArr.add(rowInfo);
        }
        br.close();

        wordArr.sort(Comparator.comparing((String word) -> word.length())
                .thenComparing(Comparator.naturalOrder())
        );


        for (int i = 0; i < wordArr.size(); i++) {
            bw.write(wordArr.get(i)+ "\n");
        }
        bw.flush();
        bw.close();
    }
}
