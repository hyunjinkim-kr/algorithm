package bruteForce;

import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solve1018 {
    // 문제 : 체스판 다시 칠하기
    // 해결책 : 첫번째 칸부터 하나씩 다 찾아보자.
    //
    // H : 세로길이
    // W : 가로길이
    //
    // 1. 입력받은 문자를 저장한다.
    // 2. 저장받은 줄의 개수와 한줄의 길이에서 각각 8을 뺀 범위를 탐색지점으로 한다.
    //  - 복잡도 : (H-8) * (W-8)
    // 3. 탐색지점부터 8줄, 8칸씩 문자를 탐색한다. 줄과 칸의 홀짝 여부에 따라 분류하여 바뀔 문자개수를 받는다.
    //  - 복잡도 : 8 * 8
    // 4. 탐색지점별 바뀔 문자개수의 최소값을 출력한다.
    //
    // 시간복잡도 : O(N^2)

    // Integer.toBinaryString() 사용하여 비트마스크 하는 방법도 있습니다.
    // 참고 : https://cornarong.tistory.com/49
    // 기타 방법 : 슬라이딩 윈도우, 뭔가 궁금하면 tagged pointer를 검색하기.

    public static void main(String[] args) throws IOException {
        final Integer chessXy = 8;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rowInfo = br.readLine();
        StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");

        Integer height = Integer.valueOf(stRowInfo.nextToken());
        Integer width = Integer.valueOf(stRowInfo.nextToken());
        ArrayList<ArrayList<String>> chessPanel = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            String lineInfo = br.readLine();
            ArrayList<String> chessLine = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                String block = String.valueOf(lineInfo.charAt(j));
                chessLine.add(block);
            }
            chessPanel.add(chessLine);
        }

        Integer lowerCount = 64; // 입력가능한 최대 크기 : 8 * 8

        // 탐색 시작지점을 지정하는 for문
        for (int y = 0; y <= height - chessXy; y++) {
            for (int x = 0; x <= width - chessXy; x++) {
                Integer result = getLowerCount(chessPanel, x, y, chessXy);
                lowerCount = (int) Math.min(lowerCount, result);
            }
        }
        System.out.print(lowerCount);
    }

    public static Integer getLowerCount(ArrayList<ArrayList<String>> chessPanel,
                                        Integer x,
                                        Integer y,
                                        Integer chessXy) {
        final String w = "W";
        final String b = "B";

        Integer lowerCount = 64;
        Integer count1 = 0;

        // 탐색지점에따라 8칸씩 바뀔 문자 개수 저장
        for (int i = y; i < y + chessXy; i++) {
            for (int j = x; j < x + chessXy; j++) {
                String block = chessPanel.get(i).get(j);
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (block.equals(b)) {
                            count1++;
                        }
                    } else {
                        if (block.equals(w)) {
                            count1++;
                        }
                    }
                } else {
                    if (j % 2 == 0) {
                        if (block.equals(w)) {
                            count1++;
                        }
                    } else {
                        if (block.equals(b)) {
                            count1++;
                        }
                    }
                }
            }
        }
        lowerCount = (int) Math.min(count1, lowerCount - count1);
        return lowerCount;
    }
}