package sort;

import java.io.*;
import java.util.*;

public class Solve18870 {
    public static void main(String[] args) throws IOException {
        // 문제 : 좌표 압축
        // 해결책 : 입력받은 숫자에 대하여 오름차순으로 정렬한 후, 정렬된 순서를 입력받은 순서대로 출력한다.
        //
        // N : 입력받은 숫자의 개수
        // C : 숫자 두개를 받는 pair 리스트
        //  -- n1 : 입력받은 순서
        //  -- n2 : 입력받은 숫자
        // R : 입력받은 순서와 정렬된 순서를 가지는 pair 결과 리스트
        //  -- n1' : 입력받은 순서 (n1과 동일)
        //  -- n2' : 정렬된 순서
        //
        // 1. 숫자를 입력받는다.
        // 2. 배열 C에 입력받은 순서와 숫자 n1,n2 를 각각 넣는다.
        // -- 복잡도 : N
        // 3. 배열 C를 입력받은 숫자 n2 에 따라 오름차순으로 정렬한다.
        // -- 복잡도 : NlogN
        // 4. n2가 정렬된 순서에따라 R 의 n1' 과 n2' 를 설정한다.
        //  -- n1 과 n1'은 같으므로, 키값역할을 한다.
        //  -- 단, n2가 같을때는 n2'는 증가하지 않는다.
        // -- 복잡도 : N
        // 5. 출력
        // -- 복잡도 : N
        //
        // -- 시간복잡도 : O(NlogN)

        ArrayList<MyTuple2<Integer, Integer>> coordArr = new ArrayList<>();
        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            try (BufferedReader br = new BufferedReader(isr)) {
                // Logic 구현부
                Integer coordCnt = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int i = 0; i < coordCnt; i++) {
                    Integer coord = Integer.parseInt(st.nextToken());
                    MyTuple2<Integer, Integer> mp = MyTuple2.of(i, coord);
                    coordArr.add(mp);
                }
            }
        }
        // 입력받은 숫자순으로 정렬
        coordArr.sort(Comparator.comparing((MyTuple2<Integer, Integer> list) -> list.getSecond(), Comparator.naturalOrder()));

        Integer count = 0;
        ArrayList<Integer> ResultArr = new ArrayList<>(Collections.nCopies(coordArr.size(), 0));
        ResultArr.set(coordArr.get(0).getFirst(), count);

        for (int i = 1; i < coordArr.size(); i++) {
            MyTuple2<Integer, Integer> mp = coordArr.get(i - 1);
            if (mp.getSecond().equals(coordArr.get(i).getSecond())) {
                ResultArr.set(coordArr.get(i).getFirst(), count);
                continue;
            }
            count++;
            ResultArr.set(coordArr.get(i).getFirst(), count);
        }

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            try (BufferedWriter bw = new BufferedWriter(osw)) {
                for (int i = 0; i < coordArr.size(); i++) {
                    // 정렬된 순서 출력
                    bw.write(ResultArr.get(i) + " ");
                }
            }
        }
    }
}

class MyTuple2<T, U> {
    private T first;
    private U second;

    public MyTuple2(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static <T, U> MyTuple2<T, U> of(T first, U second) {
        return new MyTuple2<>(first, second);
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
//
//class MyTuple<T, U, X> {
//    private T first;
//    private U second;
//
//    private X third;
//
//    public MyTuple(T first, U second, X third) {
//        this.first = first;
//        this.second = second;
//        this.third = third;
//    }
//
//    public static <T, U, X> MyTuple<T, U, X> of(T first, U second, X third) {
//        return new MyTuple<>(first, second, third);
//    }
//
//    public T getFirst() {
//        return first;
//    }
//
//    public U getSecond() {
//        return second;
//    }
//
//    public X getThird() {
//        return third;
//    }
//
//    public void setFirst(T first) {
//        this.first = first;
//    }
//
//    public void setSecond(U second) {
//        this.second = second;
//    }
//
//    public void setThird(X third) {
//        this.third = third;
//    }
//
//    @Override
//    public String toString() {
//        return "(" + first + ", " + second + ", " + third + ")";
//    }
//}