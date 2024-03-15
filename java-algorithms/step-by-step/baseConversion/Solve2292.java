package baseConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.LongStream;


// 문제 : 벌집
//해결책 : 방을 한바퀴 돌때마다 6개씩 방이 증가하면다. 따라서 둘러싸는 레벨에 해당하는 방도 6개씩 증가한다.
// B : 입력된 방 번호
// L : 방의 레벨. 초기값은 1
// F : 순회하며 방을 찾는 변수
//
// 1. 시작하는 1번방은 레벨1의 방이다. 레벨1을 둘러싸는 레벨2는 방 6개가 필요하고, 레벨3은 그보다 방 6개가 더 필요하다.
//    레벨의 증가에따라 전체 방은 F+=6*L이 된다. (등차수열의 합 -> 계차수열.)
//  결론적으로 입력값보다 큰 계차수열중 가장 작은 n번째 항을 구해서 비교하면 된다.
// --> 일반항 공식을 세우면, a{n+1} = a{n} + 6n
// --> a{n} = a{1} +  {n-1}Σ{k=1}(6n)
// --> a{n} = 1 + n*(n-1)/2 * 6n
// --> = 3n^2 - 3n + 1
// 고로, 3n^2 - 3n + 1 >= B 의 양의 최솟값을 구하는 근의 공식을 수행한다.
//
// --시간복잡도 : 1
//
// 해결책2. 이진탐색 풀이 (lower bound)
// 위에서 계산된 계차수열 3n^2 - 3n + 1 에 대하여 이진탐색 수행
//
// begin : 시작값. 초기값은 1
// mid : begin과 end를 2로 나눈 값
// end : 끝값. 초기값은 100만
//
// 1. 시작점과 끝점을 설정한다. (B가 10억까지 입력 가능할떄 n의 최대값은 57만 즈음이므로, 100만으로 end설정)
// 2. 탐색에 맞는 방법을 선택한다. -> lower bound. 최초로 일치하는 값 찾기.(사실 중복된 값이 없으므로 그냥 search해도 됨.)
//  - 3n^2 - 3n + 1이 B보다 크거나 같은 최초의 n을 찾아야한다. -> 1 ~ 100만
//  - 시작 1과 end 100만을 더해서 2로 나눈다. -> 50만.
//  - mid를 n에 대입한 n^2 - 3n + 1 값이 B보다 작은경우, n이 너무 작으므로 그 뒤의 범위를 계산해야한다.
//    따라서 begin을 mid + 1로 변경한다. -> (50만 + 1) ~ 100만
//  - 반대로 같거나 작은 경우,이전범위~현재 mid를 탐색해야한다.
//    따라서 end를 mid로 변경하고 이전 범위를 탐색한다. -> 1 ~ 50만
//  - 위 행위를 반복하다가, begin이 end와 같아질때 종료 후 end를 리턴한다.
//
// 복잡도 : log 1000000 : (1/2)^k * n = 1, 2^k = n, k = log n
//
// -- 시간복잡도 = log n
public class Solve2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer beeRoomNum = Integer.parseInt(br.readLine()); // 벌집 위치

        double roomLevel = findMinimumN(beeRoomNum);
        System.out.print((int) roomLevel);
    }

    //이진탐색 풀이 (lower bound) -- 시간복잡도 = log n
    public static double findMinimumN(double B) {
        // 이차방정식의 계수
        // 계차수열 일반항 : 3n^2 - 3n + 1 >= B 이며, n의 최소값.
        final double a = 3;
        final double b = -3;
        final double c = 1 - B;

        int begin = 1;
        int end = 1000000; // B가 10억 이하일 때 n의 최대값은 577350

        while (begin < end) {
            int mid = (begin + end) / 2;
             // System.out.println(a * Math.pow(mid, 2) - 3 * mid + 1 + "  begin : " + begin + " mid : " + mid + " end : " + end );
            if (a * Math.pow(mid, 2) - 3 * mid + 1 < B) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}

// 풀이 2. 계차수열 이차방정식 풀이 --시간복잡도 : 1
//public static double findMinimumN(double B) {
//    // 이차방정식의 계수
//    // 계차수열 일반항 : 3n^2 - 3n + 1 >= B 이며, n의 최소값.
//    final double a = 3;
//    final double b = -3;
//    final double c = 1 - B;
//
//    // 판별식 계산
//    double discriminant = b * b - 4 * a * c;
//    // 근의 공식을 사용하여 해를 계산
//    double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
//    double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
//    double answer = 0.0;
//
//    // 양수 해 중 가장 작은 값을 선택하여 반환
//    if(root1 > 0 && root2 > 0){
//        answer = Math.min(root1,root2);
//    } else {
//        answer = Math.max(root1,root2);
//    }
//
//    // 2.1 이런식이면, 다음항으로 넘어간 것이므로 무조건 반올림 해주자.
//    if(answer % 1 != 0){
//        answer = Math.ceil(answer);
//    }
//    return answer;
//}
