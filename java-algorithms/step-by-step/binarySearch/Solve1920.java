package binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solve1920 {
  // 문제 : 수 찾기

  // 해결책 : 주어진 범위의 배열을 정렬한 후, 찾을 수를 배열에서 이진탐색을 통해 검색한다.
  //
  // N : 숫자를 찾을 배열의 길이
  // arr1 : N개의 숫자가 저장된 배열
  // M : 탐색할 숫자의 개수
  // target : M번 입력중 배열에 있는지 체크할 숫자
  // resultArr : M번 주어진 숫자가 N배열에 있는지 1과 0으로 저장된 배열
  // start : arr1을 탐색할 시작 범위
  // end : arr1을 탐색할 끝 범위
  // mid : start 와 end를 더하고 2로 나눈 값
  //
  //  1. N과 N번 입력받은 숫자를 arr1에 저장한다.
  //  2. arr1을 정렬한다.
  //    복잡도 : N log N
  //  3. M을 입력받고, M번 숫자를 입력받으며 각각 arr1에 존재하는지 체크하고 저장한다.
  //    3-1. start 를 0, end를 arr1의 크기로 탐색을 시작한다.
  //    3-2. start 가 end보다 큰 경우, 0을 반환한다(범위 벗어남, target 없음)
  //    3-3. arr1의 mid 값이 target과 일치하면 1을 반환한다.
  //    3-4. arr1의 mid 값이 target 보다 큰 경우, start ~ mid -1 범위로 재귀한다.
  //    3-5. " 작은경우, mid + 1 ~ end 범위로 재귀한다.
  //   복잡도 : log N
  //
  // -- 시간복잡도 O(NlogN)
  public static void main(String[] args) throws IOException {
    ArrayList<String> resultArr = new ArrayList();
    try (InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr)) {
      // 처음 입력받자.
      ArrayList<Integer> arr1 = new ArrayList();
      Integer n = Integer.parseInt(br.readLine());
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        arr1.add(Integer.parseInt(st1.nextToken()));
      }
      // 정렬된 배열에 대해서만 이진탐색 가능하므로 정렬함.
      Collections.sort(arr1);

      Integer n2 = Integer.parseInt(br.readLine());
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for (int j = 0; j < n2; j++) {
        Integer target = Integer.parseInt(st2.nextToken());
        resultArr.add(solve(arr1, 0, arr1.size() - 1, target));
      }
    }
    try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw)) {
      bw.write(String.join("\n", resultArr));
    }
  }

  public static String solve(
      ArrayList<Integer> chkArr, Integer start, Integer end, Integer target) {
    if (start > end) {
      return "0";
    }
    Integer mid = (start + end) / 2;
    Integer chkNum = chkArr.get(mid);
    if (chkNum.equals(target)) {
      return "1";
    } else if (chkNum > target) {
      return solve(chkArr, start, mid - 1, target);
    } else return solve(chkArr, mid + 1, end, target);
  }
}
