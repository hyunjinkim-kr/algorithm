#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <cmath>

// 크로아티아 알파벳
using namespace std;

int check_flag(string str)
{
    array<string, 8> arr1 = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    int flag = 1;
    for (int i = 0; i < arr1.size(); i++)
    {
        if (arr1[i] == str.substr(0, 2))
        {
            flag = 2;
            break;
        }
        else if (arr1[i] == str.substr(0, 3))
        {
            flag = 3;
            break;
        }
    }
    return flag;
}

int count_abc(string str)
{
    int result = 0;

    while (str.length() > 0)
    {
        int flag = check_flag(str);
        str = str.substr(flag);
        result++;
    }

    return result;
}

int main()
{
    // 크로아티아 문자 입력
    string str;
    int result;

    cin >> str;

    result = count_abc(str);

    cout << result << endl;

    return 0;
}
