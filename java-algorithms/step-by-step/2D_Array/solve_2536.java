import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

//문제 : 색종이
//해결책 : 가로세로의 길이가 각각 W,H인 흰도화지 공간을 X 로 채운 후, P개의 검은색종이가 있는 위치만 O 로 바꿔준다. 최종적으로 O의 갯수를 반환한다.
//
//W : 흰도화지의 가로길이
//H : 흰도화지의 세로길이
//W" : 검은색종이 가로길이
//H" : 검은색종이 세로길이
//P : 검은색종이 갯수
//O : 검은색종이가 있는 공간
//X : 흰색도화지 공간
//
// - 1. 흰 도화지 ArrayList를 만든다. 흰도화지의 가로*세로인 H * W 만큼 X 로 ArrayList 초기값을 설정한다.
//   -- 복잡도 : W * H
//
// - 2. 흰도화지의 가로*세로인 H * W 만큼 수행하며 검은색종이 여부에따라 O로 ArrayList값을 변경한다. 검은색종이 갯수 P번 만큼 수행한다.
//   -- 복잡도 : W" * H" * P
//
// - 3. 흰 도화지 전체를 조회하여, O의 갯수를 출력한다.
//        -- 복잡도 : W * H
//
//시간복잡도 : W*H*2  +  W"*H"*P
public class solve_2536 {
    public static void main(String[] args) throws IOException {

        final Integer rowNum = 100; //흰색 도화지의 사이즈
        final Integer rowNum2 = 10; //검정색 도화지의 사이즈

        Scanner scan = new Scanner(System.in);
        Integer paperCount = scan.nextInt(); // 색종이 갯수

        ArrayList<ArrayList<String>> doubleArrayResult1 = new ArrayList<>();
        setPaper(rowNum, doubleArrayResult1); //초기값 세팅

        for (int i = 0; i < paperCount; i++) {
            Integer startX = scan.nextInt();
            Integer startY = scan.nextInt();
            setBlckPaper( rowNum2, startX, startY, doubleArrayResult1);
        }
        Integer ariaSize = calcAreaSize(rowNum, doubleArrayResult1);
        System.out.print(ariaSize);
    }

    public static void setBlckPaper(
                                Integer rowNum2,
                                Integer startX,
                                Integer startY,
                                ArrayList<ArrayList<String>> doubleArrayResult1) throws IOException {
        for (int i = startY; i < startY + rowNum2; i++) { //세로길이
            // 각 행에 입력값 저장
            for (int j = startX; j < startX + rowNum2; j++) { //가로길이
                    doubleArrayResult1.get(i).set(j, "O");
            }
        }
    }

    public static void setPaper(    Integer rowNum,
                                    ArrayList<ArrayList<String>> doubleArrayResult1) throws IOException {

        for (int i = 0; i < rowNum; i++) {
            ArrayList<String> newRow = new ArrayList<String>();
            // 각 행에 배열 생성 및 입력값 저장
            for (int j = 0; j < rowNum; j++) {
                newRow.add("X");
            }
            doubleArrayResult1.add(newRow);
        }
    }

    public static Integer calcAreaSize(Integer rowNum, ArrayList<ArrayList<String>> doubleArrayResult1) throws IOException {

        Integer countSize = 0;
        for (int i = 0; i < rowNum; i++) {
            // 각 행에 배열 생성 및 입력값 저장
            for (int j = 0; j < rowNum; j++) {
                if (doubleArrayResult1.get(i).get(j).equals("O")) {
                    countSize++;
                }
            }
        }
        return countSize;
    }
}
