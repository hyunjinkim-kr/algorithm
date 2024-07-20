package advanced2;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//문제 : 붙임성 좋은 총총이
//해결책 : "ChongChong" 과 직,간접 접촉한 사람을 모두 배열에 넣는다.
//
// N : 사람이 만난기록의 수
// A : 만난 사람1
// B : 만난 사람2
//
// - 1. N을 입력받는다.
//
// - 2. N에 따라 총총이를 처음 만난 사람과 그 뒤의 사람들을 배열에 저장한다.
//
//
//  시간복잡도 : N

public class Solve26069 {
    public static void main(String[] args) throws IOException {
        final String chongNm = "ChongChong";
        Integer result = 0;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            // 입력 수
            Integer N = Integer.parseInt(br.readLine());
            Set<String> danceUserArr = new HashSet<>();
            danceUserArr.add(chongNm);

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String A = st.nextToken();
                String B = st.nextToken();

                if (danceUserArr.contains(A)) {
                    danceUserArr.add(B);
                }

                if (danceUserArr.contains(B)) {
                    danceUserArr.add(A);
                }
            }
            result = danceUserArr.size();
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }
}
