package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solve3009 {
    public static void main(String[] args) throws IOException {
        // 문제 : 네번째 점
        // 해결책 : 점 세개의 위치를 저장해서, 초기 점 위치와 나머지 위치들을 비교하여 정답을 도출한다.
        // 
        // arr1 : 점의 위치 리스트가가 저장되는 2차원 배열
        // arr2 : 점의 위치 x,y가 저장되는 pair 배열
        //
        // 1. 점 세개를 입력받는다.
        // 2. 각각을 arr2에 저장한 후, arr1에 저장한다.
        // 3. arr1의 첫번째 값과 두번째, 세번째 값을 비교하며 케이스를 분류한다.
        // -- 복잡도 3
        // -- 공간복잡도 6
        // -- 시간복잡도 O(1)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<MyPair<Integer, Integer>> arr1 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String rowInfo = br.readLine();
            StringTokenizer stRowInfo = new StringTokenizer(rowInfo, " ");

            Integer x = Integer.valueOf(stRowInfo.nextToken());
            Integer y = Integer.valueOf(stRowInfo.nextToken());

            // Pair 사용
            MyPair<Integer, Integer> pair1 = MyPair.of(x, y);
            arr1.add(pair1);
        }

        Integer resX = arr1.get(0).getFirst();
        Integer resY = arr1.get(0).getSecond();

        if (resX.equals(arr1.get(1).getFirst())) {
            resX = arr1.get(2).getFirst();
        } else if(resX.equals(arr1.get(2).getFirst())){
            resX = arr1.get(1).getFirst();
        }

        if (resY.equals(arr1.get(1).getSecond())) {
            resY = arr1.get(2).getSecond();
        } else if(resY.equals(arr1.get(2).getSecond())){
            resY = arr1.get(1).getSecond();
        }
        System.out.print(resX + " " + resY);
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