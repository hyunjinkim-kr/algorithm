#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

// 상수
using namespace std;

string reverse_str(string str1, string str2)
{
    string result = "";
    string result_1 = "";
    string result_2 = "";

    for (int i = str1.length() - 1; i >= 0; i--)
    {
        result_1 += str1[i];
        result_2 += str2[i];
    }

    if (result_1 >= result_2)
    {
        result = result_1;
    }
    else
    {
        result = result_2;
    }
    return result;
}

int main()
{
    string str1;
    string str2;
    cin >> str1 >> str2;

    cout << reverse_str(str1, str2) << endl;

    return 0;
}