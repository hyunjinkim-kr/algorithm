package binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solve1920 {
  // 문제 : 수 찾기

  // 해결책 : 주어진 수를 set에 저장하고, 찾을 수를 탐색한다.
  //
  // N : 숫자를 찾을 배열의 길이
  // chkArr : N개 숫자가 저장된 ArrayList
  // M : 탐색할 숫자의 개수
  // targetArr : M번 입력된 탐색할 숫자
  // exists() : hashSet을 이용하여 chkArr에 targetArr의 숫자가 있는지 체크할 함수
  // set : chkArr의 값을 담을 hashSet
  // resultArr : exists()의 결과로 리턴될 Boolean ArrayList
  //
  //  1. N과 N번 입력받은 숫자를 chkArr 에 저장한다.
  //  2. M과 M번 입력받은 숫자를 targetArr 에 저장한다.
  //  3. exists() 함수에 chkArr과 targetArr을 통해 탐색한다.
  //   3-1. chkArr의 값을 set에 저장한다.
  //   3-2. targetArr 값이 set에 존재하는지 결과를 resultArr에 담는다.
  //  4. resultArr을 출력한다.
  //
  // -- 시간복잡도 O(1)
  public static void main(String[] args) throws IOException {
    try (InputStreamReader isr = new InputStreamReader(System.in);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw)) {

      Integer n = Integer.parseInt(br.readLine());
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      ArrayList<Integer> chkArr = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        chkArr.add(Integer.parseInt(st1.nextToken()));
      }

      Integer m = Integer.parseInt(br.readLine());
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      ArrayList<Integer> targetArr = new ArrayList<>();
      for (int j = 0; j < m; j++) {
        targetArr.add(Integer.parseInt(st2.nextToken()));
      }

      for (Boolean result : exists(chkArr, targetArr)) {
        bw.write((result ? 1 : 0) + "\n");
      }
    }
  }

  public static ArrayList<Boolean> exists(ArrayList<Integer> chkArr, ArrayList<Integer> targetArr) {
    HashSet<Integer> set = new HashSet(chkArr);
    ArrayList<Boolean> resultArr = new ArrayList<>();
    for (Integer target : targetArr) {
      resultArr.add(set.contains(target));
    }
    return resultArr;
  }
}
