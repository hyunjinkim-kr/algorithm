package advanced2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solve2447 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> resultArr;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw);
        ) {
            Integer N = Integer.parseInt(br.readLine());
            resultArr = star(N);

            for(int i = 0; i < resultArr.size(); i++){
                bw.write(resultArr.get(i) + "\n");
                bw.flush();  // 각 입력마다 출력 버퍼를 플러시
            }
        }
    }

    public static ArrayList<String> star(Integer N) {
        ArrayList<String> starArr = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < N; j++){
                sb.append("*");
            }
            starArr.add(sb.toString());
        }

        // 무엇을 파라미터로? 
        // 1. 별들이 담긴 배열
        // 2. 구멍을 뜷어야 하는 사이즈
        // 3. 구멍을 뜷어야 하는 위치
        Integer holeSize = N/3;
        Integer start = N/3;
        Integer end = 2 * N/3;
        return starHelper(starArr, N, holeSize, holeSize,start,end);
    }

    public static ArrayList<String> starHelper(ArrayList<String> starArr,
                                               Integer N,
                                               Integer holeSize,
                                               Integer row,
                                               Integer start,
                                               Integer end) {
        if(N < 3){
            return starArr;
        }
        String starRow = starArr.get(row);
        StringBuilder sb = new StringBuilder(starRow);

        // 지정된 위치의 문자 교체
        ArrayList<String> spacesArr = new ArrayList<>(Collections.nCopies(holeSize, " "));
        String spaceString = String.join("", spacesArr);
        sb.replace( start, end, spaceString);
        starArr.set(row,sb.toString());

        Integer newRow = row + 1;
        if(row < N*2/3){
            starHelper(starArr, N, holeSize, newRow,start,end);
        }

        Integer newHoleSize = N/3;
        Integer newStart = N/3;
        Integer newEnd = 2 * N/3;

        starHelper(starArr, N, newHoleSize, newRow,newStart,newEnd);
        starHelper(starArr, N, newHoleSize, newRow,newStart,newEnd);
        starHelper(starArr, N, newHoleSize, newRow,newStart,newEnd);

        return starArr;
    }
}
