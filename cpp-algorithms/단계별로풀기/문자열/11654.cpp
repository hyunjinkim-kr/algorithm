#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
//아스키코드
using namespace std;
int main() {

    string str;

    cin >> str;
    
    for (char c : str) {
        cout << static_cast<int>(c) << " ";
    }
    return 0;
}
