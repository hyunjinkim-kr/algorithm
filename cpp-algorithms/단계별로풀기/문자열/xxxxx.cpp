#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
//문자와문자열
using namespace std;
int main() {

    int m;
    string str;

    cin >> m;
    vector<string> A(m + 1);

    for (int i = 1; i <= m; i++) {
        cin >> str;
        A[i] = str;
    }

    for (int i = 1; i <= m; i++) {
        str = A[i];
        str = str.substr(0,1) + str.substr(str.length()-1, 1);
        cout << str << endl;
    }
    return 0;
}
