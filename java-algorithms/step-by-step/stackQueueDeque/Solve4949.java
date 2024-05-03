package stackQueueDeque;

import java.io.*;
import java.util.ArrayList;

public class Solve4949 {
    // 문제 : 균형잡힌 세상
    //
    // 해결책 : ( ) [ ] 위 네개 형태의 괄호를 따로 저장하는 배열을 만든다.
    //
    // N : 입력되는 문장길이
    // V : 괄호가 저장되는 배열
    //
    //  1. N 한글자씩 체크한다. "( [" 형태가 나오면 V 배열에 추가하고, ") ]" 형태가 나오면 V 배열에서 제거한다.
    //  단, 닫는배열일때 배열의 끝 값이 올바른 여는형식이 아닐때 --e.g : ( 와 ] -- 반복문을 종료하고 결과를 no로 한다.
    // -- 시간복잡도 : 2 * N
    //  3. V 배열에 값이 남아있는지 체크 후 최종 결과를 출력한다.
    //
    // 복잡도 : 3*N
    // 시간복잡도 : O(N)
    public static void main(String[] args) throws IOException {

        final String openVps = "(";
        final String closeVps = ")";

        final String openBigVps = "[";
        final String closeBigVps = "]";

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)
        ) {
            while (true) {
                ArrayList<String> vpsArr = new ArrayList<>();

                String inputStr = br.readLine();
                String result = "yes";

                if (inputStr.equals(".")) {
                    break;
                }

                for (int j = 0; j < inputStr.length(); j++) {
                    String chkStr = inputStr.substring(j, j + 1);
                    int arrIdx = vpsArr.size() - 1;

                    if (chkStr.equals(openVps)) {
                        vpsArr.add(openVps);
                    } else if (chkStr.equals(openBigVps)) {
                        vpsArr.add(openBigVps);
                    } else if (chkStr.equals(closeVps)) {
                        if (arrIdx < 0 || !vpsArr.get(arrIdx).equals(openVps)) {
                            result = "no";
                            break;
                        }
                        vpsArr.remove(arrIdx);
                    } else if (chkStr.equals(closeBigVps)) {
                        if (arrIdx < 0 || !vpsArr.get(arrIdx).equals(openBigVps)) {
                            result = "no";
                            break;
                        }
                        vpsArr.remove(arrIdx);
                    }
                }

                if (!vpsArr.isEmpty()) {
                    result = "no";
                }
                System.out.println(result);
            }
        }
    }
}
