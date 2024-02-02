#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;
int main() {

    string str;

    // 영어 소문자로 된 문장을 받는다.
    cin >> str;

    // 알파벳을 판별하기 위한 배열을 생성한다.
    vector<int> A(26, -1);
    
    // 소문자 a부터 z까지의 아스키코드 범위 : 97(a)~122(z)
    // 입력받은 문자열 만큼 포문 실행
    for (int i = 0; i < str.length(); i++) {
        
        // 글자 한개 받아옴
        // 받아온 글자에서 'a'를 빼면, 26개 배열의 인덱스에 해당함.
        int idx = str[i] - 'a';
        
        // 값이 여러번 나오면 초기값을 설정해야 하므로
        if (A[idx] == -1) {
            A[idx] = i;
        }
     }

    // 결과 출력
    for (int i = 0; i < 26; ++i) {
        cout << A[i] << " ";
    }
    return 0;
}
