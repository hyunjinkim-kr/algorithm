package stackQueueDeque;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solve2164 {
    // 문제 : 카드2
    //
    // 해결책 : LinkedList 를 이용해 "그대로" 시뮬을 돌린다......
    //
    // N : 입력되는 카드의 개수
    // arr1 : 입력되는 명령에 따라 수정되는 리스트
    //
    //
    //  1. N개 카드를 입력받고, arr1에 저장한다.
    //  -- 복잡도 : N
    //  2. 배열 arr1의 길이가 1이 될때까지 다음 행위를 반복한 후 마지막 값을 출력한다.
    //     a) 맨앞의 카드를 버리고,
    //     b) 그 다음 카드를 삭제후
    //     c) 맨뒤에 저장하는 행위를 N번 반복한다.
    //   ** N개일 경우, 한번에 상태 3번을 수행하는것을 N의 등차수열의 합만큼 수행.
    //  -- 복잡도 : 3 * (N^2 + N) / 2
    //
    // 복잡도 : N^2
    // 시간복잡도 : O(N^2)

    public static void main(String[] args) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            Integer cnt = Integer.parseInt(br.readLine());

            LinkedList<Integer> arr1 = new LinkedList<>();

            for (int i = 1; i <= cnt; i++){
                arr1.add(i);
            }

            while (arr1.size()!=1){
                arr1.remove(0);
                int a = arr1.get(0);
                arr1.remove(0);
                arr1.add(arr1.size(),a);
            }
            bw.write(arr1.get(0)+ "");
        }
    }

}
