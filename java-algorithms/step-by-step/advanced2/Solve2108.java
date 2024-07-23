package advanced2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solve2108 {
    // 문제 : 통계학

    // 해결책 : 입력받은 합으로 평균, Map으로 최빈값, list를 정렬하여 범위와 중앙값을 구하자.
    //
    // 
    // N : 입력받은 수의 개수
    // M : 각각 입력받는 수
    // numList : 수가 저장되는 배열
    // numMap : 수의 빈도가 저장되는 Map
    //
    // 1. N번 수를 입력받는다.
    //
    // 2. M이 입력될때마다 다음 과정을 거친다.
    //  - 2-1. M을 numList에 저장한다.
    //  - 2-2. M의 출현 빈도를 numMap에 저장한다.
    //  - 2-3. M을 더한다.
    //      복잡도 N
    //
    // 3. 평균, 최빈값, 범위, 중앙값을 구한다.
    //  - 3-1. M의 총합을 N으로 나눈후 양수이면 반올림, 음수이면 0.5 뺀 후 올림처리한다.
    //  - 3-2. numMap을 빈도에따라 내림차순, key에 따라 오름차순 정렬한 후 최빈값이 여러개면 두번째로 작은수를 리턴한다.
    //      복잡도 : NlogN
    //  - 3-3. numList를 오름차순 정렬 후 끝과 처음을 뺀다.
    //      복잡도 : NlogN
    //  - 3-4. numList(오름차순 정렬된)에서 N/2 위치의 값을 리턴한다.
    //
    // -- 시간복잡도 O(NlogN)

    public static void main(String[] args) throws IOException {
        ArrayList<String> resultArr = new ArrayList<>();
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            Integer totSum = 0;
            Integer avgNum;
            Integer mostNum;
            Integer range;

                    // 입력 수
            Integer N = Integer.parseInt(br.readLine());

            HashMap<Integer, Integer> numMap = new HashMap<>();
            ArrayList<Integer> numList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                Integer inputNum = Integer.parseInt(st.nextToken());
                numList.add(inputNum);

                Integer newCount = numMap.getOrDefault(inputNum, 0) + 1;
                numMap.put(inputNum,newCount);

                totSum += inputNum;
            }

            //산술평균
            avgNum = getAvg(totSum, N);

            //중앙값
            Collections.sort(numList);
            Integer centerNum = numList.get(N/2);

            //최빈값
            mostNum = getMostNum(numMap);

            // 범위
            range = numList.get(numList.size()-1) - numList.get(0);

            resultArr.add(String.valueOf(avgNum));
            resultArr.add(String.valueOf(centerNum));
            resultArr.add(String.valueOf(mostNum));
            resultArr.add(String.valueOf(range));
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(String.join("\n",resultArr));
        }
    }

    public static Integer getAvg(Integer totSum, Integer N) {
        double value = (double) totSum / N;

        if (value > 0) {
            return (int) Math.round(value);
        } else {
            return (int) Math.ceil(value - 0.5);
        }
    }

    public static Integer getMostNum(HashMap<Integer,Integer> numMap) {
        //최빈값
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(numMap.entrySet());
        entryList.sort(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder())
                .thenComparing(Map.Entry.comparingByKey()));

        List<Map.Entry<Integer, Integer>> valueEntries = entryList.stream()
                .filter(entry -> entry.getValue().equals(entryList.get(0).getValue()))
                .collect(Collectors.toList());
        // 최빈값이 여러개면
        if(valueEntries.size() > 1){
            return entryList.get(1).getKey();
        } else {
            return entryList.get(0).getKey();
        }
    }
}
