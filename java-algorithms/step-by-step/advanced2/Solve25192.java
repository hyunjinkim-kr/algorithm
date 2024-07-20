package advanced2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//문제 : 인사성 밝은 곰곰이
//해결책 : ENTER 입력후 처음 입력하는 유저의 수를 더해간다.
//
// N : 채팅방에 입력된 수
// M : 새로운사람 입장 및 채팅을 입력한 유저 닉네임
// L : 입력한 유저 닉네임 리스트
//
// - 1. N을 입력받는다.
//
// - 2. M를 N만큼 입력받는다.
//    2-1) ENTER 일 경우 : 기존 유저리스트 L을 비운다.
//    2-1) 유저닉네임일 경우 : L에 닉네임이 없으면 추가하고, 결과값 1을 더한다.
//        -- 복잡도 : N
//
//
//  시간복잡도 : N

public class Solve25192 {
    public static void main(String[] args) throws IOException {
        final String newUserMsg = "ENTER";
        Integer result = 0;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            // 입력 수
            Integer N = Integer.parseInt(br.readLine());
            Set<String> loginUserArr = new HashSet<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String M = st.nextToken();

                if(newUserMsg.equals(M)){
                    loginUserArr.clear();
                    continue;
                }

                if(!loginUserArr.contains(M)){
                    loginUserArr.add(M);
                    result++;
                }
            }
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }
}
