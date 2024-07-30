package recursion;

import java.io.*;
import java.util.ArrayList;

public class Solve11729 {
    // 문제 : 하노이 탑 이동 순서

    // 해결책 : 원판이 움직이는 단위를 하나씩 쪼갠다. 시작,도착,경유 위치를 설정하며 재귀한다.
    //
    // N : 원판의 개수
    // hanoi : 원판 위치 저장 함수
    // from : 시작위치
    // to : 도착위치
    // mid : 경유지
    //
    //  1. N개의 원판을 다음과 같이 설정하여 이동한다.
    //   초기의 N개 원판집합을 1에서 3으로 이동한다 (경유지 : 2)
    //   from : 1
    //   to : 3
    //   mid : 2
    //
    //  2. 원판집합을 (N) 이라고 할떄, 다음과 같이 재귀한다.
    //  hanoi(N,from,to,mid) ->
    //   (N-1, from,mid,to) : N-1 집합은 경유지를 향해 모두 움직여야한다.
    //   (1 ,from,to,mid) : from 위치에 남아있는 큰 값을 목적지로 옮긴다.
    //   (N-1, mid,to,from) : 경유지에 있는 N-1집합을 from을 경유지로 to로 옮긴다.
    //
    // 복잡도 : 2^N - 1
    //
    //  3. N이 1이 될때마다 from과 to 위치를 저장한 후 재귀를 멈춘다. 최종적으로 저장된 모든 위치를 출력한다.
    //
    // -- 시간복잡도 O(2^N)
    public static void main(String[] args) throws IOException {
        ArrayList<String> resultArr;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw);
        ) {
            Integer N = Integer.parseInt(br.readLine());
            resultArr = hanoi(N);

            bw.write(resultArr.size() + "\n");
            for (int i = 0; i < resultArr.size(); i++) {
                bw.write(resultArr.get(i) + "\n");
            }
        }
    }

    public static ArrayList<String> hanoi(Integer N) {
        ArrayList<String> resultArr = new ArrayList<>();
        Integer from = 1;
        Integer to = 3;
        Integer mid = 2;

        hanoiHelper(resultArr, N, from, to, mid);
        return resultArr;
    }

    public static void hanoiHelper(ArrayList<String> resultArr,
                                                Integer N ,
                                                Integer from,
                                                Integer to,
                                                Integer mid) {
        if(N <= 0){
            return;
        }
        hanoiHelper(resultArr,N-1,from,mid,to);
        resultArr.add(from + " " + to);
        hanoiHelper(resultArr,N-1,mid,to,from);
    }
}

// 매턴마다 '어떤 링'을 '어디서 어디로' 옮겼는지를 출력해보자.
// 3: A -> B