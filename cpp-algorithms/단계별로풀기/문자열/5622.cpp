#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

// 다이얼
using namespace std;

int calc_time(int num)
{
    // 빈칸 두개와 1까지 총 세칸이 있음.
    int result = 3;

    if (num == 'Z')
    {
        result += (num - 'A' - 2) / 3;
    }
    else if (num >= 'S')
    {
        result += (num - 'A' - 1) / 3;
    }
    else
    {
        result += (num - 'A') / 3;
    }
    return result;
}

int solve(string str)
{
    int result = 0;
    // 대문자 'A'의 아스키 코드는 65이며, 대문자 'Z'의 아스키 코드는 90
    for (int i = 0; i < str.length(); i++)
    {
        // 글자 한개 받아옴
        result += calc_time(str[i]);
    }
    return result;
}

int main()
{
    string str;
    // 영어 대문자로 된 문장을 받는다.
    cin >> str;

    // 알파벳을 판별하기 위한 함수 호출.
    int time = solve(str);

    cout << time << endl;

    return 0;
}