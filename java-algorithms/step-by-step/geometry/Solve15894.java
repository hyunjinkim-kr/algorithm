package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solve15894 {
    public static void main(String[] args) throws IOException {
        // 문제 : 수학은 체육과목 입니다
        // 해결책 : 결국 가로와 세로길이가 n이므로, 4 * n을 수행한다.
        // ** 범위가 2^10 이므로, long으로 선언한다.
        Scanner scan = new Scanner(System.in);
        Long n = (long)scan.nextInt();

        System.out.print(4*n);
    }
}
