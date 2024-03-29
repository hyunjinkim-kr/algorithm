package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solve10101 {
    public static void main(String[] args) throws IOException {
        // 문제 : 삼각형 외우기
        //        세 각의 크기가 모두 60이면, Equilateral
        //        세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
        //        세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
        //        세 각의 합이 180이 아닌 경우에는 Error
        //
        // 해결책 : 삼각형 조건에 맞게 분류하여 출력한다.
        //
        // 1. 세 각의 합이 180인 경우와 아닌 경우를 분류한다.
        // 2. 180인 경우 한개의 각이 60이면서, 또다른 한개의 각과 같으면 정삼각형이다.
        // 3. 정삼각형이 아니면서, 세개의 각중 두개의 각이 같으면 이등변삼각형이다.
        // 4. 2와 3이 아니면서 합이 180이면 부등변 삼각형이다.
        //
        // 시간복잡도 : O(N)

        Scanner scan = new Scanner(System.in);
        Integer angle1 = scan.nextInt();
        Integer angle2 = scan.nextInt();
        Integer angle3 = scan.nextInt();

        triangle result = checkTriangle(angle1, angle2, angle3);
        System.out.print(result);
    }

    public static triangle checkTriangle(Integer angle1, Integer angle2, Integer angle3) {
        if (angle1 + angle2 + angle3 != 180) {
            return triangle.Error;
        }

        if (angle1 == 60 && angle1 == angle2) {
            return triangle.Equilateral;
        }

        if (angle1 == angle2 || angle2 == angle3 || angle1 == angle3) {
            return triangle.Isosceles;
        }
        return triangle.Scalene;
    }

    enum triangle {
        Equilateral,
        Isosceles,
        Scalene,
        Error;
    }
}

