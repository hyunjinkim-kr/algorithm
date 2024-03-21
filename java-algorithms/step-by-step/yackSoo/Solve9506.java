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
    //  arr : 제곱근보다 작은 약수가 저장되는 배열
    //  sum : 약수들의 합
    //  i : 나눠질 수
    //
    // 1. no1를 1부터 no1의 제곱근까지 나누기를 한다.
    // 2. 나머지가 0이면 sum 에 i값을 더하고, 배열arr에 추가한 후 리턴한다.
    // -- 복잡도 : no1 의 제곱근
    // 3. 계산된 arr 배열의 약수를 sum에 더한다.
    // -- 복잡도 : no1 의 제곱근
    // 4. arr 배열의 약수의 짝을 찾아 sum에 더한다.
    // -- 복잡도 : no1 의 제곱근
    // 3. sum과 no1의 일치여부로 리턴값을 정한다.
    //
    // 복잡도 : no1 의 제곱근 * 3
    // 시간복잡도 : O(루트(N))


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String rowInfo = br.readLine();
            StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");
            Integer no1 = Integer.valueOf(stRowInfo.nextToken());
            if (no1 == -1) {
                break;
            }
            ArrayList<Integer> factorArr = getFactorList(no1);
            StringBuilder numKind = checkPerfect(factorArr, no1);
            System.out.println(numKind);
        }
    }

    // 제곱근이하의 약수를 포함한 배열을 리턴하는 함수
    public static ArrayList<Integer> getFactorList(Integer no1) {
        double no1Sqrt = Math.sqrt(no1); //약수의 범위를 제곱근으로 제한한다
        ArrayList<Integer> factorsArr = new ArrayList<Integer>();

        for (int i = 1; i <= no1Sqrt; i++) {
            //약수가 아니면 continue;
            if (no1 % i != 0) {
                continue;
            }
            factorsArr.add(i);
        }
        return factorsArr;
    }


    // 배열과 입력된 수로, 완전수를 체크하여 문장을 리턴하는 함수
    public static StringBuilder checkPerfect(ArrayList<Integer> factorArr, Integer no1) {
        StringBuilder perfectStr = new StringBuilder(String.format("%d = ", no1));
        StringBuilder noPerfectStr = new StringBuilder(String.format("%d is NOT perfect.", no1));
        Integer factorSum = 0;

        double no1Sqrt = Math.sqrt(no1); //약수의 범위를 제곱근으로 제한한다

        for (int i = 0; i < factorArr.size(); i++) {
            factorSum += factorArr.get(i);
            perfectStr.append(factorArr.get(i) + " + ");
        }

        // 약수의 갯수를 가져온다.
        // 현재 약수 배열의 끝 값을 가져와서 비교한다.
        Integer lastFactor = factorArr.get(factorArr.size() - 1);
        Integer addArrSize = factorArr.size() - 1; // Arr내의 숫자와 짝이 맞는 숫자만큼 반복 목적.

        if (lastFactor * lastFactor == no1) {
            addArrSize -= 1;
        }

        for (int j = addArrSize; j > 0; j--) {
            factorSum += no1 / factorArr.get(j);
            perfectStr.append(no1 / factorArr.get(j) + " + ");
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
