#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;
int main() {

    //여기서는, m만큼의 고정배열을 입력받고, n만큼의 값을 추가로 입력받을 것이다..
    // set<int> mySet;

    string str1;
    int n;
    
    cin >> str1;
    cin >> n;
    
    str1 = str1.substr(n - 1, 1);

    cout << str1;
    return 0;
}
