package advanced2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//문제 : 약수
//해결책 : 입력받은 약수를 정렬한 후, 가장 작은수와 큰수를 곱한다.
//
// N : 구해야하는 수
// A : 1과 N이 아닌 약수
// T : N에 대한 A의 개수
//
// - 1. T를 입력받는다.
//
// - 2. A를 T만큼 입력받으며, 각각 배열에 저장한다.
//        -- 복잡도 : T
//
// - 3. A가 저장된 T길이의 배열을 정렬한다.
//        -- 복잡도 : TlogT
//
// - 4. 배열의 맨앞과 맨뒤의 값을 곱한다.
// ** 수정 : 정렬하지않고, 숫자입력시 min 과 max를 초기화 하자.
//
//시간복잡도 : NlogN

public class Solve1037 {
    public static void main(String[] args) throws IOException {
        Integer result;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            // 입력 수
            Integer T = Integer.parseInt(br.readLine());
            // ArrayList<Integer> numList = new ArrayList<>();
            Integer minNum = 1000000;
            Integer maxNum = 2;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < T; i++) {
                Integer A = Integer.parseInt(st.nextToken());
                //numList.add(A);
                minNum = Math.min(minNum,A);
                maxNum = Math.max(maxNum,A);
            }

//            Collections.sort(numList);
//            result = numList.get(0) * numList.get(numList.size()-1);
            result = minNum * maxNum;
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }
}
