#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

// 상수
using namespace std;

string reverse_str(string str)
{
    string result = "";
    for (int i = str.length() - 1; i >= 0; i--)
    {
        result += str[i];
    }
    return result;
}

int main()
{
    string str1;
    string str2;
    cin >> str1 >> str2;

    if (reverse_str(str1) >= reverse_str(str2))
    {
        cout << reverse_str(str1) << endl;
    }
    else
    {
        cout << reverse_str(str2) << endl;
    }

    return 0;
}