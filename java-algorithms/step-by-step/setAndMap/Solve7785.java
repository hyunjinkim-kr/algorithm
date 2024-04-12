package setAndMap;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solve7785 {
    public static void main(String[] args) throws IOException {
        // 문제 : 회사에 있는 사람
        // 해결책 : 출석한 사람 이름을 hashSet에 넣고, 퇴근한 사람을 뺀다. 최종적으로 남은 사람을 이름 역순으로 정렬한다.
        //
        // H : 출석한 사람을 저장할 hashSet
        // N : 출결 시도 횟수
        // A : 남아있는 사람이 저장되는 ArrayList
        // M : 남은사람
        //
        // 1. 출석 혹은 퇴근한 사람을 저장하고 삭제한다.
        // 복잡도 : N
        // 2. 최종적으로 H에 남은 사람을 A에 옮겨 정렬한후 출력한다.
        // 복잡도 : MlogM
        //
        // 시간복잡도 : O(NlogN)
        HashSet<String> hm = new HashSet<>();

        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            try (BufferedReader br = new BufferedReader(isr)) {
                // Logic 구현부
                Integer checkCnt = Integer.parseInt(br.readLine());

                for (int i = 0; i < checkCnt; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());

                    String nameInput = st.nextToken();
                    String statusInput = st.nextToken();

                    Status status = Enum.valueOf(Status.class, statusInput);
                    switch (status){
                        case enter -> hm.add(nameInput);
                        case leave -> hm.remove(nameInput);
                    }
                }
            }
        }
        ArrayList<String> resultArr = new ArrayList<>(List.copyOf(hm));
        resultArr.sort(Comparator.comparing((String name) -> name, Comparator.reverseOrder()));

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            try (BufferedWriter bw = new BufferedWriter(osw)) {
                final String resultStr = resultArr.stream().map(String::valueOf).collect(Collectors.joining("\n"));
                bw.write(resultStr);
            }
        }
    }
}

enum Status {
    enter, leave;
};
