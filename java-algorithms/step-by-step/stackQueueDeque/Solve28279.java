package stackQueueDeque;

import java.io.*;
import java.util.*;

public class Solve28279 {
    // 문제 : 덱 2
    //
    // 해결책 : Deque 을 생성한후 명령어에 따라 작동시킨다.
    //
    // N : 입력되는 명령의 개수
    // M : 입력되는 명령에 따라 수정되는 리스트
    //
    //  1. N개 숫자를 입력받는다.
    //  2. N 개의 명령어에 따라 배열을 수정하거나 상태를 받는다.
    //  -- 복잡도 : N
    //
    // 복잡도 : N
    // 시간복잡도 : O(N)
    public static Deque<Integer> dequeArr = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            Integer cnt = Integer.parseInt(br.readLine());

            for (int i = 0; i < cnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String inputStr = st.nextToken();

                if(inputStr.equals("1")) {
                    Integer num = Integer.parseInt(st.nextToken());
                    push(num);
                } else if (inputStr.equals("2")){
                    Integer num = Integer.parseInt(st.nextToken());
                    pushBack(num);
                } else if (inputStr.equals("3")){
                    bw.write(poll() + "\n");
                } else if (inputStr.equals("4")){
                    bw.write(pollLast() + "\n");
                } else if (inputStr.equals("5")){
                    bw.write(size() + "\n");
                } else if (inputStr.equals("6")){
                    bw.write(isEmpty() + "\n");
                } else if (inputStr.equals("7")){
                    bw.write(peek() + "\n");
                } else if (inputStr.equals("8")){
                    bw.write(peekLast() + "\n");
                }
            }
        }
    }
    public static void push(Integer item) {
        dequeArr.addFirst(item);
    }

    public static void pushBack(Integer item) {
        dequeArr.add(item);
    }

    public static Integer poll() {
        if (isEmpty()==1) {
            return -1;
        }
        return dequeArr.poll();
    }

    public static Integer pollLast() {
        if (isEmpty()==1) {
            return -1;
        }
        return dequeArr.pollLast();
    }

    public static Integer peek() {
        if (isEmpty()==1) {
            return -1;
        }
        return dequeArr.peek();
    }

    public static Integer peekLast() {
        if (isEmpty()==1) {
            return -1;
        }
        return dequeArr.peekLast();
    }

    public static int isEmpty() {
        if(size() == 0 ){
            return 1;
        }
        return 0;
    }

    public static int size() {
        return dequeArr.size();
    }
}
