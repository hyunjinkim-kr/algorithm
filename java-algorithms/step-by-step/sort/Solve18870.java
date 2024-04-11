package sort;

import java.io.*;
import java.util.*;

public class Solve18870 {
    public static void main(String[] args) throws IOException {
        // 문제 : 좌표 압축
        // 해결책 : 입력된 좌표가 몇번째인지 출력하는 방식으로 한다.
        //
        // N : 입력받은 숫자의 개수
        //
        // 1. 숫자를 입력받는다.
        // 2. tuple 배열에 입력받은 순서와 숫자를 각각 1,3번째에 넣는다.
        // -- 복잡도 : N
        // 3. 숫자 오름차순으로 정렬한다.
        // -- 복잡도 : NlogN
        // 4. 정렬된 순서에따라 2번째에 숫자를 넣는다. 단, 이전 숫자와 같은경우 같은 수를 넣는다.
        // -- 복잡도 : N
        // 5. 입력받은 순서로 다시 정렬한다.
        // -- 복잡도 : NlogN
        // 6. 출력
        // -- 복잡도 : N
        //
        // -- 시간복잡도 : O(NlogN)

        ArrayList<MyTuple<Integer, Integer, Integer>> coordArr = new ArrayList<>();

        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            try (BufferedReader br = new BufferedReader(isr)) {
                // Logic 구현부
                Integer coordCnt = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int i = 0; i < coordCnt; i++) {
                    Integer coord = Integer.parseInt(st.nextToken());
                    MyTuple<Integer, Integer, Integer> mp = MyTuple.of(i, 0, coord);
                    coordArr.add(mp);
                }
            }
            // 입력받은 숫자순으로 정렬
            coordArr.sort(Comparator.comparing((MyTuple<Integer, Integer, Integer> list) -> list.getThird(), Comparator.naturalOrder()));

            for (int i = 1; i < coordArr.size(); i++) {
                MyTuple<Integer, Integer, Integer> mt = coordArr.get(i - 1);
                if (mt.getThird().equals(coordArr.get(i).getThird())) {
                    coordArr.get(i).setSecond(mt.getSecond());
                    continue;
                }
                coordArr.get(i).setSecond(mt.getSecond() + 1);
            }
            // 입력받은 순서로 정렬
            coordArr.sort(Comparator.comparing((MyTuple<Integer, Integer, Integer> list) -> list.getFirst(), Comparator.naturalOrder()));
        }

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            try (BufferedWriter bw = new BufferedWriter(osw)) {
                for (int i = 0; i < coordArr.size(); i++) {
                    // 정렬된 순서 출력
                    bw.write(coordArr.get(i).getSecond() + " ");
                }
            }
        }

    }
}

class MyTuple<T, U, X> {
    private T first;
    private U second;

    private X third;

    public MyTuple(T first, U second, X third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static <T, U, X> MyTuple<T, U, X> of(T first, U second, X third) {
        return new MyTuple<>(first, second, third);
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public X getThird() {
        return third;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public void setThird(X third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }
}