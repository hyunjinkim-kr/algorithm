package binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solve1920 {
  // 문제 : 수 찾기

  // 해결책 : 주어진 수를 set에 저장하고, 찾을 수를 탐색한다.
  //
  // N : 숫자를 찾을 배열의 길이
  // set : N개의 숫자가 저장된 HashSet
  // M : 탐색할 숫자의 개수
  // target : M번 입력중 배열에 있는지 체크할 숫자
  // resultArr : M번 주어진 숫자가 N배열에 있는지 true와 false로 저장된 배열
  // convertedArr : resultArr의 true와 false를 1과 0으로 변환한 배열
  //
  //  1. N과 N번 입력받은 숫자를 set에 저장한다.
  //  2. M을 입력받고, M번 숫자를 입력받으며 각각 set에 존재하는지 체크하고 저장한다.
  //    2-1. target이 Set에 존재하면 true, 존재하지 않으면 false을 저장한다.
  //  3. resultArr을 1과 0으로 변환하여 출력한다.
  //
  // -- 시간복잡도 O(1)
  public static void main(String[] args) throws IOException {
    try (InputStreamReader isr = new InputStreamReader(System.in);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw)) {
      // 처음 입력받자.
      HashSet<Integer> set = new HashSet();
      Integer n = Integer.parseInt(br.readLine());
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        set.add(Integer.parseInt(st1.nextToken()));
      }

      Integer m = Integer.parseInt(br.readLine());
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        Integer target = Integer.parseInt(st2.nextToken());
        bw.write(set.contains(target) ? "1" + "\n": "0" + "\n");
      }
    }
  }
}
