package yackSoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solve9506 {
    // 문제 : 약수들의 합
    //
    // 해결책 : no1을 나누면서, no1을 제외한 약수의 합과 입력값이 일치하는지 리턴.
    //  no1 : 첫번째 숫자. 완전수를 체크할 수
    //  sum : 약수들의 합
    //  i : 나눠질 수
    //
    // 1. no1를 1부터 no1 - 1 까지의 수 i로 나누기를 한다.
    // 2. 나머지가 0이면 sum 에 i값을 더한다.
    // 3. sum과 no1의 일치여부로 리턴값을 정한다.
    //
    // 복잡도 : no1 - 1
    // 시간복잡도 : O(N)


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String rowInfo = br.readLine();
            StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");
            Integer no1 = Integer.valueOf(stRowInfo.nextToken());
            if (no1 == -1) {
                break;
            }
            StringBuilder numKind = checkPerfect(no1);
            System.out.println(numKind);
        }
    }

    public static StringBuilder checkPerfect(Integer no1) {
        StringBuilder perfectStr = new StringBuilder(String.format("%d = ", no1));
        StringBuilder noPerfectStr = new StringBuilder(String.format("%d is NOT perfect.", no1));
        Integer factorSum = 0;

        for (int i = 1; i < no1; i++) {
            // 약수
            if (no1 % i == 0) {
                factorSum += i;
                perfectStr.append(i + " + ");
            }
        }
        // 마지막에 자투리 잘라주자..?
        perfectStr.delete(perfectStr.length() - 3, perfectStr.length());

        // 완전수일때
        if (factorSum.equals(no1)) {
            return perfectStr;
        }
        return noPerfectStr;
    }
}
