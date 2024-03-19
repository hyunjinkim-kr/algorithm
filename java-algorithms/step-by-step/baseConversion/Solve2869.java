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
// 해결책1. 이진탐색 풀이 (lower bound)
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

// 해결책2. 공식세우기
//
// 도달했을때의 날짜에 대한 부등식을 구한다.
// (upA - downB) * (date -1) + upA >= heightV
// (upA - downB) * (date -1) >= heightV - upA
// date >= (heightV - upA) / (upA - downB) + 1
// 최종적으로, (heightV - upA)%(upA - downB) 가 0이 아니라면, 1을 더해준다.
// 시간복잡도 : O(1)

public class Solve2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rowInfo = br.readLine();
        StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");
        Integer upA = Integer.valueOf(stRowInfo.nextToken());
        Integer downB = Integer.valueOf(stRowInfo.nextToken());
        Integer heightV = Integer.valueOf(stRowInfo.nextToken());

        Integer date = calcDate(upA, downB, heightV);
        System.out.print(date);
    }

    public static Integer calcDate(Integer upA, Integer downB, Integer heightV) {

        Integer date = (heightV - upA) / (upA - downB) + 1;

        // 1.2일 이러면, 하나를 더해주고
        if ((heightV - upA) % (upA - downB) != 0) {
            date++;
        }
        return date;

        // 과거의 유물. 2진탐색
        //        Integer begin = 1;
        //        Integer end = heightV; // 높이 최대 10억, 하루에 올라가는 최저거리 1. 엄밀히따지면, 9억9999만9999가 맞을듯.

        //        while (begin.compareTo(end) < 0) {
        //            Integer mid = begin + (end - begin) / 2;
        //            Integer heightM = (upA - downB) * (mid - 1) + upA;
        //            // (upA - downB) * (mid - 1) + upA < heightV;
        //            if (heightM < heightV) {
        //                begin = mid + 1;
        //            } else {
        //                end = mid;
        //            }
        //        }
        //  return date;
    }
}

