#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <cmath>

// 팰린드롬인지 확인하기
using namespace std;

bool check_pl(string str)
{
    bool is_pl = 1;

    for (int i = 0; i < str.length() / 2; i++)
    {
        if (str[i] != str[(str.length() - 1) - i])
        {
            is_pl = 0;
            break;
        }
    }

    return is_pl;
}

int main()
{
    // 숫자 입력
    string str;
    int pl_Flag;

    cin >> str;

    pl_Flag = check_pl(str);

    cout << pl_Flag << endl;

    return 0;
}
