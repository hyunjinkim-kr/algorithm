#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
// 알파벳 찾기
using namespace std;
int main() {

    string str;

    // 영어 소문자로 된 문장을 받는다.
    cin >> str;
    
    //소문자 a부터 z까지의 아스키코드 범위 : 97(a)~122(z)
    for (int i = 97; i <= 122; i++) {
        
        char targetChar = i;

        size_t found = str.find(i);

        if (found != std::string::npos) {
            cout << found << " ";
        }
        else {
            cout << -1 << " ";
        }
    }
    return 0;
}
