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
  // pq1 : 0을 제외한 arr1의 숫자가 저장될 우선순위 큐.
  // resultArr : arr1 입력에 따라 출력된 결과가 저장될 배열.
  // Command : 명령의 타입과 숫자를 정의하는 클래스
  //
  //  1. N과 N번 만큼의 숫자를 입력받고, arr1에 저장한다.
  //  2. arr1을 파라미터로 하여 solve 함수를 수행한다.
  //   2-1. 내림차순 pq1을 생성한다.
  //   2-2. pq1 우선순위 큐와 arr1의 숫자(0인경우 null로 변환하여)를 순서대로 파라미터로하여 addOrPoll 함수를 수행한다. 리턴된 값은
  // resultArr에 저장된다.
  //     case1 null 인경우 : pq1을 poll한 값을 리턴한다. 단, pq1이 비었을때는 0을 리턴한다.
  //     case2 자연수 인 경우 : pq1에 값을 저장한다. Optional.empty를 리턴한다.
  //   2-3. 리턴된 값이 있으면, resultArr에 저장하고 리턴한다.
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
      Optional<Integer> command = Optional.ofNullable((num == 0) ? null : num);
      Optional<Integer> result;

      result = addOrPoll(pq1, command);
      result.ifPresent(value -> resultArr.add(value));
    }
    return resultArr;
  }

  public static Optional<Integer> addOrPoll(PriorityQueue<Integer> pq1, Optional<Integer> command) {

    if (command.isPresent()) {
      pq1.add(command.get());
      return Optional.empty();
    }
    Integer removed = pq1.poll();
    return Optional.of((removed != null) ? removed : 0);
  }
}
