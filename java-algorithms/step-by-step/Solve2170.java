import java.io.*;
import java.util.*;

//문제 : 선긋기
//해결책 : 선 N개에 대하여 시작과 끝의 좌표 S, E 를 Arr1에 저장 및 정렬한다.
// 이후, 정렬된 선들의 연결여부에 따라, 연결 or 새로운 선을 판별한다.
// 연결된 경우 선의 시작과 끝의 좌표를 S" ,E" 로 설정한다. 연결이 멈출때마다 길이를 합친다.
// 마지막으로 아직 합쳐지지않은 선 한개(연결중이거나 떨어진)도 길이를 합친다. 길이의 합을 출력한다.
// 
//
//    N : 입력받은 선의 갯수
//    Arr1 : 초기 저장 및 정렬하는 배열
//    S : 시작 좌표
//    E : 끝 좌표
//    S" : 연결된 선의 시작좌표
//    E" : 연결된 선의 끝 좌표
//    L  : 선 길이의 합
//
// - 1. 입력받은 선 N개의 시작과 끝의 좌표 S, E 를 Arr1 에 저장후 정렬한다. 정렬기준은 S 오름차순, E 내림차순이다.
//        -- 복잡도 : N + N log N
//
// - 2. Arr1에 저장된 최초 선을 기준선으로 새로운 선과 연결을 시작한다. 동떨어진 선이 생기는 순간 선 연결을 멈추고 길이에 합산한다.
//      - 시작점이 같고 겹치는경우 : 끝 좌표의 범위가 내림차순이므로 생략한다.
//          e.g) 선1(0,100) 선2(0,99), 선3(0,98)...
//
//      - 시작점이 다르고 겹치는경우 : 새로운 선과 기준선의 범위를 합쳐 기준선을 설정한다.
//          e.g) 기준선(1,3) 새로운선(2,4) -> 기준선(1,4)
//
//      - 겹치지 않는경우 : 기준선의 길이를 전체길이에 더하고, 새로운 선을 기준선으로 정한다.
//          e.g) 기준선(1,3) 새로운선(6,7) -> 전체길이 L += 2, 기준선(6,7)
//
//      연결이 종료되면 마지막으로 전체길이에 기준선 길이를 더한다. (연결중이거나 새로운 떨어진선 한개)
//      
//        -- 복잡도 : N + 1
//
// - 3. 전체 길이 L을 출력한다.
//        -- 복잡도 : 1
//
//시간복잡도 : NlogN + 2N + 2
public class Solve2170 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer rowCount = Integer.parseInt(br.readLine()); // 그어지는 선의 갯수

        ArrayList<MyPair<Integer, Integer>> doubleArrayResult1 = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            String rowInfo = br.readLine();
            StringTokenizer stRowInfo = new StringTokenizer(rowInfo," ");
            Integer rowStart = Integer.valueOf(stRowInfo.nextToken());
            Integer rowEnd = Integer.valueOf(stRowInfo.nextToken());

            // Pair 사용
            MyPair<Integer, Integer> pair1 = MyPair.of(rowStart, rowEnd);
            doubleArrayResult1.add(pair1);
        }
        // 0번째 원소로 오름차순 정렬, 0번째가 같으면 1번째 원소로 내림차순 정렬
        doubleArrayResult1.sort(Comparator.comparing((MyPair<Integer, Integer> list) -> list.getFirst(), Comparator.naturalOrder())
                .thenComparing((MyPair<Integer, Integer> list1, MyPair<Integer, Integer> list2) -> list2.getSecond().compareTo(list1.getSecond())));

        Integer rowLength = calcRowLength(doubleArrayResult1);
        System.out.print(rowLength);
    }

    public static Integer calcRowLength(ArrayList<MyPair<Integer, Integer>> doubleArrayResult1) throws IOException {

        // 연결된 선의 최초값 설정
        Integer startJ = doubleArrayResult1.get(0).getFirst();
        Integer endJ = doubleArrayResult1.get(0).getSecond();
        Integer lengthSum = 0;

        // input이 들어올때, 연결가능한 요소가 있는지 비교하고 없으면 넣자.
        for(int i = 0; i < doubleArrayResult1.size(); i++){

            Integer startI = doubleArrayResult1.get(i).getFirst();
            Integer endI = doubleArrayResult1.get(i).getSecond();

            // 이미 정렬이 된 상태이므로, 시작점이 같으면 끝점은 endI보다 무조건 작으므로, continue
            if(startI.equals(startJ)){
                continue;
            }
            // 이미 정렬이 된 상태이므로, I시작점이 J끝점 보다 작은 케이스만 분류하면 된다.
            // I :   ----
            // J : ----
            if (startI <= endJ){
                Integer minStart = Math.min(startI , startJ);
                Integer maxEnd = Math.max(endI , endJ);
                startJ = minStart;
                endJ = maxEnd;
            } else {
                lengthSum += (endJ - startJ);
                startJ = doubleArrayResult1.get(i).getFirst();
                endJ = doubleArrayResult1.get(i).getSecond();
            }
        }
        lengthSum += (endJ - startJ);
        return lengthSum;
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

