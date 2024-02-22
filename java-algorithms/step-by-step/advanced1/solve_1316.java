import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class solve_1316 {
    public static void main(String[] args) throws IOException {
        //문제 : 그룹 단어 체커

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lineNum;
        String str;
        int count = 0;

        lineNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < lineNum; i++) {
            str = br.readLine();
            boolean isGroupWork = checkGroup(str);
            if(isGroupWork){
                count++;
            }
        }
        System.out.print(count);
    }

    public static boolean checkGroup(String str){
        // Character 타입의 ArrayList 생성
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < str.length(); i++){
            if(charSet.contains(str.charAt(i))
                    && str.charAt(i-1)!=str.charAt(i)){
                return false;
            } else{
                charSet.add((str.charAt(i)));
            }
        }
        return true;
    }
}
