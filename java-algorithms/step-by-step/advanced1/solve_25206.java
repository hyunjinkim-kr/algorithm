import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class solve_25206 {
    public static void main(String[] args) throws IOException {
        //문제 : 너의 평점은
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int subjectNum =20;
        double calcGradeSum = 0.0;
        double gradeSum = 0.0;

        for (int i = 0; i < subjectNum; i++) {
            String str = br.readLine();
            // 공백을 기준으로 문자열 분할
            String[] subjectGrade = str.split(" ");
            double calcGrade = getGrade(subjectGrade);
            if(calcGrade >= 0){
                gradeSum += Double.parseDouble(subjectGrade[1]);
                calcGradeSum += calcGrade;
            }
        }
        // 평균 = (P를 제외한) 학점 * 과목평점의 전체 합 / 학점의 총합
        double avg = calcGradeSum / gradeSum;
        System.out.print(avg);
    }

    // 입력받은 줄의 학점 * 평점을 반환
    public static double getGrade(String[] subjectGrade){
        String[][] gradeArray = {
                {"A+", "4.5"},
                {"A0", "4.0"},
                {"B+", "3.5"},
                {"B0", "3.0"},
                {"C+", "2.5"},
                {"C0", "2.0"},
                {"D+", "1.5"},
                {"D0", "1.0"},
                {"F", "0.0"}
        };

        if(subjectGrade[2].equals("P")){
            return -1;
        }

        for(int i = 0; i < gradeArray.length; i++){
            if(subjectGrade[2].equals(gradeArray[i][0])){
                // 학점 * 과목평점
                return Double.parseDouble(subjectGrade[1]) * Double.parseDouble(gradeArray[i][1]);
            }
        }
        return -1;
    }
}
