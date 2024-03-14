package baseConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 문제 : 벌집
//해결책 : 방을 한바퀴 돌때마다 6개씩 방이 증가하면다. 따라서 둘러싸는 레벨에 해당하는 방도 6개씩 증가한다.
// B : 입력된 방 번호
// L : 방의 레벨. 초기값은 1
// F : 순회하며 방을 찾는 변수
//
// 1. 시작하는 1번방은 레벨1의 방이다. 레벨1을 둘러싸는 레벨2는 방 6개가 필요하고, 레벨3은 그보다 방 6개가 더 필요하다.
//    레벨의 증가에따라 전체 방은 F+=6*L이 된다. (등차수열의 합)
//    다음 과정을 입력한 방 B가 전체방 F보다 작을때까지만 반복하면 해당하는 방의 레벨이 나온다.
//
// --시간복잡도 : ?
public class Solve2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer beeRoomNum = Integer.parseInt(br.readLine()); // 벌집 위치

        final Integer hexagon = 6; // 벌집이 한바퀴씩 둘러질때마다 증가값
        Integer roomLevel = 1;
        Integer findBeeRoom = 1;

        while (beeRoomNum > findBeeRoom) {
            findBeeRoom += roomLevel * hexagon;
            roomLevel++;
        }
        System.out.print(roomLevel);
    }
}
