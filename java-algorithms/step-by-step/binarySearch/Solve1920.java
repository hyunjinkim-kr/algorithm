package binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solve1920 {
  // 문제 : 수 찾기

  // 해결책 : 주어진 범위의 수를 저장한 후, 찾을 수를 검색한다.
  //
  // N : 숫자를 찾을 배열의 길이
  // set : N개의 숫자가 저장된 HashSet
  // M : 탐색할 숫자의 개수
  // target : M번 입력중 배열에 있는지 체크할 숫자
  // resultArr : M번 주어진 숫자가 N배열에 있는지 1과 0으로 저장된 배열
  //
  //  1. N과 N번 입력받은 숫자를 set에 저장한다.
  //  2. M을 입력받고, M번 숫자를 입력받으며 각각 set에 존재하는지 체크하고 저장한다.
  //    2-1. target이 Set에 존재하면 1, 존재하지 않으면 0을 저장한다.
  //
  // -- 시간복잡도 O(1)
  public static void main(String[] args) throws IOException {
    ArrayList<String> resultArr = new ArrayList();
    try (InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr)) {
      // 처음 입력받자.
      HashSet<Integer> set = new HashSet();
      Integer n = Integer.parseInt(br.readLine());
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        set.add(Integer.parseInt(st1.nextToken()));
      }

      Integer n2 = Integer.parseInt(br.readLine());
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for (int j = 0; j < n2; j++) {
        Integer target = Integer.parseInt(st2.nextToken());
        resultArr.add(solve(set, target));
      }
    }
    try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw)) {
      bw.write(String.join("\n", resultArr));
    }
  }

  public static String solve(HashSet<Integer> chkSet, Integer target) {
    if (chkSet.contains(target)) {
      return "1";
    } else return "0";
  }
}
