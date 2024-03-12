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
// - 2. 정렬된 배열 Arr1의 최초 선의 시작과 끝인 S,E를 각각 S",E" 로 설정한다.
//      Arr1을 순회하며 선의 연결여부를 판별하며 길이를 계산한다.
//      - S와 S"가 같으면 계산하지 않는다.(S : 오름차순, E : 내림차순 이므로 S값이 동일하면 계산할 필요없음)
//      - 선의 S가 E"보다 작거나 같으면 S와 S" 중 최소값을 S"로, E와 E"중 최대값을 E"로 업데이트 한다.(연결)
//      - 선의 S가 E"보다 크면 L 에 E"-S" 를 더한다. 그리고 S를 S", E를 E"로 설정한다. (떨어진 선 발생)
//      Arr1 순회가 끝나면 마지막으로 L 에 E"-S" 를 더한다. (연결중이거나 새로운 떨어진선 한개)
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
            if (startI <= endJ){ //doubleArrayResult2.get(idxJ).get(1)
                Integer minStart = Math.min(startI , startJ);
                Integer maxEnd = Math.max(endI , endJ);
                startJ = minStart; // doubleArrayResult2.get(idxJ).set(0,minStart);
                endJ = maxEnd; //doubleArrayResult2.get(idxJ).set(1,maxEnd);
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

