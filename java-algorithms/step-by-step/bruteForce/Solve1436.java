package bruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Function;

public class Solve1436 {
    public static void main(String[] args) throws Exception {
        // 문제 : 영화감독 숌
        // 해결책 : 무식하게 num번째 만큼 수가 나올때가지 돌린다.
        //
        // 0 부터 1씩 숫자를 증가시킨다.
        // 666이 포함된 숫자가 나오면, num에서 하나씩 뺀다.
        // num이 0이 될때 666이 포함된 숫자를 출력한다.
        //
        // 복잡도 : O(N) ?
        Scanner scan = new Scanner(System.in);
        Integer num = scan.nextInt(); // 입력받은 숫자

        Integer testNum = 0;
        while (true){
            if(isValid666(testNum)){
                num--;
                if(num.equals(0)){
                    break;
                }
            }
            testNum++;
        }

        System.out.print(testNum);
    }

    public static boolean isValid666(Integer testNum) {
            return testNum.toString().contains("666");
    }
}