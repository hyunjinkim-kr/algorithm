package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solve11650 {
    public static void main(String[] args) throws IOException {
        // 문제 : 좌표 정렬하기
        // 해결책 : pair 형태의 배열만들고 각각원소에 대해 오름차순 정렬수행.
        //
        // N : 입력받은 좌표 개수
        // arr : pair 형태의 배열
        //
        // 1. 좌표가 입력되면 pair 형태로 배열에 저장한다.
        // -- 복잡도 : N
        // 2. 배열을 각 원소에대하여 오름차순으로 정렬한다.
        // -- 복잡도 : 2*NlogN
        // 3. 배열을 출력한다.
        // -- 복잡도 : N
        //
        // 시간복잡도 : 2N + 2*NlogN
        // O(NlogN)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer coordCnt = Integer.parseInt(br.readLine());
        ArrayList<MyPair<Integer, Integer>> coordArr = new ArrayList<>();

        for (int i = 0; i < coordCnt; i++) {
            String rowInfo = br.readLine();
            StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");

            Integer x = Integer.valueOf(stRowInfo.nextToken());
            Integer y = Integer.valueOf(stRowInfo.nextToken());

            MyPair<Integer, Integer> pair1 = MyPair.of(x, y);
            coordArr.add(pair1);
        }
        br.close();

        coordArr.sort(Comparator.comparing((MyPair<Integer, Integer> list) -> list.getFirst(), Comparator.naturalOrder())
                .thenComparing((MyPair<Integer, Integer> list1, MyPair<Integer, Integer> list2) -> list1.getSecond().compareTo(list2.getSecond())));


        for (int i = 0; i < coordArr.size(); i++) {
            bw.write(coordArr.get(i).getFirst() + " " + coordArr.get(i).getSecond() + "\n");
        }
        bw.flush();
        bw.close();
    }
}


class MyPair<T, U> {
    private T first;
    private U second;

    public MyPair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static <T, U> MyPair<T, U> of(T first, U second) {
        return new MyPair<>(first, second);
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
