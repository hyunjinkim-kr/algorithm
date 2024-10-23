package binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solve1920 {
  // 문제 : 수 찾기

  // 해결책 : 주어진 범위의 수를 입력받은 후, 찾을 수를 검색한다.
  //
  // N : 숫자를 찾을 배열의 길이
  // st1 : N개 숫자토큰을 가진 객체
  // M : 탐색할 숫자의 개수
  // target : M번 입력중 배열에 있는지 체크할 숫자
  // resultArr : M번 주어진 숫자가 N배열에 있는지 1과 0으로 저장된 배열
  //
  //  1. N을 입력받고, N개 수를 가진 줄을 st1객체에 입력한다.
  //  2. M을 입력받고, M번 숫자를 입력받으며 각각 st1에 존재하는지 체크하고 저장한다.
  //    2-1. target이 st1에 존재하면 1, 존재하지 않으면 0을 저장한다.
  //
  // -- 시간복잡도 O(M * N)
  public static void main(String[] args) throws IOException {
    ArrayList<String> resultArr = new ArrayList();
    try (InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr)) {
      Integer n = Integer.parseInt(br.readLine());
      StringTokenizer st1 = new StringTokenizer(br.readLine());

      Integer n2 = Integer.parseInt(br.readLine());
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for (int j = 0; j < n2; j++) {
        Integer target = Integer.parseInt(st2.nextToken());
        resultArr.add(solve(st1, n, target));
      }
    }
    try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw)) {
      bw.write(String.join("\n", resultArr));
    }
  }

  public static String solve(StringTokenizer st1, Integer n, Integer target) {
    for (int i = 0; i < n; i++) {
      Integer chkNum = Integer.parseInt(st1.nextToken());
      if (chkNum.equals(target)) {
        return "1";
      }
    }
    return "0";
  }
}
