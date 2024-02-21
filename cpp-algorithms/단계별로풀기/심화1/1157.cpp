#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <cmath>

// 단어공부
using namespace std;

int abc_to_idx(int word)
{
    if (word >= 'a')
    {
        word -= 'a';
    }
    else
    {
        word -= 'A';
    }
    return word;
}

char check_str(string str)
{
    char result;
    // 길이 26 짜리 배열을 만듬
    vector<int> A(26, 0);

    int idx;
    int max_val = 0;
    int max_idx = 0;
    int max_count = 0;

    // 배열에 값 넣기
    for (int i = 0; i < str.length(); i++)
    {
        int word = abc_to_idx(str[i]);
        A[word] += 1;

        if (A[word] > max_val)
        {
            max_val = A[word];
            max_idx = word;
        }
    }

    // 최대값과 동일한 값이 또 있으면 return '?'
    for (int i = 0; i < A.size(); i++)
    {
        if (A[i] == max_val)
        {
            max_count++;
            if (max_count > 1)
            {
                return '?';
            }
        }
    }

    // 가장 많이나온 문자 반환
    result = max_idx + 'A';
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
