package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solve1085 {
    public static void main(String[] args) throws IOException {
        // 문제 : 직사각형에서 탈출!
        // 해결책 : 현재위치 x,y에서 0,0과 w,h 간의 최소값을 구한다.
        //
        // x : 현재 x축 위치
        // y : 현재 y축 위치
        // w : x축의 끝
        // h : y축의 끝
        //
        // 해결책 : x, y, w-x, h-y의 최소값을 구한다.
        //
        //  - 시간복잡도 : O(1)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rowInfo = br.readLine();
        StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");

        Integer x = Integer.valueOf(stRowInfo.nextToken());
        Integer y = Integer.valueOf(stRowInfo.nextToken());
        Integer w = Integer.valueOf(stRowInfo.nextToken());
        Integer h = Integer.valueOf(stRowInfo.nextToken());

        Integer xyMin = Math.min(x, y);
        Integer whMin = Math.min(w - x, h - y);
        Integer minRange = Math.min(xyMin, whMin);

        System.out.print(minRange);
    }
}
