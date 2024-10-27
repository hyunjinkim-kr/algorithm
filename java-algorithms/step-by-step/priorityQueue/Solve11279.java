package priorityQueue;

import java.io.*;
import java.util.*;

public class Solve11279 {
  // 문제 : 최대 힙

  // 해결책 : 숫자가 입력되면 우선순위 큐에 저장하고, 0인경우 최대값을 출력한다.(값이 없으면 0출력)
  //
  // N : 입력받는 숫자의 개수
  // arr1 : 입력받은 N개 숫자가 저장되는 배열
  // solve : arr1을 우선순위 큐로 처리하여 결과를 리턴하는 함수.
  // pq1 : 0을 제외한 arr1의 숫자가 저장될 우선순위 큐.
  // pollNum : pq1에서 poll 한 값. 가장 큰 값에 해당한다.
  // resultArr : arr1 입력에 따라 출력된 결과가 저장될 배열.
  //
  //  1. N과 N번 만큼의 숫자를 입력받고, arr1에 저장한다.
  //  2. arr1을 파라미터로 하여 solve 함수를 수행한다.
  //   2-1. 내림차순 pq1을 생성한다.
  //   2-2. arr1의 숫자를 순서대로 체크하며 pq1과 resultArr에 저장한다.
  //     case1 0인경우 : pq1을 poll한 값을 resultArr에 저장한다. 단, pq1이 비었을때는 0을 저장한다.
  //     case2 자연수인 경우 : pq1에 값을 저장한다.
  //  3. 리턴된 resultArr을 출력한다.
  //
  //
  // -- 시간복잡도 O(NlogN) >> 우선순위 큐의 poll과 삽입 연산은 logN, N * logN
  public static void main(String[] args) throws IOException {
    ArrayList<String> resultArr;
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
      bw.write(String.join("\n", resultArr));
    }
  }

  public static ArrayList<String> solve(ArrayList<Integer> arr1) {
    ArrayList<String> resultArr = new ArrayList<>();
    PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < arr1.size(); i++) {
      Integer num = arr1.get(i);
      if (num.equals(0)) {
        Integer pollNum = pq1.poll();
        if(pollNum == null){
          pollNum = 0;
        }
        resultArr.add(String.valueOf(pollNum));
      }else{
        pq1.add(num);
      }
    }
    return resultArr;
  }
}
