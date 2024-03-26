package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solve5073 {
    public static void main(String[] args) throws IOException {
        // 문제 : 삼각형과 세 변
        //
        // 해결책 : 삼각형 조건에 맞게 분류하여 출력한다.
        //
        // 1. 한 변의 길이가 나머지 두 변의 합 이상이면 삼각형이 아니다.
        // 2. 세변의 길이가 같으면 정삼각형이다.
        // 3. 두변의 길이가 같으면 이등변 삼각형이다.
        // 4. 세변의 길이가 모두 다르면 부등변 삼각형이다.
        //
        // 시간복잡도 : O(N)
        final String equilateral = "Equilateral";
        final String isosceles = "Isosceles";
        final String scalene = "Scalene";
        final String invalid = "Invalid";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String rowInfo = br.readLine();
            StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");

            Integer line1 = Integer.valueOf(stRowInfo.nextToken());
            Integer line2 = Integer.valueOf(stRowInfo.nextToken());
            Integer line3 = Integer.valueOf(stRowInfo.nextToken());

            if (line1 == 0 && line2 == 0 && line3 == 0) {
                break;
            }

            triangle result = checkTriangle(line1, line2, line3);
            System.out.println(result);
        }
    }

    public static triangle checkTriangle(Integer line1, Integer line2, Integer line3) {
        if (line1 >= line2 + line3 || line2 >= line1 + line3 || line3 >= line1 + line2) {
            return triangle.Invalid;
        }

        if (line1.equals(line2) && line1.equals(line3)) {
            return triangle.Equilateral;
        }

        if (line1.equals(line2) || line2.equals(line3) || line1.equals(line3)) {
            return triangle.Isosceles;
        }
        return triangle.Scalene;
    }

    enum triangle {
        Equilateral,
        Isosceles,
        Scalene,
        Invalid;
    }
}

