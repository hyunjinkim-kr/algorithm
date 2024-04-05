package bruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Function;

public class Solve1436 {
    public static void main(String[] args) throws Exception {
        // 문제 : 영화감독 숌
        // 해결책 :
        Scanner scan = new Scanner(System.in);
        Integer num = scan.nextInt(); // 입력받은 숫자

        Integer testNum = 0;
        Integer cnt = 0;
        while (true){
            if(isValid666(testNum)){
                cnt++;
                if(num.equals(cnt)){
                    break;
                }
            }
            testNum++;
        }

        System.out.print(testNum);
    }

    public static boolean isValid666(Integer testNum) {

        if(testNum.toString().contains("666")){
            return true;
        }
        return false;
    }
}