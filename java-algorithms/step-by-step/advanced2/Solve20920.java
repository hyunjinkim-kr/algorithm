package advanced2;

import java.io.*;
import java.util.*;

public class Solve20920 {
    // 문제 : 영단어 암기는 괴로워

    // 해결책 : 자주나온단어, 단어길이 내림차순, 사전순으로 정렬한다.
    //
    // N : 입력받은 단어의 개수
    // M : 최대 단어 길이
    // wordMap : 수의 빈도가 저장되는 Map
    //
    // 1. N과 M을 입력받는다.
    //
    // 2. N번 단어를 입력받을때 M 이상 길이의 단어를 wordMap에 저장한다.
    //      복잡도 N
    //
    // 3. wordMap에 저장된 단어를 정렬한다.
    //  - 3-1. wordMap의 EntrySet을 배열로 저장한다.
    //  - 3-2. 배열의 EntrySet value에 따라 내림차순 정렬한다.
    //      복잡도 : NlogN
    //  - 3-3. 배열의 EntrySet key의 길이에 따라 내림차순 정렬한다.
    //      복잡도 : NlogN
    //  - 3-4. 배열의 EntrySet key의 사전순으로 정렬한다.
    //      복잡도 : NlogN
    //
    // 4. 정렬된 배열의 key값을 출력한다.
    //
    // -- 시간복잡도 O(NlogN)
    public static void main(String[] args) throws IOException {
        ArrayList<String> resultArr;
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            // 입력 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer N = Integer.parseInt(st.nextToken());
            Integer M = Integer.parseInt(st.nextToken());

            HashMap<String, Integer> wordMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                String inputWord = br.readLine();
                if(inputWord.length() >= M){
                    Integer wordCnt = wordMap.getOrDefault(inputWord,0) + 1;
                    wordMap.put(inputWord,wordCnt);
                }
            }
            resultArr = setResultArr(wordMap);
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(String.join("\n", resultArr));
        }
    }

    public static ArrayList<String> setResultArr(HashMap<String,Integer> wordMap){
        ArrayList<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordMap.entrySet());

        wordList.sort(Map.Entry.<String,Integer>comparingByValue(Comparator.reverseOrder())
                // 뒤집으면 역순
                .thenComparing((entry1, entry2) -> Integer.compare(entry2.getKey().length(), entry1.getKey().length()))
                .thenComparing(Map.Entry.comparingByKey()));

        ArrayList<String> resultArr = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordList) {
            resultArr.add(entry.getKey());
        }
        return resultArr;
    }
}
