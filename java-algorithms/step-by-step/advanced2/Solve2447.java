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
        Integer x = N/3;
        Integer y = N/3;
        return starHelper(starArr, N, holeSize, x ,y,holeSize);
    }

    public static ArrayList<String> starHelper(ArrayList<String> starArr,
                                               Integer N,
                                               Integer holeSize,
                                               Integer x,
                                               Integer y,
                                               Integer cnt) {
        if(holeSize < 1){
            return starArr;
        }
        String starRow = starArr.get(y);
        StringBuilder sb = new StringBuilder(starRow);

        // 지정된 위치의 문자 교체
        ArrayList<String> spacesArr = new ArrayList<>(Collections.nCopies(holeSize, " "));
        String spaceString = String.join("", spacesArr);
        sb.replace( x, x + holeSize, spaceString);
        starArr.set(y,sb.toString());

        Integer newY = y + holeSize * 3;
        Integer newX = x + holeSize * 3;

        // 교체했으면
        // 1.옆으로 가야할지
        // 2.다음 줄로 가야할지
        // 3.새로운 위치에서 시작해야할지
        // 4. 다른 크기의 구멍으로 시작해야할지
        // 5. 멈춰야 할지
        for (String a : starArr){
            System.out.println(a);
        }
        System.out.println();

        if(cnt > 1){
            if(N < newX ){
                //바로 아랫줄 고치기
                starHelper(starArr, N, holeSize, holeSize,y + 1 ,cnt-1);
            } else{
                // 옆으로 이동하기
                starHelper(starArr, N, holeSize, newX, y,cnt);
            }
        } else {
            if(N < newY ){
                starHelper(starArr, N, holeSize/3, holeSize/3, holeSize/3,holeSize/3);
            } else{
                if(N < newX ){
                    starHelper(starArr, N, holeSize, holeSize, y,cnt);
                }else{
                    starHelper(starArr, N, holeSize, newX, y,cnt);
                }

            }
        }

        return starArr;
    }
}
