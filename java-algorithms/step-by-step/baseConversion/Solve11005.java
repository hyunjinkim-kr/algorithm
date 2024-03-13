package baseConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 : 진법 변환2
//해결책 : 입력받은 숫자를 각 자리수의 제곱근만큼 나눠가며 계산한다.
// N : 입력받은 숫자
// N" : 입력받은 숫자를 제곱근으로 나눈 나머지 (N % B^n)
// B : 진법을 나타내는 숫자
// n : 진법의 지수 (logB(N))
// B^n : 각 자리수의 제곱근
//
// 1. 입력받은 숫자 N보다 작거나 같을때 까지 진법 B의 제곱을 n만큼 수행한다.
//  -- 복잡도 : logB(N)
// 2. 입력받은 숫자 N을 자리수의 제곱근에 해당하는 B^n으로 나눈다. 몫은 저장하고, 나머지 값 N"으로 n이 0이 될때까지 반복한다.
//  -- 복잡도 : logB(N)
//
// --시간복잡도 : 2logB(N)
public class Solve11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String rowInfo = br.readLine();
        StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");
        Integer basedAnswer = Integer.valueOf(stRowInfo.nextToken());
        Integer baseNum = Integer.valueOf(stRowInfo.nextToken());

        StringBuilder answer = convertWithBase(basedAnswer, baseNum);
        System.out.print(answer);
    }

    public static StringBuilder convertWithBase(Integer basedAnswer, Integer baseNum) {

        StringBuilder basedStr = new StringBuilder();
        Integer basedCalc = basedAnswer;
        Integer baseMulti = 0;

        while ((int) Math.pow(baseNum, baseMulti) <= basedAnswer) {
            baseMulti++;
        }

        for (int i = 0; i < baseMulti; i++) {
            int basedInt = basedCalc / (int) Math.pow(baseNum, baseMulti - 1 - i);
            char basedChar = 0;

            if (basedInt >= 10) {
                basedChar = (char) (basedInt + 'A' - 10);
                basedStr.append(basedChar);
            } else {
                basedStr.append(String.valueOf(basedInt));
            }
            basedCalc = basedCalc % (int) Math.pow(baseNum, baseMulti - 1 - i);
        }
        return basedStr;
    }
}
