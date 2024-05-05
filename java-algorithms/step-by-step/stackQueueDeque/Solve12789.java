package stackQueueDeque;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solve12789 {
    // 문제 : 도키도키 간식드리미
    //
    // 해결책 : 대기 배열 두개를 만들어서 처리한다.
    //
    // N : 입력되는 숫자의 개수, 순서대로 1~N의 N개 입력됨.
    // M : 입력된 N개 숫자가 초기 저장되는 배열
    // O : 순서에 맞지 않을때 이동해서 대기하는 배열
    // c : 순서를 체크할 숫자. 1로 시작하며 일치하는 숫자를 체크하면 1씩 증가한다.
    //
    //
    //  1. N개 숫자를 입력받는다. M 배열에 1~N 순서대로 N개 숫자들을 저장한다.
    //   복잡도 : N
    //  2. c와 M 배열의 첫번째 숫자를 체크한다.
    //   2-1 숫자가 일치할때 : M 배열의 첫번째 숫자를 삭제하고, c를 1 증가시킨다.
    //   2-2 숫자가 일치 X  : M 배열의 첫번째 숫자를 삭제하고, O 배열로 이동한다.
    //  3. c 가 N 과 일치하거나, M 배열이 비어있고 O 배열의 마지막 값이 c가 아닐때 종료된다.
    //   복잡도 : N
    //
    // 복잡도 : 2*N
    // 시간복잡도 : O(N)
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> sideArr = new ArrayList<>();
        ArrayList<Integer> inputArr = new ArrayList<>();
        String result = "Nice";

        try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr)) {
            Integer checkNum = 1;
            Integer cnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < cnt; i++) {
                Integer inputNum = Integer.parseInt(st.nextToken());
                inputArr.add(inputNum);
            }

            while (!checkNum.equals(cnt)) {
                int sideIdx = 0;
                Integer sideNum = 0;
                Integer inputNum = 0;

                if(!sideArr.isEmpty()){
                    sideIdx = sideArr.size() - 1;
                    sideNum = sideArr.get(sideIdx);
                }

                if(!inputArr.isEmpty()){
                    inputNum = inputArr.get(0);
                }

                if (inputArr.isEmpty() && !sideNum.equals(checkNum)) {
                    result = "Sad";
                    break;
                }

                if (checkNum.equals(inputNum)) {
                    inputArr.remove(0);
                    checkNum++;
                } else if (checkNum.equals(sideNum)) {
                    sideArr.remove(sideIdx);
                    checkNum++;
                } else {
                    sideArr.add(inputNum);
                    inputArr.remove(0);
                }
            }
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result);
        }
    }
}
