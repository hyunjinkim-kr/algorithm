package bruteForce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solve2798 {
    public static void main(String[] args) throws IOException {
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

        Scanner scan = new Scanner(System.in);
        Integer N = scan.nextInt(); // 카드의 개수
        Integer M = scan.nextInt(); // 목표 숫자

        ArrayList<Integer> cardList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Integer newCard = scan.nextInt();
            cardList.add(newCard);
        }

        Integer resultTot = getResultTot(cardList, M);
        System.out.print(resultTot);
    }

    public static Integer getResultTot(ArrayList<Integer> cardList, Integer M) {

        Integer resultTot = 0;

        for (int i = 0; i < cardList.size(); i++) {
            for (int j = 0; j < cardList.size(); j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < cardList.size(); k++) {
                    if (j == k || i == k) {
                        continue;
                    }

                    Integer cardTot = cardList.get(i) + cardList.get(j) + cardList.get(k);
                    if (cardTot.equals(M)) {
                        resultTot = cardTot;
                        return resultTot;
                    }

                    if (cardTot < M && resultTot <= cardTot) {
                        resultTot = cardTot;
                    }
                }
            }
        }
        return resultTot;
    }
}
