import java.io.IOException;
import java.util.Scanner;

public class solve_2753 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        // 윤년
//        연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.
//        윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
        Integer year = scan.nextInt(); // n
        Integer younNyunFlag = checkYounNyun(year);

        System.out.print(younNyunFlag);
    }

    public static Integer checkYounNyun (Integer year){
        Integer younNyunFlag = 0;
        if(year % 4 == 0){
            if(year % 100 != 0 || year % 400 == 0){
                younNyunFlag = 1;
            }
        }
        return younNyunFlag;
    }
}



