package recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solve24060 {
    // 문제 : 병합 정렬 1

    // 해결책 : 중앙값을 기준으로 분할해가며 정렬한다 (분할/정복)
    //
    // numArr : 입력받은 N개의 숫자가 저장되는 배열
    // N : len(numArr)
    // k : 정렬될때 저장되는 숫자의 순서
    // resultArr : 저장되는 숫자가 순서대로 저장되는 배열
    // result : k번째로 resultArr에 저장된 값
    //
    // 1. 숫자를 입력받아 numArr에 저장한다.
    //
    // 2. 배열의 시작, 끝, 중간을 정한다.(분할)
    //
    // 3. 시작~중간, 중간~끝 범위의 요소를 비교하여 더 작은 요소를 임시배열에 저장한다.
    //   복잡도 : N
    // 4. 3의 과정을 재귀를 통해 반복한다. 단, k번째 저장 숫자가 들어오면 중단한다.
    //   복잡도 : k
    //
    // -- 시간복잡도 O(N^2)
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> resultArr = new ArrayList<>();
        Integer result = -1;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer n = Integer.parseInt(st.nextToken());
            Integer k = Integer.parseInt(st.nextToken());
            ArrayList<Integer> numArr = new ArrayList<>();

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                Integer a = Integer.parseInt(st2.nextToken());
                numArr.add(a);
            }
            mergeSort(numArr, resultArr, 0, numArr.size() - 1, k);

            if (resultArr.size() >= k) {
                result = resultArr.get(k - 1);
            }
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(result + "");
        }
    }

    public static void mergeSort(ArrayList<Integer> numArr,
                                 ArrayList<Integer> resultArr,
                                 Integer start,
                                 Integer end,
                                 Integer resultIdx) {

        if (start < end && resultIdx > resultArr.size()) {
            Integer mid = (start + end) / 2;

            // 전반부와 후반부를 재귀적으로 정렬
            mergeSort(numArr, resultArr, start, mid, resultIdx);
            mergeSort(numArr, resultArr, mid + 1, end, resultIdx);

            // 정렬된 두 부분 배열을 병합
            merge(numArr, resultArr, start, mid, end, resultIdx);
        }
    }

    public static void merge(ArrayList<Integer> numArr,
                             ArrayList<Integer> resultArr,
                             Integer start,
                             Integer mid,
                             Integer end,
                             Integer resultIdx) {
        ArrayList<Integer> tmp = new ArrayList<>(end - start + 1);
        for (int k = 0; k < end - start + 1; k++) {
            tmp.add(0); // 임시 배열 초기화
        }

        Integer i = start;
        Integer j = mid + 1;
        Integer t = 0;

        // 두 배열을 병합하여 임시 배열에 저장
        while (i <= mid && j <= end) {
            if (numArr.get(i) <= numArr.get(j)) {
                tmp.set(t, numArr.get(i));
                i++;
            } else {
                tmp.set(t, numArr.get(j));
                j++;
            }
            t++;
        }

        // 왼쪽 배열에 남아있는 요소들을 임시 배열에 복사
        while (i <= mid) {
            tmp.set(t, numArr.get(i));
            t++;
            i++;
        }

        // 오른쪽 배열에 남아있는 요소들을 임시 배열에 복사
        while (j <= end) {
            tmp.set(t, numArr.get(j));
            t++;
            j++;
        }

        // 임시 배열의 내용을 원래 배열로 복사
        i = start;
        t = 0;
        while (i <= end) {
            if (resultIdx.equals(resultArr.size())) {
                return;
            }
            numArr.set(i, tmp.get(t));
            resultArr.add(tmp.get(t));
            i++;
            t++;
        }
    }
}
