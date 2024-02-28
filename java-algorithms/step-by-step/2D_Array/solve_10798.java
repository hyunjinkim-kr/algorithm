import java.io.IOException;
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
        final Integer rowNum = 5;

        // 2차원 arraylist 생성
        // 배열을 까먹읍시다 []
        //ArrayList<String>[] doubleArrayResult1 = new ArrayList[rowNum];
        ArrayList<ArrayList<String>> doubleArrayResult1 = new ArrayList<>();
        // 문자 입력 및 최대 컬럼 반환
        maxColNum = placeWords(rowNum, doubleArrayResult1);
        StringBuilder result = readVertical(rowNum, maxColNum, doubleArrayResult1);

        System.out.print(result);
    }

    public static Integer placeWords(Integer rowNum, ArrayList<ArrayList<String>> doubleArrayResult1) throws IOException {

        Scanner sc = new Scanner(System.in);
        Integer maxColNum = 0;

        for (int i = 0; i < rowNum; i++) {
            String str = sc.nextLine();
            str = str.replaceAll(" ", "");
            ArrayList<String> newRow = new ArrayList<String>();
            // 각 행에 배열 생성 및 입력값 저장
            for (int j = 0; j < str.length(); j++) {
                newRow.add(String.valueOf(str.charAt(j)));
            }
            doubleArrayResult1.add(newRow);
            if (str.length() >= maxColNum) {
                maxColNum = str.length();
            }
        }
        return maxColNum;
    }

    public static StringBuilder readVertical(Integer rowNum, Integer maxColNum, ArrayList<ArrayList<String>> doubleArrayResult1) throws IOException {

        //String result = "";
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < maxColNum; j++) {
            // 각 행에 배열 생성 및 입력값 저장
            for (int i = 0; i < 5; i++) {
                if (doubleArrayResult1.get(i).size() <= j) {
                    continue;
                }
                result.append(doubleArrayResult1.get(i).get(j));
            }
        }
        return result;
    }
}
