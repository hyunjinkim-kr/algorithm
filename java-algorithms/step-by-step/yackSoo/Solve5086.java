package yackSoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solve5086 {
    // 문제 : 배수와 약수
    //  no1 : 첫번째 숫자
    //  no2 : 두번째 숫자
    //
    // 해결책 :
    //        첫 번째 숫자가 두 번째 숫자의 약수이다. factor
    //        첫 번째 숫자가 두 번째 숫자의 배수이다. multiple
    //        첫 번째 숫자가 두 번째 숫자의 약수와 배수 모두 아니다. neither
    //
    // factor : no2 % no1 이 0이 아니면 약수
    // multiple : no1 % no2  이 0이 아니면 배수
    // neither : 약수, 배수 이외의 else 처리
    //
    // 복잡도 : 시간복잡도 : O(1)
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String rowInfo = br.readLine();
            StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");
            Integer no1 = Integer.valueOf(stRowInfo.nextToken());
            Integer no2 = Integer.valueOf(stRowInfo.nextToken());
            if (no1 == 0 && no2 == 0) {
                break;
            }
            String numKind = checkYackSoo(no1, no2);
            System.out.println(numKind);
        }
    }

    public static String checkYackSoo(Integer no1, Integer no2) {
        final String factor = "factor";
        final String multiple = "multiple";
        final String neither = "neither";

        if (no2 % no1 == 0) {
            return factor;
        } else if (no1 % no2 == 0) {
            return multiple;
        }
        return neither;
    }
}
