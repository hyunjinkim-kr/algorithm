#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
// 단어의 개수
using namespace std;

int main()
{
    string str1;
    getline(cin, str1);

    int n = 0;
    bool wordFlag = false;

    for (int i = 0; i < str1.length(); i++)
    {
        int idx = str1[i];

        if (idx == 32) // 공백일 경우
        {
            if (wordFlag == true)
            {
                wordFlag = false;
            }
        }
        else // 공백이 아닐 경우
        {
            if (wordFlag == false)
            {
                wordFlag = true;
                n++;
            }
        }
    }
    cout << n << endl;

    return 0;
}