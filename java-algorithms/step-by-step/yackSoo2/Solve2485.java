package yackSoo2;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solve2485 {
    // 문제 : 가로수
    // 해결책 : 가로수 사이의 거리를 저장하고, 거리를 최대공약수로 나눈 후 1을 뺀 값이 가로수 개수가 된다.
    //
    // N : 가로수의 수
    // A : 이전 가로수 사이의 길이
    // B : 다음 가로수 사이의 길이
    //
    // 1. 가로수의 위치 N개를 입력받는다.
    // 2. 두번째 가로수 부터, 이전 가로수의 위치를 빼서 가로수 사이의 길이를 저장한다.
    //  복잡도 : N - 1
    // 3. 가로수 사이의 길이에 대하여 최대공약수를 구한다.
    //  복잡도 : log min(A, B) * (N - 1)
    // 4. 가로수 길이를 최대공약수로 나눈 값을 모두 더한후, 원소 개수만큼 뺀값을 출력한다.
    //  복잡도 : N - 1
    //
    // 시간복잡도 : O(log min(N, M))
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> treeArr = new ArrayList<>();

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)
        ) {
            // Logic 구현부
            Integer treeCnt = Integer.parseInt(br.readLine());

            Integer treePreLoc = Integer.parseInt(br.readLine());
            for (int i = 1; i < treeCnt; i++) {
                Integer treeLoc = Integer.parseInt(br.readLine());
                treeArr.add(treeLoc - treePreLoc);
                treePreLoc = treeLoc;
            }
        }

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out);
             BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(getResult(treeArr) + "");
        }
    }

    public static BigInteger getResult(ArrayList<Integer> treeArr) {
        BigInteger gcdNum = BigInteger.valueOf(treeArr.get(0));
        for (int j = 1; j < treeArr.size(); j++) {
            gcdNum = gcdNum.gcd(BigInteger.valueOf(treeArr.get(j)));
        }

        BigInteger result = BigInteger.valueOf(0);
        for (int k = 0; k < treeArr.size(); k++) {
            result = result.add(BigInteger.valueOf(treeArr.get(k)).divide(gcdNum));
        }
        return result.subtract(BigInteger.valueOf(treeArr.size()));
    }
}
