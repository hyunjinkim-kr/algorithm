package priorityQueue;

import java.io.*;
import java.util.*;

public class Solve11279 {
  // 문제 : 최대 힙

  // 해결책 : 숫자가 입력되면 우선순위 큐에 저장하고, 0인경우 최대값을 출력한다.(값이 없으면 0출력)
  //
  // N : 입력받는 숫자의 개수
  // arr1 : 입력받은 N개 숫자가 저장되는 배열
  // solve : arr1의 값과 우선순위 큐 pq1에 대한 addOrPoll의 결과를 리턴하는 함수.
  // addOrPoll : 우선순위 큐에 arr1의 poll 혹은 add 를 하여 결과를 리턴하는 함수.
  // pq1 : 0을 제외한 arr1의 숫자가 저장될 우선순위 큐. (단, add가 될때는 -1을 저장해둔다)
  // pollNum : pq1에서 poll 한 값. 가장 큰 값에 해당한다.
  // resultArr : arr1 입력에 따라 출력된 결과가 저장될 배열.
  //
  //  1. N과 N번 만큼의 숫자를 입력받고, arr1에 저장한다.
  //  2. arr1을 파라미터로 하여 solve 함수를 수행한다.
  //   2-1. 내림차순 pq1을 생성한다.
  //   2-2. pq1 우선순위 큐와 arr1의 숫자를 순서대로 파라미터로하여 addOrPoll 함수를 수행한다. 리턴된 값은 resultArr에 저장된다.
  //     case1 0인경우 : pq1을 poll한 값을 리턴한다. 단, pq1이 비었을때는 0을 리턴한다.
  //     case2 자연수인 경우 : pq1에 값을 저장한다. -1을 리턴한다.
  //   2-3. -1 이외의 값을 resultArr에 저장하고 리턴한다.
  //  3. 리턴된 resultArr을 출력한다.
  //
  //
  // -- 시간복잡도 O(NlogN) >> 우선순위 큐의 poll과 삽입 연산은 logN, N * logN
  public static void main(String[] args) throws IOException {
    ArrayList<Integer> resultArr;
    try (InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr)) {
      Integer n = Integer.parseInt(br.readLine());
      ArrayList<Integer> arr1 = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        Integer num = Integer.parseInt(br.readLine());
        arr1.add(num);
      }
      resultArr = solve(arr1);
    }
    try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw)) {
      for (Integer result : resultArr) {
        bw.write(result + "\n");
      }
    }
  }

  public static ArrayList<Integer> solve(ArrayList<Integer> arr1) {
    ArrayList<Integer> resultArr = new ArrayList<>();
    PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < arr1.size(); i++) {
      Integer num = arr1.get(i);
      Integer result = addOrPoll(pq1, num);
      if (!result.equals(-1)) {
        resultArr.add(result);
      }
    }
    return resultArr;
  }

  public static Integer addOrPoll(PriorityQueue<Integer> pq1, Integer num) {
    if (num.equals(0)) {
      Integer pollNum = pq1.poll();
      if (pollNum == null) {
        pollNum = 0;
      }
      return pollNum;
    } else {
      pq1.add(num);
      return -1;
    }
  }
}
