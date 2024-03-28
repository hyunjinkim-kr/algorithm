package bruteForce;

import java.util.Scanner;

public class Solve19532 {
    public static void main(String[] args) throws Exception {
        // 문제 : 수학은 비대면강의입니다
        // 해결책 : 연립방정식의 해를 구한다.
        //
        // 1. ax + by = c, dx + ey = f 의 식에 해당하는 계수 a,b,c,d,e,f를 받는다.
        // 2. 각각 x와 y의 계수를 일치하게 하여 뺀 후 식을 구한다.
        //
        // 시간복잡도 : O(1)
        Scanner scan = new Scanner(System.in);
        // ax + by = c
        Integer a = scan.nextInt();
        Integer b = scan.nextInt();
        Integer c = scan.nextInt();
        // dx + ey = f
        Integer d = scan.nextInt();
        Integer e = scan.nextInt();
        Integer f = scan.nextInt();

        calcXyResult(a, b, c, d, e, f);
    }

    public static void calcXyResult(Integer a,
                                    Integer b,
                                    Integer c,
                                    Integer d,
                                    Integer e,
                                    Integer f) {
        Integer y = (c * d - f * a) / (b * d - e * a);
        Integer x = (c * e - b * f) / (a * e - b * d);

        System.out.print(x + " " + y);
    }
}
