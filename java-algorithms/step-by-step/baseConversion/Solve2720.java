package baseConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 : 세탁소 사장 동혁
//해결책 : 입력받은 거스름돈을 단위가 큰 동전부터 나눈다. 나머지를 다음 단위의 동전으로 나누는 행동을 반복한다.
// C : 계산이 일어난 횟수
// P : 입력받은 거스름돈
// T : 코인종류
//
// 1. 계산이 일어난 횟수만큼 거스름돈을 계산한다.
//  -- 복잡도 : C
// 2. 코인의 액수가 큰 순서대로 거스름돈을 나눈 몫을 구하고, 그 나머지로 다음 코인의 수를 구하기를 T번 반복한다.
//    ** 입력받은 숫자가 금액 * 100이므로, 코인 또한 * 100 한 값으로 나누기를 진행한다.
//  -- 복잡도 : T
//
// --시간복잡도 : C * T
public class Solve2720 {
    // 동전 종류 배열
    private static int[] TYPE_OF_COINS = {
            25, // 쿼터(Quarter, $0.25)
            10, // 다임(Dime, $0.10)
            5, // 니켈(Nickel, $0.05)
            1 // 페니(Penny, $0.01)
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer payCount = Integer.parseInt(br.readLine()); // 계산된 횟수

        for (int i = 0; i < payCount; i++) {
            Integer price = Integer.valueOf(br.readLine());

            // Pair 사용
            StringBuilder answer = calcChange(price);
            System.out.println(answer);
        }
    }

    public static StringBuilder calcChange(Integer price) {

        StringBuilder basedStr = new StringBuilder();

        Integer priceMod = price;

        for (int i = 0; i < TYPE_OF_COINS.length; i++) {
            Integer coinCount = priceMod / TYPE_OF_COINS[i];
            basedStr.append(String.valueOf(coinCount) + " ");
            priceMod = priceMod % TYPE_OF_COINS[i];
        }
        return basedStr;
    }
}
