package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solve10814 {
    public static void main(String[] args) throws IOException {
        // 문제 : 나이순 정렬
        // 해결책 : 나이와 이름을 받고, 나이순으로만 정렬
        //
        // N : 이름과 나이 짝의 개수
        //
        // 1. 나이와 이름을 입력받는다.
        // -- 복잡도 : N
        // 2. 나이순으로 정렬한다.
        // -- 복잡도 : NlogN
        // 3. 출력한다.
        // -- 복잡도 : N
        //
        // -- 시간복잡도 : O(N)

        ArrayList<MyPair3<Integer, String>> peopleArr = new ArrayList<>();

        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            try (BufferedReader br = new BufferedReader(isr)) {
                // Logic 구현부
                Integer peopleCnt = Integer.parseInt(br.readLine());

                for (int i = 0; i < peopleCnt; i++) {
                    String rowInfo = br.readLine();
                    StringTokenizer st = new StringTokenizer(rowInfo);

                    Integer age = Integer.parseInt(st.nextToken());
                    String name = st.nextToken();

                    MyPair3<Integer, String> mp = MyPair3.of(age, name);
                    peopleArr.add(mp);
                }
                peopleArr.sort(Comparator.comparing((MyPair3<Integer, String> list) -> list.getFirst(), Comparator.naturalOrder()));
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 0; i < peopleArr.size(); i++) {
                bw.write(peopleArr.get(i).getFirst() + " " + peopleArr.get(i).getSecond() + "\n");
            }
        }
    }
}

class MyPair3<T, U> {
    private T first;
    private U second;

    public MyPair3(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static <T, U> MyPair3<T, U> of(T first, U second) {
        return new MyPair3<>(first, second);
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