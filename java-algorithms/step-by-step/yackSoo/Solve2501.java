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
    // no1를 1부터 no1의 제곱근까지 반복하며 나눈다.
    // 나머지가 0인 경우, i와 no1을 i로 나눈 값을 각각 배열의 시작과 끝에 저장한다.
    // i와 no1을 i로 나눈 값이 일치하는 경우, 한개만 저장한다.
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
        System.out.println(nthFactor);
    }

    public static Integer checkYackSoo(Integer no1, Integer no2) {

        double no1Sqrt = Math.sqrt(no1); //약수의 범위를 제곱근으로 제한한다
        ArrayList<Integer> factorsArr = new ArrayList<Integer>();
        Integer count = 0;

        for (int i = 1; i <= no1Sqrt; i++){
            //약수
            if(no1 % i == 0){
                if(no1/i == i){
                    factorsArr.add(count,i);
                    break;
                }
                factorsArr.add(count,i);
                factorsArr.add(factorsArr.size()-count,no1/i);
                count++;
            }
        }

        if(factorsArr.size() < no2){
            return 0;
        }
        return factorsArr.get(no2-1);
    }
}
