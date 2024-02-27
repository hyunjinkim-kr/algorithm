import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class solve_2738 {
    public static void main(String[] args) throws IOException {
        //문제 : 행렬덧셈
        Scanner scan = new Scanner(System.in);
        int rowSize = scan.nextInt(); // n
        int colSize = scan.nextInt(); // m
        int inputNum;

        // 2차원 arraylist 생성
        ArrayList<Integer>[] doubleArrayResult = new ArrayList[rowSize];

        // 배열에 값 넣기
        for (int i = 0; i < rowSize; i++) {
            doubleArrayResult[i] = new ArrayList<Integer>();
            for (int j = 0; j < colSize; j++) {
                inputNum = scan.nextInt(); // 입력 시작하는 값
                doubleArrayResult[i].add(inputNum); // 해당 값 추가
            }
        }

        // 배열에 값 더하기
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                inputNum = scan.nextInt(); // 입력 시작하는 값
                doubleArrayResult[i].set(j, doubleArrayResult[i].get(j) + inputNum); // 해당 값 추가
            }
        }

        // 출력
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                System.out.print(doubleArrayResult[i].get(j) + " ");
            }
            System.out.println();
        }

    }
}
