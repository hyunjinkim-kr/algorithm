package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solve11651 {
    public static void main(String[] args) throws IOException {
        // 문제 : 좌표 정렬하기2
        // 해결책 : pair 형태의 배열만들고 각각원소에 대해 오름차순 정렬수행.
        //
        // N : 입력받은 좌표 개수
        // arr : pair 형태의 배열
        //
        // 1. 좌표가 입력되면 pair 형태로 배열에 저장한다.
        // -- 복잡도 : N
        // 2. 배열을 각 원소에대하여 오름차순으로 정렬한다. (11650과 비교하는 순서만 바꿔준다.)
        // -- 복잡도 : 2*NlogN
        // 3. 배열을 출력한다.
        // -- 복잡도 : N
        //
        // 시간복잡도 : 2N + 2*NlogN
        // O(NlogN)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer coordCnt = Integer.parseInt(br.readLine());
        ArrayList<MyPair2<Integer, Integer>> coordArr = new ArrayList<>();

        for (int i = 0; i < coordCnt; i++) {
            String rowInfo = br.readLine();
            StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");

            Integer x = Integer.valueOf(stRowInfo.nextToken());
            Integer y = Integer.valueOf(stRowInfo.nextToken());

            MyPair2<Integer, Integer> pair1 = MyPair2.of(x, y);
            coordArr.add(pair1);
        }
        br.close();

        coordArr.sort(Comparator.comparing((MyPair2<Integer, Integer> list) -> list.getSecond(), Comparator.naturalOrder())
                .thenComparing((MyPair2<Integer, Integer> list1, MyPair2<Integer, Integer> list2) -> list1.getFirst().compareTo(list2.getFirst())));


        for (int i = 0; i < coordArr.size(); i++) {
            bw.write(coordArr.get(i).getFirst() + " " + coordArr.get(i).getSecond() + "\n");
        }
        bw.flush();
        bw.close();
    }
}

class MyPair2<T, U> {
    private T first;
    private U second;

    public MyPair2(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static <T, U> MyPair2<T, U> of(T first, U second) {
        return new MyPair2<>(first, second);
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