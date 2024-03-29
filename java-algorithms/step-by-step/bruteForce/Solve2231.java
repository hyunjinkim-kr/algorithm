package bruteForce;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class Solve2231 {
    public static void main(String[] args) throws Exception {
        // 문제 : 분해합
        // 해결책 : 입력된 수의 생성자가 될 수 있는 최소값 범위 이상부터 탐색한다.
        //
        // 1. 입력받은 수가 몇자리 수인지 판별한다.
        // 2. 입력받은 수에서, 자리수 * 9 만큼을 뺀 값이 생성자가 될 수 있는 최소 숫자이다.
        //  ** 단, 음수가 나오는 case는 0으로 시작한다.
        // 3. 최소숫자부터 N가지 탐색한다.
        //
        // 시간복잡도 : O(N^2)
        Scanner scan = new Scanner(System.in);
        Integer num = scan.nextInt(); // 입력받은 숫자

        Integer result = getMinConstructor(num);
        System.out.print(result);
    }

    public static Integer getMinConstructor(Integer num) {
        Integer result = 0;
        Integer digit = (int) Math.log10(num) + 1;
        Integer start = 0;
        if (num - digit * 9 > 0) {
            start = num - digit * 9;
        }

        for (int i = start; i < num; i++) {
            if (num.equals(i + getDigitSum(i, digit))) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static Integer getDigitSum(Integer num, Integer digit) {
        Integer digitSum = 0;
        //String numStr = String.valueOf(num);

        for (int j = 0; j < digit; j++) {
            digitSum += num % 10;
            num /= 10;
            //Integer.parseInt(String.valueOf(numStr.charAt(j)));
        }
        return digitSum;
    }
//    public static Integer getMinConstructor(Integer num) {
//        Integer result = 0;
//
//        for (int i = 0; i < num; i++) {
//            Integer digitSum = 0;
//
//            String numStr = String.valueOf(i);
//            if (i + numStr.length() * 9 < num) {
//                continue;
//            }
//
//            for (int j = 0; j < numStr.length(); j++) {
//                digitSum += Integer.parseInt(String.valueOf(numStr.charAt(j)));
//            }
//
//            if (num.equals(digitSum + i)) {
//                result = i;
//                break;
//            }
//        }
//        return result;
//    }
}