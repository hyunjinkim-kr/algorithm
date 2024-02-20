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

    string result_1;
    string result_2;

    cin >> str1 >> str2;

    result_1 = reverse_str(str1);
    result_2 = reverse_str(str2);

    if (result_1 >= result_2)
    {
        cout << result_1 << endl;
    }
    else
    {
        cout << result_2 << endl;
    }

    return 0;
}