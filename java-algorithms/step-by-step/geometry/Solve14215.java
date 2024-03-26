package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solve14215 {
    public static void main(String[] args) throws IOException {
        // 문제 : 세 막대
        //
        // 해결책 : 가장 긴 선이 나머지 두개 합보다 작게 만든후 합을 구한다.
        //
        // 1. 입력받은 세개 선의 최대값을 구한다
        // 2. 가장 긴 선이 나머지 선의 합보다 작으면 단순 합이 둘레이다.
        // 3. 아니라면, 나머지 선의 합보다 1 작은 숫자를 가장 긴 선으로 하여 계산한다.
        //
        // 시간복잡도 : O(1)

        Scanner scan = new Scanner(System.in);
        Integer line1 = scan.nextInt();
        Integer line2 = scan.nextInt();
        Integer line3 = scan.nextInt();

        ArrayList<Integer> lineArr = new ArrayList<Integer>();
        lineArr.add(line1);
        lineArr.add(line2);
        lineArr.add(line3);

        Integer result = getTriangleRound(line1, line2, line3);
        System.out.print(result);
    }

    public static Integer getTriangleRound(Integer line1, Integer line2, Integer line3) {

        Integer maxLine = Math.max(line1, line2);
        maxLine = Math.max(maxLine, line3);

        Integer sumLine = line1 + line2 + line3;

        if (maxLine < sumLine - maxLine) {
            return sumLine;
        }

        return 2 * (sumLine - maxLine) - 1;
    }
}

