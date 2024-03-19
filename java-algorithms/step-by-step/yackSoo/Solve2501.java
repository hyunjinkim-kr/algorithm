package yackSoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solve2501 {
    // 문제 : 약수 구하기
    //  no1 : 첫번째 숫자. 약수를 체크할 수
    //  no2 : 두번째 숫자. n번째 약수라는 의미
    //  i : 1~no1 까지 계산되는 숫자.
    //  count : no1를 몇번째 나누는지 기록 할 수.
    //
    // 해결책 : no1을 나누면서, n번째로 나눠지는 수 i를 반환
    //
    // no1를 1부터 no1까지 나누기를 한다.
    // 나머지가 0이 아니면 생략한다.
    // 나머지가 0이고, count와 no2가 같을때 계산하는 값 i를 리턴한다.
    //
    // 복잡도 : no1
    // 시간복잡도 : O(N)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String rowInfo = br.readLine();
        StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");
        Integer no1 = Integer.valueOf(stRowInfo.nextToken());
        Integer no2 = Integer.valueOf(stRowInfo.nextToken());

        Integer nthFactor = checkYackSoo(no1, no2);
        System.out.println(nthFactor);
    }

    public static Integer checkYackSoo(Integer no1, Integer no2) {
        Integer count = 1;

        for (int i = 1; i <= no1; i++) {
            if (no1 % i != 0) {
                continue;
            }

            if (count == no2) {
                return i;
            }
            count++;
        }
        return 0;
    }
}
