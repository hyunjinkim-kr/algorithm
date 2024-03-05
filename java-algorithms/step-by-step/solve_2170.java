import java.io.*;
import java.util.*;

//문제 : 선긋기
public class solve_2170 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer rowCount = Integer.parseInt(br.readLine()); // 그어지는 선의 갯수

        Integer rowSum = 0;

        // 배열을 까먹든지 색칠을 안하든지 해봐요
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
        Integer IdxJ = 0;

        // input이 들어올때, 연결가능한 요소가 있는지 비교하고 없으면 넣자.
        for(int i = 0; i < doubleArrayResult1.size(); i++){

            Integer startI = doubleArrayResult1.get(i).get(0);
            Integer endI = doubleArrayResult1.get(i).get(1);
            Integer startJ = doubleArrayResult2.get(IdxJ).get(0);
            Integer endJ = doubleArrayResult2.get(IdxJ).get(1);

            if(startI.equals(startJ)){
                continue;
            }

            // 겹치는 조건 만족.
            // i줄 끝점이 j줄 시작점보다 크거나 같으면서 j줄 끝점보다 작거나 같을때
            // i줄 시작점이 j점 시작점보다 크거나 같으면서 j줄 끝점보다 같거나 작을떄
            // endI 이 친구가 후발주자.
            if (startI <= doubleArrayResult2.get(IdxJ).get(1)){

                Integer minStart = calcMinStart(startI , startJ);
                Integer maxEnd = calcMaxEnd(endI , endJ);
                doubleArrayResult2.get(IdxJ).set(0,minStart);
                doubleArrayResult2.get(IdxJ).set(1,maxEnd);
            } else {
                doubleArrayResult2.add(doubleArrayResult1.get(i));
                IdxJ++;
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


