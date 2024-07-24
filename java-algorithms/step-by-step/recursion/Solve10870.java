package recursion;

import java.io.*;
import java.util.*;

public class Solve10870 {
    // 문제 : 피보나치 수 5

    // 해결책 : 입력받은 숫자만큼 피보나치 수열을 map에 저장하며 재귀한다.
    //
    // N : 입력받은 숫자
    // M : 2~N 까지 피보나치 수열이 입력될 index 값
    // fiboArr : N개의 피보나치 수열이 저장될 Map
    // result : 재귀가 실행될때 리턴되는 값
    //
    // 1. N을 입력받는다.
    //
    // 2. fiboArr 에 0번째와 1번째에 각각 0, 1 을 넣는다.
    //
    // 3. 2부터 N까지 재귀를 수행하며, 피보나치 수열을 M 위치에 넣는다.
    //   복잡도 : N
    // 4. fiboArr 의 크기가 N보다 커지면 (N값이 피보나치수열에 들어오면) 리턴한다.
    //
    // -- 시간복잡도 O(N)
    public static void main(String[] args) throws IOException {
        Integer result;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            Integer N = Integer.parseInt(br.readLine());

            result = fibo(N);
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }

    public static Integer fibo(Integer n) {
        // 싱글톤 인스턴스를 얻음
        FibonacciSingleton fibonacci = FibonacciSingleton.getInstance();
        return fiboHelper(n, fibonacci);
    }

    private static Integer fiboHelper(Integer n, FibonacciSingleton fibonacci) {

        ArrayList<Integer> fiboArr = fibonacci.getFiboArr();
        if (fiboArr.size() > n) {
            return fiboArr.get(n);
        }
        Integer result = fiboHelper(n-1,fibonacci) + fiboHelper(n-2,fibonacci);
        fiboArr.add(result);
        return result;
    }
}

class FibonacciSingleton {
    private static FibonacciSingleton instance;
    private ArrayList<Integer> fiboArr;

    public ArrayList<Integer> getFiboArr() {
        return fiboArr;
    }

    // private 생성자를 사용하여 외부에서 인스턴스 생성을 막음
    private FibonacciSingleton() {
        fiboArr = new ArrayList<>();
        fiboArr.add(0); // F(0)
        fiboArr.add(1); // F(1)
    }

    // 싱글톤 인스턴스를 반환하는 메서드
    public static synchronized FibonacciSingleton getInstance() {
        if (instance == null) {
            instance = new FibonacciSingleton();
        }
        return instance;
    }
}
