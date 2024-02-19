#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

// 단어의 개수
using namespace std;

// 문자열 앞뒤 공백 모두 삭제 함수
string trim(string str)
{
    size_t first = str.find_first_not_of(' ');
    size_t last = str.find_last_not_of(' ');

    if (first == std::string::npos) // 전체가 공백인 경우
        return "";
    else
        return str.substr(first, last - first + 1);
}

int main()
{
    string str1;
    string str2;
    getline(cin, str1);

    int n = 0;
    bool wordFlag = false;

    // 풀이 1. trim 후 공백의 개수를 판별
    str2 = trim(str1);

    for (int i = 0; i < str2.length(); i++)
    {
        int idx = str2[i];

        if (idx == ' ') // 공백일 경우
        {
            n++;
        }
    }

    if (str2 == "")
    {
        n = 0;
    }
    else
    {
        n++;
    }
    cout << n << endl;

    // 풀이 2. flag를 통해 풀이
    // for (int i = 0; i < str1.length(); i++)
    // {
    //     int idx = str1[i];

    // if (idx == ' ') // 공백일 경우
    // {
    //     wordFlag = false;
    // }
    // else // 공백이 아닐 경우
    // {
    //     if (!wordFlag)
    //     {
    //         wordFlag = true;
    //         n++;
    //     }
    // }
    //}
    // cout << n << endl;

    return 0;
}