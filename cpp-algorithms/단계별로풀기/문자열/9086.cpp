#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;
int main()
{

    int m;
    string str;

    cin >> m;
    vector<string> A(m + 1);

    for (int i = 1; i <= m; i++)
    {
        cin >> str;
        A[i] = str;
    }

    for (int i = 1; i <= m; i++)
    {
        str = A[i];
        // str = str.substr(0,1) + str.substr(str.length()-1, 1);
        cout << str[0] << str[str.length() - 1] << endl;
    }
    return 0;
}
