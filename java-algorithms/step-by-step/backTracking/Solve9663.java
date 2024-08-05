package backTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Solve9663 {
    public static void main(String[] args) throws IOException {
        AtomicInteger result = new AtomicInteger(0);
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            // 입력 수
            Integer n = Integer.parseInt(br.readLine());
            // 재귀 수행
            solve(result, new ArrayList<>(),new ArrayList<>(), n, n, 1);
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }

    public static void solve(AtomicInteger result,
                             ArrayList<Integer> accX,
                             ArrayList<Integer> accY,
                             Integer n,
                             Integer m,
                             Integer startX) {

        if (m.equals(0)) {
            result.incrementAndGet(); // 결과값을 1 증가
            return;
        }
        for (int i = startX; i <= n; i++) {
            if (accX.contains(i)){
                continue;
            }
            for (int j = 1; j <= n; j++) {
                if (accY.contains(j)){
                    continue;
                }
                if (!isSafe(accX,accY,i,j)) {
                    continue;
                }

                accX.add(i);
                accY.add(j);
                solve(result, accX,accY, n, m - 1, i);
                accX.remove(accX.size() - 1); // 재귀 호출이 끝난 후, 리스트에서 마지막 추가된 요소 제거
                accY.remove(accY.size() - 1); // 재귀 호출이 끝난 후, 리스트에서 마지막 추가된 요소 제거
            }
        }
    }

    public static boolean isSafe(ArrayList<Integer> accX,
                                 ArrayList<Integer> accY,
                                 Integer newX,
                                 Integer newY){
        for(int i = 0; i < accX.size(); i++){
            Integer absX = Math.abs(newX - accX.get(i));
            Integer absY = Math.abs(newY - accY.get(i));

            if(absX.equals(absY)){
                return false;
            }
        }
        return true;
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