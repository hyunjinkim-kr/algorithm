package stackQueueDeque;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solve9012 {
    // 문제 : 괄호
    //
    // 해결책 : ( 괄호와 ) 괄호의 개수가 일치하는지 체크한다.
    // ** 단, ) 괄호가 숫자가 더 많은 순간이 있으면 바로 체크를 끝낸다.
    //
    // T : 입력되는 괄호문자열 개수
    // M : T의 길이
    // cnt : 괄호 상태의 합
    //
    //  1. 입력받은 괄호문자열 개수 T만큼 반복문을 수행한다.
    // -- 시간복잡도 : T
    //  2. T의 길이 M만큼 한글자씩 체크한다. (면 cnt 에 1을 더하고, )면 cnt에 1을 뺸다. cnt가 음수가 되면 바로 종료한다.
    // -- 시간복잡도 : M
    //  3. cnt가 0인지 여부를 체크하여 결과를 저장 후 출력한다.
    // -- 시간복잡도 : T
    //
    // 복잡도 : T*M + T
    // 시간복잡도 : O(T * M)
    public static void main(String[] args) throws IOException {

        final String openVps = "(";
        ArrayList<String> resutArr = new ArrayList<>();

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)
        ) {
            Integer cnt = Integer.parseInt(br.readLine());

            for (int i = 0; i < cnt; i++) {
                String inputStr = br.readLine();
                String result = "YES";
                Integer vpsCount = 0;

                for (int j = 0; j < inputStr.length(); j++) {
                    String inputVps = inputStr.substring(j, j + 1);

                    if (inputVps.equals(openVps)) {
                        vpsCount++;
                    } else {
                        vpsCount--;
                    }

                    if (vpsCount < 0) {
                        break;
                    }
                }

                if(vpsCount != 0){
                    result = "NO";
                }
                resutArr.add(result);
            }
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)) {
            for (String result : resutArr) {
                bw.write(result + "\n");
            }
        }
    }
}
