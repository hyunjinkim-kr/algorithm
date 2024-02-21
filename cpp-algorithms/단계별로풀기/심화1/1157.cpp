#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <cmath>

// 단어공부
using namespace std;

int convert_capital(int word)
{
    if (word > 'Z')
    {
        word -= 32;
    }
    word -= 'A';
    return word;
}

char check_str(string str)
{
    char result;
    // 길이 26 짜리 배열을 만듬
    vector<int> A(26, 0);
    int idx;

    for (int i = 0; i < str.length(); i++)
    {
        int word = convert_capital(str[i]);
        A[word] += 1;
    }

    // 배열의 최대값을 찾음
    auto maxElement = max_element(A.begin(), A.end());

    // 배열에서 최대값 idx 찾기
    int maxValue = static_cast<int>(*maxElement);

    // 최대값 위치
    auto most_abc = find(A.begin(), A.end(), maxValue);
    // 추가 검색
    auto next_abc = find(next(most_abc), A.end(), maxValue);

    if (next_abc != A.end())
    {
        result = '?';
    }
    else
    {
        int intValue = 'A';
        size_t index1 = distance(A.begin(), most_abc);
        // 아스키 코드를 문자로 변환
        result = static_cast<char>(index1 + intValue);
    }

    return result;
}

int main()
{
    // 숫자 입력
    string str;
    char result;

    cin >> str;

    result = check_str(str);

    cout << result << endl;

    return 0;
}
