package stackQueueDeque;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.StringTokenizer;

public class Solve18258 {
    // 문제 : 큐 2
    //
    // 해결책 : LinkedList 를 이용한 queue 를 생성한후 명령어에 따라 작동시킨다.
    //
    // N : 입력되는 명령의 개수
    // M : 입력되는 명령에 따라 수정되는 리스트
    //
    //
    //  1. N개 숫자를 입력받는다.
    //  2. N 개의 명령어에 따라 배열을 수정하거나 상태를 받는다.
    //   ** LinkedList는 요소 이동이 일어나지 않으므로, ArrayList에서 일어나던 시간초과가 일어나지 않았다.
    //  -- 복잡도 : N ( ArrayList : N^2)
    //
    // 복잡도 : N
    // 시간복잡도 : O(N)
    public static LinkedList<Integer> queueArr = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            Integer cnt = Integer.parseInt(br.readLine());

            for (int i = 0; i < cnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String inputStr = st.nextToken();

                if(inputStr.equals("push")) {
                    Integer num = Integer.parseInt(st.nextToken());
                    enqueue(num);
                } else if (inputStr.equals("pop")){
                    bw.write(dequeue() + "\n");
                } else if (inputStr.equals("front")){
                    bw.write(peek() + "\n");
                } else if (inputStr.equals("back")){
                    bw.write(peekBack() + "\n");
                } else if (inputStr.equals("size")){
                    bw.write(size() + "\n");
                } else if (inputStr.equals("empty")){
                    bw.write(isEmpty() + "\n");
                }
            }
        }
    }

    public static void enqueue(Integer item) {
        queueArr.add(item);
    }

    public static Integer dequeue() {
        if (isEmpty()==1) {
            return -1;
        }
        Integer num = queueArr.get(0);
        queueArr.remove(0);
        return num;
    }

    public static Integer peek() {
        if (isEmpty()==1) {
            return -1;
        }
        return queueArr.get(0);
    }

    public static Integer peekBack() {
        if (isEmpty()==1) {
            return -1;
        }
        return queueArr.get(size()-1);
    }

    public static int isEmpty() {
        if(size() == 0 ){
            return 1;
        }
        return 0;
    }

    public static int size() {
        return queueArr.size();
    }
}
