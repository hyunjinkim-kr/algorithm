import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class solve_10798 {
    public static void main(String[] args) throws IOException {
        //문제 : 세로읽기

//        A A B C D D
//        a f z z
//        0 9 1 2 1
//        a 8 E W g 6
//        P 5 h 3 k x
//        -> Aa0aPAf985Bz1EhCz2W3D1gkD6x

        Integer maxColNum = 0;

        // 2차원 arraylist 생성
        ArrayList<String>[] doubleArrayResult1 = new ArrayList[5];
        // 문자 입력 및 최대 컬럼 반환
        maxColNum = placeWords(doubleArrayResult1);
        String result = readVertical(maxColNum , doubleArrayResult1);

        System.out.print(result);
    }

    public static Integer placeWords(ArrayList<String>[] doubleArrayResult1) throws IOException {

        Scanner sc = new Scanner(System.in);
        Integer maxColNum = 0;

        for (int i = 0; i < 5; i++) {
            String str = sc.nextLine();
            str = str.replaceAll(" ","");
            doubleArrayResult1[i] = new ArrayList<String>();
            // 각 행에 배열 생성 및 입력값 저장
            for(int j = 0; j < str.length(); j++){
                doubleArrayResult1[i].add(String.valueOf(str.charAt(j)));
            }
            if(str.length() >= maxColNum){
                maxColNum = str.length();
            }
        }
        return maxColNum;
    }

    public static String readVertical(Integer maxColNum, ArrayList<String>[] doubleArrayResult1) throws IOException {

        String result = "";
        for (int j = 0; j < maxColNum; j++) {
            // 각 행에 배열 생성 및 입력값 저장
            for (int i = 0; i < 5; i++) {
                if(doubleArrayResult1[i].size() <= j){
                    continue;
                }
                result += doubleArrayResult1[i].get(j);
            }
        }
        return result;
    }
}
