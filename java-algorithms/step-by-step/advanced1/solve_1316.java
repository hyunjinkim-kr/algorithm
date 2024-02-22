import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
        ArrayList<Character> stringList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++){
            if(stringList.isEmpty()){
                stringList.add((str.charAt(i)));
            } else{
                for(int j = 0; j < stringList.size(); j++){
                    if(stringList.get(j) == str.charAt(i) && stringList.get(stringList.size()-1)!=str.charAt(i)){
                        return false;
                    }
                }
                stringList.add((str.charAt(i)));
            }
        }
        return true;
    }
}
