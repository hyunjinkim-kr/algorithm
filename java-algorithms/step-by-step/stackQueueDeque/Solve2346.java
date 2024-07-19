package stackQueueDeque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solve2346 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> resultArr;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            Deque<MyPair<Integer, Integer>> dequeArr = new ArrayDeque<>();
            Integer N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                Integer num = Integer.parseInt(st.nextToken());
                MyPair<Integer, Integer> pair1 = MyPair.of(i, num);
                dequeArr.add(pair1);
            }

            resultArr = getTrdNum(dequeArr);
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(String.join(" ", resultArr));
        }

    }

    public static ArrayList<String> getTrdNum(Deque<MyPair<Integer, Integer>> dequeArr)  {
        ArrayList<String> resultArr = new ArrayList<>();

        Integer start = 1;
        while (!dequeArr.isEmpty()) {
            Integer goNum = start;
            if(goNum > 0){
                for (int i = 1; i <= goNum; i++) {
                    Integer num = dequeArr.peek().getSecond();
                    Integer idx = dequeArr.peek().getFirst();
                    if (i == goNum) {
                        dequeArr.removeFirst();
                        resultArr.add(String.valueOf(idx));
                        start = num;
                    } else {
                        //MyPair<Integer, Integer> pair1 = MyPair.of(idx, num);
                        dequeArr.addLast(dequeArr.removeFirst());
                    }
                }
            } else {
                for (int i = 1; i <= -goNum; i++) {
                    Integer num = dequeArr.peekLast().getSecond();
                    Integer idx = dequeArr.peekLast().getFirst();

                    if (i == -goNum) {
                        dequeArr.removeLast();
                        resultArr.add(String.valueOf(idx));
                        start = num;
                    } else {
                        //MyPair<Integer, Integer> pair1 = MyPair.of(idx, num);
                        dequeArr.addFirst(dequeArr.removeLast());
                    }
                }
            }

        }
        return resultArr;
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
