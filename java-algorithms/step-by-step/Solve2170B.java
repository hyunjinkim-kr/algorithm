import java.io.*;
import java.util.*;

//문제 : 선긋기
// p : 선의 좌표
// isOpen : 선의시작 오픈flag
// N : 선의 개수
// N" : 연달아 선이 오픈된 횟수
// cnt : N"까지 증가하며 오픈상태인 선의 갯수
// prev : 이전좌표
// L : 전체길이
//
// - 1. 입력한 숫자 p와 시작점여부 isOpen을 배열에 추가한다. 이후 p에 따른 오름차순 정렬을 한다.
//      -- 복잡도 : 2N + 2N log N
//
// - 2. 정렬된 배열을 순회하며 계산한다. isOpen에 따라 선이 오픈됨을 알리며, 오픈되는 동안 선의 길이를 계산한다.
//  - 2-1 : N"번 연달아 오픈될 경우 : N"개의 선이 겹쳐지는 경우를 의미하며, 현재좌표에서 이전좌표를 뺀 값들을 각각 전체길이 L에 더한다.
//      e.g) (3,5) (4,6) -> N" = 2 (두개의 선이 겹쳐있음)
//          정렬 : (3,open) (4,open) (5,close) (6,close)
//          수행 1 :         cnt = 1, prev = 3 // open된 횟수 N"만큼 cnt 증가 후 감소하며 계산
//          수행 2 : L += 1, cnt = 2, prev = 4
//          수행 3 : L += 1, cnt = 1, prev = 5
//          수행 4 : L += 1, cnt = 0, prev = 6
//          -- 복잡도 : 2N
//
// - 3. 전체 길이 L을 출력한다.
//          -- 복잡도 : 1
//
//  시간복잡도 : 2NlogN + 4N + 1

public class Solve2170B {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer rowCount = Integer.parseInt(br.readLine()); // 그어지는 선의 갯수

        ArrayList<MyTuple<Integer, Boolean>> doubleArrayResult1 = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            String rowInfo = br.readLine();
            StringTokenizer stRowInfo = new StringTokenizer(rowInfo," ");
            Integer rowStart = Integer.valueOf(stRowInfo.nextToken());
            Integer rowEnd = Integer.valueOf(stRowInfo.nextToken());

            // MyTuple 사용
            MyTuple<Integer, Boolean> MyTupleX = MyTuple.of(rowStart, true);
            MyTuple<Integer, Boolean> MyTupleY = MyTuple.of(rowEnd, false);

            doubleArrayResult1.add(MyTupleX);
            doubleArrayResult1.add(MyTupleY);
        }
        // 0번째 원소로 오름차순 정렬, 0번째가 같으면 1번째 원소로 내림차순 정렬
        doubleArrayResult1.sort(Comparator.comparing((MyTuple<Integer, Boolean> list) -> list.getP(), Comparator.naturalOrder()));

        Integer rowLength = calcRowLength(doubleArrayResult1);
        System.out.print(rowLength);
    }

    public static Integer calcRowLength(ArrayList<MyTuple<Integer, Boolean>> doubleArrayResult1) throws IOException {

        Integer cnt1 = 0;
        Integer prev1 = 0;
        Integer lengthSum = 0;

        for(int i = 0; i < doubleArrayResult1.size(); i++){

            Integer p1 = doubleArrayResult1.get(i).getP();
            Boolean isOpen = doubleArrayResult1.get(i).getIsOpen();

            if(cnt1 > 0){
                lengthSum += p1 - prev1;
            }

            if (isOpen){
                cnt1 += 1;
            } else {
                cnt1 -= 1;
            }
            prev1 = p1;
        }
        return lengthSum;
    }
}

class MyTuple<T1, T2> {
    private T1 p;
    private T2 isOpen;

    public MyTuple(T1 p, T2 isOpen) {
        this.p = p;
        this.isOpen = isOpen;
    }
    public static <T1, T2> MyTuple<T1, T2> of(T1 p, T2 isOpen) {
        return new MyTuple<>(p, isOpen);
    }
    public T1 getP() {
        return p;
    }

    public T2 getIsOpen() {
        return isOpen;
    }
}

