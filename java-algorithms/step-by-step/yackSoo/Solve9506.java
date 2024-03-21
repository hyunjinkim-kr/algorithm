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
    // 3. arr 배열의 약수의 짝을 찾아 배열arr에 추가한다. 단, 1의짝은 no1이므로 생략한다.
    // -- 복잡도 : no1 의 제곱근 -1
    // 4. arr 배열의 합을 구하고, no1의 일치여부로 리턴값을 정한다.
    // -- 복잡도 : 2*no1 의 제곱근 -1
    //
    // 복잡도 : 4*no1 의 제곱근 -2
    // 시간복잡도 : O(루트(no1))


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
            showNumKind(factorArr, no1);
        }
    }

    // 자기 자신을 제외한 약수의 배열을 리턴하는 함수
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

        // 약수의 개수를 가져온다.
        // 현재 약수 배열의 끝 값을 가져와서 비교한다.
        Integer lastFactor = factorsArr.get(factorsArr.size() - 1);
        Integer addArrSize = factorsArr.size() - 1; // Arr내의 숫자와 짝이 맞는 숫자만큼 반복 목적.

        if (lastFactor * lastFactor == no1) {
            addArrSize -= 1;
        }

        for (int j = addArrSize; j > 0; j--) {
            factorsArr.add(no1 / factorsArr.get(j));
        }
        return factorsArr;
    }

    // 배열의 합을 리턴하는 함수
    public static Integer getSumOfFactors(ArrayList<Integer> factorArr) {
        Integer factorSum = 0;
        for (int i = 0; i < factorArr.size(); i++) {
            factorSum += factorArr.get(i);
        }
        return factorSum;
    }

    // 배열과 입력된 수로, 완전수를 체크하여 문장을 리턴하는 함수
    public static void showNumKind(ArrayList<Integer> factorArr, Integer no1) {
        final String noPerfectStr = String.format("%d is NOT perfect.", no1);
        StringBuilder perfectStr = new StringBuilder(String.format("%d = ", no1));

        // 완전수일때
        Integer factorSum = getSumOfFactors(factorArr);

        if (!factorSum.equals(no1)) {
            System.out.println(noPerfectStr);
            return;
        }

        for (int i = 0; i < factorArr.size(); i++) {
            perfectStr.append(factorArr.get(i) + " + ");
        }
        // 마지막에 자투리 잘라주자..?
        perfectStr.delete(perfectStr.length() - 3, perfectStr.length());
        System.out.println(perfectStr);
    }
}
