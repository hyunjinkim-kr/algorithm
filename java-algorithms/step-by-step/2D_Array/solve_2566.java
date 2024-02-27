import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;

public class solve_2566 {
    public static void main(String[] args) throws IOException {
        //문제 : 최댓값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] doubleArray = new String[9][9];

        // 9 * 9 배열에 값넣기
        inputArr(br,doubleArray);
        findMaxNum(doubleArray);
    }

    public static void inputArr(BufferedReader br, String[][] doubleArrayResult) throws IOException {
        // 9줄 입력받아서 배열에 넣는 함수를 진행하자
        for (int i = 0; i < doubleArrayResult.length; i++) {
            String str = br.readLine();
            // 공백을 기준으로 문자열 분할
            doubleArrayResult[i] = str.split(" ");
        }
    }

    public static void findMaxNum(String[][] doubleArrayResult) {
        int maxNum = 0;
        int maxNumRow = 0;
        int maxNumCol = 0;

        // 9줄 입력받아서 배열에 넣는 함수를 진행하자
        for (int i = 0; i < doubleArrayResult.length; i++) {
            for (int j = 0; j < doubleArrayResult[i].length; j++) {
                // 공백을 기준으로 문자열 분할
                if(Integer.parseInt(doubleArrayResult[i][j]) >= maxNum){
                    maxNum = Integer.parseInt(doubleArrayResult[i][j]);
                    maxNumRow = i;
                    maxNumCol = j;
                }
            }
        }
        System.out.println(maxNum);
        System.out.println((maxNumRow + 1) + " " + (maxNumCol + 1));
    }
}
