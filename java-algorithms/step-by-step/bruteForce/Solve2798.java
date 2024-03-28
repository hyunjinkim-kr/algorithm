package bruteForce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class Solve2798 {
    public static void main(String[] args) throws IOException {
        // 문제 : 블랙잭
        // 해결책 : 재귀함수를 통한 접근법
        //
        // 1. 입력받은 카드들을 리스트에 넣는다.
        // 2. 카드를 찾을때마다 리스트를 한번씩 탐색한다.
        // 3. 이전 카드 위치의 이후부터 다음카드를 뽑는다.
        // 4. 3장의 카드를 뽑았을때, 카드의 합을 저장한다.
        // 5. 카드의 합이 이전 저장된 값보다 클때, 값을 바꾼다.
        //
        // 탐색횟수로 치면, nC3 = n*(n-1)*(n-2)/ 3*2*1
        // (n^3 - 3n^2 + 2n) / 6
        //
        // 시간복잡도 : O(N^3)

        Scanner scan = new Scanner(System.in);
        Integer cardCount = scan.nextInt(); // 카드의 개수
        Integer M = scan.nextInt(); // 목표 숫자

        Integer N = 3; // 뽑을 카드의 갯수

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < cardCount; i++) {
            Integer newCard = scan.nextInt();
            arr.add(newCard);
        }

        Result max = new Result(0);
        // closure
        Function<ArrayList<Integer>, Void> setMax = comb -> {
            Integer sum = 0;
            for (Integer idx: comb) {
                sum += arr.get(idx);
            }
            if (sum > max.value && sum <= M) {
                max.value = sum;
            }
            return null;
        };

        combination(0, arr.size(), N, setMax);
        System.out.print(max.value);
    }

    public static void combination(Integer start,
                              Integer end,
                              Integer N,
                              Function<ArrayList<Integer>, Void> f) {
        combination_inner(start, end, N, f, new ArrayList<>());
    }

    public static void combination_inner(Integer start,
                            Integer end,
                            Integer N,
                            Function<ArrayList<Integer>, Void> f,
                            ArrayList<Integer> acc) {
        if (N == 0) {
            f.apply(acc);
            return;
        }
        
        if (end - start < N) {
            // TODO: 범위 부족 Error
        }

        for (int i = start; i <= end - N; i++) {
            acc.add(i);
            combination_inner(i + 1, end,N - 1, f, acc);
            acc.remove(acc.size() - 1);
        }
    }
}

class Result {
    public Integer value;

    Result(Integer value) {
        // Using wrapper class
        // so as to wrap integer value
        // in mutable object
        // which can be changed or modified
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}


// 문제 : 블랙잭
// 해결책 : 카드리스트 전체에서 세장의 카드합을 찾는다.
//
// 1. 입력받은 카드들을 리스트에 넣는다.
// 2. 카드를 찾을때마다 리스트를 한번씩 탐색한다.
// 3. 단, 이전 리스트에서 확인중인 카드는 확인하지 않고 다음카드로 넘어간다.
// 4. 만약 목표하는 숫자와 일치하는 합이 나올경우, 바로 탐색을 멈춘다.
// 5. 일치하는 합이 나오지 않는경우, 근사값을 업데이트 한 후 반환한다.
//
// 탐색횟수로 치면, nC3 = n*(n-1)*(n-2)/ 3*2*1
// (n^3 - 3n^2 + 2n) / 6
//
// 시간복잡도 : O(N^3)
//        Integer resultTot = 0;
//        for (int i = 0; i < cardList.size(); i++) {
//            for (int j = 0; j < cardList.size(); j++) {
//                if (i == j) {
//                    continue;
//                }
//                for (int k = 0; k < cardList.size(); k++) {
//                    if (j == k || i == k) {
//                        continue;
//                    }
//
//                    Integer cardTot = cardList.get(i) + cardList.get(j) + cardList.get(k);
//                    if (cardTot.equals(M)) {
//                        resultTot = cardTot;
//                        return resultTot;
//                    }
//
//                    if (cardTot < M && resultTot <= cardTot) {
//                        resultTot = cardTot;
//                    }
//                }
//            }
//        }
//        return resultTot;