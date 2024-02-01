#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;
int main() {

    string str1;
    int n;
    
    cin >> str1;
    cin >> n;
    
    str1 = str1.substr(n - 1, 1);

    cout << str1;
    return 0;
}
