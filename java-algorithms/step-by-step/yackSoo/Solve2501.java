package yackSoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    // 해결책2 : no1의 제곱근 만큼 수행하며, 나뉘는 수를 저장 후 반환
    //
    // Arr1 : 약수를 저장한 배열
    // count2 : 약수의 갯수
    //
    // 1. no1를 1부터 no1의 제곱근까지 반복하며 나눈다.
    // 2. 나머지가 0인 경우 값을 배열 Arr1에 저장한다.
    // 3. 약수의 갯수를 계산한다.
    //      숫자의 제곱근이 정수일 경우 : Arr1의 길이 * 2, 아닐경우 : Arr1의 길이 * 2 -1
    //      (각각 수가 짝이되어 * 2가 되는것인데, 자기 자신과 짝이 될 수는 없으므로 1을 뺀다.)
    // 4. no2번째 Arr1의 값 혹은, (count2 - no2) 위치의 Arr1값과 짝을 분류하여 리턴한다.
    //
    // 복잡도 : no1 의 제곱근
    // 시간복잡도 : O(루트(N))

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String rowInfo = br.readLine();
        StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");
        Integer no1 = Integer.valueOf(stRowInfo.nextToken());
        Integer no2 = Integer.valueOf(stRowInfo.nextToken());

        Integer nthFactor = checkYackSoo(no1, no2);
        System.out.print(nthFactor);
    }

    public static Integer checkYackSoo(Integer no1, Integer no2) {

        double no1Sqrt = Math.sqrt(no1); //약수의 범위를 제곱근으로 제한한다
        ArrayList<Integer> factorsArr = new ArrayList<Integer>();

        for (int i = 1; i <= no1Sqrt; i++) {
            //약수
            if (no1 % i == 0) {
                factorsArr.add(i);
            }
        }

        // 약수의 갯수를 가져온다.
        // 현재 약수 배열의 끝 값을 가져와서 비교한다.
        Integer lastFactor = factorsArr.get(factorsArr.size() - 1);
        Integer factorCount = 0;

        if (lastFactor * lastFactor == no1) {
            factorCount = factorsArr.size() * 2 - 1;
        } else {
            factorCount = factorsArr.size() * 2;
        }

        // 값이 범위 밖일떄
        if (no2 > factorCount) {
            return 0;
        } else if (no2 <= factorsArr.size()) {
            // 약수가 배열 안에 있을때 값 리턴
            return factorsArr.get(no2 - 1);
        }
        // 약수가 배열안에 없을때, 배열안의 숫자로 나눠줘서 짝을 구함.
        return no1 / factorsArr.get(factorCount - no2);
    }
}
