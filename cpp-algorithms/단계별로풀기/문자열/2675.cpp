#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
// 문자열 반복
using namespace std;

string solve(int n, string str1)
{
    string str2 = "";
    for (int i = 0; i < str1.length(); i++)
    {
        for (int j = 0; j < n; j++)
        {
            str2 += str1.substr(i, 1);
        }
    }
    return str2;
}

int main()
{
    int m;
    cin >> m;

    // 길이 m+1 짜리 배열을 만듬
    vector<string> A(m + 1);

    int n;
    string str1;
    for (int i = 1; i < A.size(); i++)
    {
        cin >> n >> str1;
        cout << solve(n, str1) << endl;
    }
    // 다음과 같은 형태가 반영 가능함
    // 3
    // 3 abc
    // aaabbbccc
    // 3 xyz
    // xxxyyyzzz
    // 2 zxc
    // zzxxcc

    // for (int i = 1; i < A.size(); i++)
    // {
    //     cout << A[i] << " ";
    // }

    return 0;
}