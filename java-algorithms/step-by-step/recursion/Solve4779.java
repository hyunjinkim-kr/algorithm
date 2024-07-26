package recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solve4779 {
    // 문제 : 칸토어 집합

    // 해결책 : 1/3 ~ 2/3 지점을 공백으로 바꾸고 나머지 지점을 재귀 실행한다.
    //
    // N : 입력받은 숫자
    // result : "-" 과 " "이 담길 문자열
    // start : result 시작
    // end : result 끝
    // startWs : 공백시작
    // endWs : 공백끝
    //
    //  1. 시작과 끝을 정한다.
    //   1-1. 처음 시작과 끝은 각각 0과 3^N 이다.
    //   1-2. 범위대로 result에 "-" 를 추가한다.
    //  2. result 의 1/3, 2/3 지점을 찾는다. 각각 startWs, endWs 로 지정한다.
    //  3. startWs ~ endWs 지점을 " " 으로 대체한다.
    //  4. " " 으로 대체된 길이가 1보다 크다면 재귀한다.
    //      4-1 : start ~ startWs 범위를 재귀한다.
    //      4-2 : endWs ~ end 범위를 재귀한다.
    //
    // -- 시간복잡도 O(N)
    public static void main(String[] args) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw);
        ) {
            String input;
            while ((input = br.readLine()) != null) {
                if (input.isEmpty()) {
                    break;
                }
                Integer N = Integer.parseInt(input);
                String result = cantor(N);
                bw.write(result + "\n");
                bw.flush();  // 각 입력마다 출력 버퍼를 플러시
            }
        }
    }

    public static String cantor(Integer N) {
        StringBuilder sb = new StringBuilder();
        Integer range = (int) Math.pow(3, N);
        for (int i = 0; i < range; i++) {
            sb.append("-");
        }
        cantorHelper(sb, 0, range);
        return sb.toString();
    }

    public static void cantorHelper(StringBuilder sb, Integer start, Integer end) {
        Integer startWs = (end-start) / 3 + start;
        Integer endWs = (end-start) * 2 / 3 + start;

        // 지정된 위치의 문자 교체
        ArrayList<String> spacesArr = new ArrayList<>(Collections.nCopies(endWs - startWs, " "));
        String spaceString = String.join("", spacesArr);
        sb.replace( startWs, endWs, spaceString);
        if(endWs-startWs > 1){
            cantorHelper(sb, start, startWs);
            cantorHelper(sb, endWs ,end);
        }
    }
}
