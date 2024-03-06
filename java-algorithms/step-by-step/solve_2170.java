import java.io.*;
import java.util.*;

//문제 : 선긋기
//해결책 : 선 N개에 대하여 시작과 끝의 좌표 S, E 를 Arr1에 저장 및 정렬한다.
//새로운 집합 Arr2을 만든다. Arr2에 기존 집합에 연결되는 선이 없으면 추가, 연결되는 선이 있으면 업데이트 한 후
//Arr2에 있는 선들의 길이 전체합을 구한다.
//
//N : 입력받은 선의 갯수
//N": 겹치지 않는 선의 갯수
//S : 시작 좌표
//E : 끝 좌표
//Arr1 : 초기 저장 및 정렬하는 배열
//Arr2 : 연결된 선들이 저장되는 배열
//
// - 1. 입력받은 선 N개의 시작과 끝의 좌표 S, E 를 Arr1 에 저장후 정렬한다. 정렬기준은 S 오름차순, E 내림차순이다.
//        -- 복잡도 : N log N
//
// - 2. 정렬된 배열 Arr1을 탐색하며 Arr2의 가장 최근 삽입된 값과 비교한다. Arr2에는 Arr1의 최초값을 넣은 후 비교하며, 선이 연결되면 Arr2의 최근 값을 변경하고, 연결되지 않는다면 Arr2에 삽입한다.
//        -- 복잡도 : N
//
// - 3. Arr2를 조회하여, 전체 길이를 반환한다.
//        -- 복잡도 : N"
//
//시간복잡도 : NlogN + N + N"
public class solve_2170 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer rowCount = Integer.parseInt(br.readLine()); // 그어지는 선의 갯수

        ArrayList<ArrayList<Integer>> doubleArrayResult1 = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            String rowInfo = br.readLine();
            StringTokenizer stRowInfo = new StringTokenizer(rowInfo," ");
            Integer rowStart = Integer.valueOf(stRowInfo.nextToken());
            Integer rowEnd = Integer.valueOf(stRowInfo.nextToken());

            ArrayList<Integer> newRow = new ArrayList<Integer>();
            newRow.add(rowStart);
            newRow.add(rowEnd);
            doubleArrayResult1.add(newRow);
        }
        // 0번째 원소로 오름차순 정렬, 0번째가 같으면 1번째 원소로 내림차순 정렬
        doubleArrayResult1.sort(Comparator.comparing((ArrayList<Integer> list) -> list.get(0), Comparator.naturalOrder())
                .thenComparing((ArrayList<Integer> list1, ArrayList<Integer> list2) -> list2.get(1).compareTo(list1.get(1))));

        Integer rowLength = calcRowLength(doubleArrayResult1);
        System.out.print(rowLength);
    }

    public static Integer calcRowLength(ArrayList<ArrayList<Integer>> doubleArrayResult1) throws IOException {

        // 최종적으로 결과를 넣을 녀석.
        ArrayList<ArrayList<Integer>> doubleArrayResult2 = new ArrayList<>();

        // 첫번째꺼는 무조건 넣어주기.
        doubleArrayResult2.add(doubleArrayResult1.get(0));
        Integer idxJ = 0;

        // input이 들어올때, 연결가능한 요소가 있는지 비교하고 없으면 넣자.
        for(int i = 0; i < doubleArrayResult1.size(); i++){

            Integer startI = doubleArrayResult1.get(i).get(0);
            Integer endI = doubleArrayResult1.get(i).get(1);
            Integer startJ = doubleArrayResult2.get(idxJ).get(0);
            Integer endJ = doubleArrayResult2.get(idxJ).get(1);

            // 이미 정렬이 된 상태이므로, 시작점이 같으면 끝점은 endI보다 무조건 작으므로, continue
            if(startI.equals(startJ)){
                continue;
            }
            // 이미 정렬이 된 상태이므로, I시작점이 J끝점 보다 작은 케이스만 분류하면 된다.
            // I :   ----
            // J : ----
            if (startI <= doubleArrayResult2.get(idxJ).get(1)){
                Integer minStart = calcMinStart(startI , startJ);
                Integer maxEnd = calcMaxEnd(endI , endJ);
                doubleArrayResult2.get(idxJ).set(0,minStart);
                doubleArrayResult2.get(idxJ).set(1,maxEnd);
            } else {
                doubleArrayResult2.add(doubleArrayResult1.get(i));
                idxJ++;
            }
        }
        Integer lengthSum = 0;
        for(int k = 0; k < doubleArrayResult2.size(); k++){
            lengthSum += doubleArrayResult2.get(k).get(1) - doubleArrayResult2.get(k).get(0);
        }
        return lengthSum;
    }
    public static Integer calcMinStart(Integer startI, Integer StartJ){
        Integer minStart = 0;
        if(startI > StartJ){
            return StartJ;
        }
        return startI;
    }

    public static Integer calcMaxEnd(Integer endI, Integer endJ){
        Integer minStart = 0;
        if(endI > endJ){
            return endI;
        }
        return endJ;
    }
}


