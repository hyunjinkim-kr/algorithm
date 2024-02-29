import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class solve_2536 {
    public static void main(String[] args) throws IOException {
        //문제 : 색종이
        final Integer rowNum = 100; //흰색 도화지의 사이즈
        final Integer rowNum2 = 10; //검정색 도화지의 사이즈

        Scanner scan = new Scanner(System.in);
        Integer paperCount = scan.nextInt(); // 색종이 갯수

        ArrayList<ArrayList<String>> doubleArrayResult1 = new ArrayList<>();

        for(int i = 0; i < paperCount; i++){
            Integer startX = scan.nextInt();
            Integer startY = scan.nextInt();

            setPaper(i,rowNum,rowNum2,startX,startY,doubleArrayResult1 );
        }
        Integer ariaSize = calcAreaSize(rowNum,doubleArrayResult1 );;
        System.out.print(ariaSize);
    }

    public static void setPaper(Integer idxNum ,
                                Integer rowNum ,
                                Integer rowNum2,
                                Integer startX ,
                                Integer startY ,
                                ArrayList<ArrayList<String>> doubleArrayResult1) throws IOException {

        if(idxNum == 0){
            for (int i = 0; i < rowNum; i++) {
                ArrayList<String> newRow = new ArrayList<String>();

                // 각 행에 배열 생성 및 입력값 저장
                for (int j = 0; j < rowNum; j++) {
                    if((i >= startX && i < startX + 10)&&(j >= startY && j < startY + 10)){
                        newRow.add("O");
                    } else {
                        newRow.add("X");
                    }
                }
                doubleArrayResult1.add(newRow);
            }
        } else {
            for (int i = 0; i < rowNum; i++) {
                // 각 행에 배열 생성 및 입력값 저장
                for (int j = 0; j < rowNum; j++) {
                    if((i >= startX && i < startX + 10)&&(j >= startY && j < startY + 10)){
                        doubleArrayResult1.get(i).set(j,"O");
                    }
                }
            }
        }

    }

    public static Integer calcAreaSize(Integer rowNum,ArrayList<ArrayList<String>> doubleArrayResult1) throws IOException {

        Integer countSize = 0;
        for (int i = 0; i < rowNum; i++) {
            // 각 행에 배열 생성 및 입력값 저장
            for (int j = 0; j < rowNum; j++) {
                if(doubleArrayResult1.get(i).get(j).equals("O")){
                    countSize++;
                }
            }
        }
        return countSize;
    }
}
