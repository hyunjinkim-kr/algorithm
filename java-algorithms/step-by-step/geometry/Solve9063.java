package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solve9063 {
    public static void main(String[] args) throws IOException {
        // 문제 : 대지
        // 해결책 : 가장큰 좌표와 가장 작은 좌표의 위치를 빼고 그 값을 곱하여 넓이를 구한다.
        // 
        // mc : 구슬의 갯수
        // minX : x좌표의 최소값
        // maxX : x좌표의 최대값
        // minY : y좌표의 최소값
        // maxY : y좌표의 최대값
        //
        // 1. mc만큼 구슬의 x,y 좌표를 입력받을때 최소값(minX,minY)과 최대값(maxX,maxY)을 갱신한다.
        //  복잡도 : mc
        // 2. maxX - minX 는 가로 길이에 해당하고, maxY - minY 는 세로 길이에 해당한다.
        // 3. 두 길이를 곱하여 넓이를 반환한다.
        //
        // 시간복잡도 : O(N)

        Scanner scan = new Scanner(System.in);
        Integer marbleCnt = scan.nextInt(); // 구슬의 갯수

        Integer minX = 10001;
        Integer maxX = -10001;
        Integer minY = 10001;
        Integer maxY = -10001;

        for (int i = 0; i < marbleCnt; i++) {
            Integer X = scan.nextInt();
            Integer Y = scan.nextInt();

            minX = Math.min(minX,X);
            maxX = Math.max(maxX,X);
            minY = Math.min(minY,Y);
            maxY = Math.max(maxY,Y);
        }

        Integer width = maxX - minX;
        Integer height = maxY - minY;

        System.out.print(width*height);
    }
}

