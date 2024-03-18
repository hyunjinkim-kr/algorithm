package baseConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.LongStream;


// 문제 : 분수찾기
// 해결책2. 이진탐색 풀이 (lower bound)
// 등차수열의 합 (n^2 + n) / 2 에 대하여 이진탐색 수행
//
// begin : 시작값. 초기값은 1
// mid : begin과 end를 2로 나눈 값
// end : 끝값. 초기값은 4472
//
// 1. 시작점과 끝점을 설정한다. (B가 1000만까지 입력 가능할떄 n의 최대값은 4472, 4472 end설정)
// 2. 탐색에 맞는 방법을 선택한다. -> lower bound. 최초로 일치하는 값 찾기.(사실 중복된 값이 없으므로 그냥 search해도 됨.)
//  - (n^2 + n) / 2가 B보다 크거나 같은 최초의 n을 찾아야한다. -> 1 ~ 4472
//  - 시작 1과 end 4472를 더해서 2로 나눈다.
//  - mid를 n에 대입한  (n^2 + n) / 2값이 B보다 작은경우, n이 너무 작으므로 그 뒤의 범위를 계산해야한다.
//    따라서 begin을 mid + 1로 변경한다. -> 2236 ~ 4472
//  - 반대로 같거나 작은 경우,이전범위~현재 mid를 탐색해야한다.
//    따라서 end를 mid로 변경하고 이전 범위를 탐색한다. -> 1 ~ 2236
//  - 위 행위를 반복하다가, begin이 end와 같아질때 종료 후 end를 리턴한다.
//
// 복잡도 : log 4472
//
// -- 시간복잡도 = log n

public class Solve1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer inputB = Integer.parseInt(br.readLine()); // B번째 입력

        String fraction = findFraction(inputB);
        System.out.print(fraction);
    }

    //이진탐색 풀이 (lower bound) -- 시간복잡도 = log n
    public static String findFraction(double inputB) {
        // 이차방정식의 계수
        // 등차수열의 합 : n{2a + (n-1)d}/2a
        // n{ 2 + n - 1}/2
        // n^2 + n / 2
        int begin = 1;
        int end = 4472; // B가 1000만 이하일 때 n의 최대값은 4472
        String result;

        while (begin < end) {
            int mid = (begin + end) / 2;
            if ((Math.pow(mid, 2) + mid) / 2 < inputB) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        //이전 항까지의 갯수를 제외해서, end의 몇번째 분수인지 판별할 값.
        int nthHang = (int) (inputB - (Math.pow(end - 1, 2) + (end - 1)) / 2);

        //홀수일때는 분자가 시작
        if (end % 2 == 1) {
            result = (end - nthHang + 1) + "/" + nthHang;
        } else {
            result = nthHang + "/" + (end - nthHang + 1);
        }
        return result;
    }
}

