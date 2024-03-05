import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;


//문제 : 선긋기
public class solve_2170 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer rowCount = Integer.parseInt(br.readLine()); // 그어지는 선의 갯수
        // 배열을 까먹든지 색칠을 안하든지 해봐요
        ArrayList<String> arrayResult1 = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            String rowInfo = br.readLine();
            arrayResult1.add(rowInfo);
        }

        String rowLength = calcRowLength(rowCount,arrayResult1).toString();
        //System.out.print(rowLength);
        bw.write(rowLength);

        bw.flush();
        bw.close();
    }

    public static Integer calcRowLength(Integer rowCount, ArrayList<String> arrayResult1) throws IOException {

        Integer rowLengthSum = 0;
        Integer duplicatedLengthSum = 0;

        for (int i = 0; i < rowCount; i++) {
            StringTokenizer rowInfoI = new StringTokenizer(arrayResult1.get(i)," ");
            Integer startI = Integer.valueOf(rowInfoI.nextToken());
            Integer endI = Integer.valueOf(rowInfoI.nextToken());

            rowLengthSum += (endI - startI);
            // 각 행에 배열 생성 및 입력값 저장
            for (int j = i; j < rowCount; j++) {
                if(j == i){
                    continue;
                }
                StringTokenizer rowInfoJ = new StringTokenizer(arrayResult1.get(j)," ");
                Integer startJ = Integer.valueOf(rowInfoJ.nextToken());
                Integer endJ = Integer.valueOf(rowInfoJ.nextToken());

                // 겹치는 조건 만족.
                // i줄 끝점이 j줄 시작점보다 크거나 같으면서 j줄 끝점보다 작거나 같을때
                // i줄 시작점이 j점 시작점보다 크거나 같으면서 j줄 끝점보다 같거나 작을떄
                if ((endI >= startJ && endI <= endJ)
                    || (startI >= startJ && startI <= endJ)){

                    Integer minStart = calcMinStart(startI , startJ);
                    Integer maxEnd = calcMaxEnd(endI , endJ);

                    duplicatedLengthSum += (endI - startI) + (endJ - startJ) - (maxEnd - minStart);
                    // 1. 두 줄의 단순 길이 합을 구함
                    // 2. 두 줄의 최소점과 끝점을 구해 합쳐진 길이를 구함
                    // 3. 두개를 뺴면, 겹치는 길이가 나옴
                    // 4. 겹치는 길이 제거값을 누적함.
                }
            }
        }
        return rowLengthSum - duplicatedLengthSum;
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