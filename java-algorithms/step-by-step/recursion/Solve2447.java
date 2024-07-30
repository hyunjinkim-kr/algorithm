package recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solve2447 {
    // 문제 : 별 찍기 - 10

    // 해결책 : 전체가 * 인 영역에, 주어진 숫자를 3으로 나누면서 x와 y 영역을 확인하여 " " 을 남긴다.
    //
    // N : 입력받은 숫자
    // starArr : N 길이의 "*" 문자열이 N만큼 있는 배열
    // holeSize : 구멍의 가로세로 길이. N/3 부터 3씩 나눔.
    // x : 가로위치 (초기값 : holeSize)
    // y : 세로위치 (초기값 : holeSize)
    // row : starArr의 y번째 row
    // cnt : hole 크기별로 구멍을 뜷은 횟수
    //
    //  1. starArr 을 만든다.
    //   e.g) N이 3일때 starArr
    //       ***
    //       ***
    //       ***
    //  2. starArr의 row를 가져온다.
    //  3. row의 x ~ holeSize를 공백으로 바꾼다.
    //  4. x와 y에 3 * holeSize 만큼을 더하며, N과 범위를 비교하며 재귀한다.
    //
    // -- 시간복잡도 O(N^2)
    public static void main(String[] args) throws IOException {
        ArrayList<String> resultArr;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw);
        ) {
            Integer N = Integer.parseInt(br.readLine());
            resultArr = star(N);

            for (int i = 0; i < resultArr.size(); i++) {
                bw.write(resultArr.get(i) + "\n");
                bw.flush();  // 각 입력마다 출력 버퍼를 플러시
            }
        }
    }

    public static ArrayList<String> star(Integer N) {
        ArrayList<String> starArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                sb.append("*");
            }
            starArr.add(sb.toString());
        }

        Integer holeSize = N / 3;
        Integer x = N / 3;
        Integer y = N / 3;
        return starHelper(starArr, N, holeSize, x, y, 0);
    }

    public static ArrayList<String> starHelper(ArrayList<String> starArr,
                                               Integer N,
                                               Integer holeSize,
                                               Integer x,
                                               Integer y,
                                               Integer cnt) {
        if (holeSize < 1) {
            return starArr;
        }
        String starRow = starArr.get(y);
        StringBuilder sb = new StringBuilder(starRow);

        // 지정된 위치의 문자 교체
        ArrayList<String> spacesArr = new ArrayList<>(Collections.nCopies(holeSize, " "));
        String spaceString = String.join("", spacesArr);
        sb.replace(x, x + holeSize, spaceString);
        starArr.set(y, sb.toString());

        Integer newY = y + holeSize * 3;
        Integer newX = x + holeSize * 3;

        if (N < newX) {
            cnt++;
            if (cnt < holeSize) {
                //바로 아랫줄 고치기
                starHelper(starArr, N, holeSize, holeSize, y + 1, cnt);
            } else {
                if (N < newY) {
                    // 새로운 구멍 생성
                    starHelper(starArr, N, holeSize / 3, holeSize / 3, holeSize / 3, 0);
                } else {
                    // 다른줄로 이동
                    starHelper(starArr, N, holeSize, holeSize, newY - holeSize + 1, 0);
                }
            }
        } else {
            // 옆으로 이동하기
            starHelper(starArr, N, holeSize, newX, y, cnt);
        }
        return starArr;
    }
}
