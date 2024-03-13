package baseConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 : 진법 변환
//해결책 : 입력받은 문자의 각 자릿수를 진법숫자로 곱한뒤 더한다.
// N : 입력받은 문자열
// B : 진법을 나타내는 숫자
// n : 진법의 지수
//
//1. 입력받은 문자 N의 길이만큼 뒤에서 부터 자릿수를 숫자로 변환 후, B^n 만큼 곱한 값들을 더한다.
// 복잡도 : N
public class solve_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String rowInfo = br.readLine();
        StringTokenizer stRowInfo = new StringTokenizer(rowInfo," ");
        String baseStr = String.valueOf(stRowInfo.nextToken());
        Integer baseNum = Integer.valueOf(stRowInfo.nextToken());

        Integer answer = convertWithBase(baseStr,baseNum);
        System.out.print(answer);
    }
    public static Integer convertWithBase(String baseStr,Integer baseNum){

        Integer baseNumSum = 0;

        for (int i = baseStr.length()-1; i >= 0; i--){
            Integer baseN = Character.getNumericValue(baseStr.charAt(i));
            baseNumSum += baseN * (int)Math.pow(baseNum, baseStr.length()-1 -i);
        }
        return baseNumSum;
    }
}
