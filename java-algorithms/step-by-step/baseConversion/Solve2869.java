package baseConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.LongStream;


// 문제 : 달팽이는 올라가고 싶다
// 해결책2. 이진탐색 풀이 (lower bound)
//
// 낮동안 upA 를 올라가고, 밤동안 downB 내려온다.
// heightV 의 높이를 올라가야한다.
// 단순하게 생각하면, (upA - downB)*x >= heightV 지만, 이미 올라간경우는 미끄러지지 않을 수 있으므로
// upA를 선행하여 heightV 에 도달했을때 멈춰야한다.
// 이진탐색을 해서 (upA - downB)*x < height 를 한후, upA를 더했을때 height여부를 체크후 반환하자!
// 최종 공식 : (upA - downB) * (mid - 1) + upA < heightV;
// 복잡도 : log 1000000000
//
//시간복잡도 : log N

public class Solve2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rowInfo = br.readLine();
        StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");
        BigInteger upA = BigInteger.valueOf(Integer.valueOf(stRowInfo.nextToken()));
        BigInteger downB = BigInteger.valueOf(Integer.valueOf(stRowInfo.nextToken()));
        BigInteger heightV = BigInteger.valueOf(Integer.valueOf(stRowInfo.nextToken()));

        BigInteger date = calcDate(upA, downB, heightV);
        System.out.print(date);
    }

    public static BigInteger calcDate(BigInteger upA, BigInteger downB, BigInteger heightV) {



        BigInteger begin = BigInteger.valueOf(1);
        BigInteger end = BigInteger.valueOf(1000000000); // 높이 최대 10억, 하루에 올라가는 최저거리 1. 엄밀히따지면, 9억9999만9999가 맞을듯.

        while (begin.compareTo(end) < 0) {
            BigInteger mid = begin.add((end.subtract(begin)).divide(BigInteger.valueOf(2)));
            BigInteger heightM = upA.subtract(downB).multiply(mid.subtract(BigInteger.valueOf(1))).add(upA);
            // (upA - downB) * (mid - 1) + upA < heightV;
            if (heightM.compareTo(heightV) < 0) {
                begin = mid.add(BigInteger.valueOf(1));
            } else {
                end = mid;
            }
        }
        return end;
    }
}

