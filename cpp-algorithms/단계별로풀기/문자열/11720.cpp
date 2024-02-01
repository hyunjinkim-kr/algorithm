#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
// 숫자의 합
using namespace std;
int main() {

    int m;
    string str;
    int sum = 0;

    // int m : 현 코드에서는 불필요하나, 백준 제출을 위해 입력받기
    cin >> m;
    cin >> str;
     
    for (char c : str) {
        int intValue = c - '0';
        sum += intValue;
    }
    cout << sum;
    return 0;
}
