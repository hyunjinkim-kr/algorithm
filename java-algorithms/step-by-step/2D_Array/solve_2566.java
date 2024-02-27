import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class solve_2566 {
    public static void main(String[] args) throws IOException {
        //문제 : 최댓값

        // 배열을 잊어봅시다
        // String[][] doubleArray = new String[9][9];
        
        //입력과 동시에 값을 출력하자.
        findMaxNum();
    }

    public static void findMaxNum() throws IOException {
        // 9줄 입력받아서 배열에 넣는 함수를 진행하자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxNum = 0;
        int maxNumRow = 0;
        int maxNumCol = 0;

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            // 공백을 기준으로 문자열 분할
            ArrayList<String> arrayRow = new ArrayList<>(Arrays.asList(str.split(" ")));
            for(int j = 0; j < arrayRow.size(); j++){
                if(Integer.parseInt(arrayRow.get(j)) >= maxNum){
                    maxNum = Integer.parseInt(arrayRow.get(j));
                    maxNumRow = i;
                    maxNumCol = j;
                }
            }
        }
        System.out.println(maxNum);
        System.out.println((maxNumRow + 1) + " " + (maxNumCol + 1));
    }
}
