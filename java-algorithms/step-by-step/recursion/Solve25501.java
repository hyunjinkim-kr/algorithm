package recursion;

import java.io.*;
import java.util.ArrayList;

public class Solve25501 {
    // 문제 : 재귀의 귀재

    // 해결책 : 재귀 함수에 진입횟수를 저장하는 파라미터와 결과값을 같이 리턴한다.
    //
    // s : 입력 문자열
    // N : len(s)
    // cnt : 재귀가 수행된 횟수
    // result : 팰린드롬 여부와 재귀횟수가 작성된 문자열
    // resultArr : result가 저장된 배열
    //
    // 1. s를 입력받고, 각각 재귀를 수행한다. 재귀 첫수행시 cnt는 1이고, 재귀가 수행됨에 따라 1씩 증가한다.
    //      복잡도 N
    //
    // 2. 수행된 결과 result가 담긴 resultArr을 출력한다.
    //
    // -- 시간복잡도 O(N)
    public static void main(String[] args) throws IOException {
        ArrayList<String> resultArr = new ArrayList<>();
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr)) {
            Integer t = Integer.parseInt(br.readLine());

            for(int i = 0; i < t; i++){
                String s = br.readLine();
                String result = isPalindrome(s);
                resultArr.add(result);
            }
        }
        try (OutputStreamWriter osw = new OutputStreamWriter(System.out); BufferedWriter bw = new BufferedWriter(osw)) {
            bw.write(String.join("\n",resultArr));
        }
    }
    public static String isPalindrome(String s){
        return recursion(s, 0, s.length()-1,1);
    }
    public static String recursion(String s, int l, int r, int cnt){
        if(l >= r) return 1 + " " + cnt;
        else if(s.charAt(l) != s.charAt(r)) return 0 + " " + cnt;
        else return recursion(s, l+1, r-1,cnt +1);
    }
}