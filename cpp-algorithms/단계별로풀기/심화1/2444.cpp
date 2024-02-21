#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <cmath>

// 별 찍기 - 7
using namespace std;

string make_star(int n, int rownum)
{
    string stars = "";
    for (int i = 1; i <= n * 2 - 1; i++)
    {
        if (rownum > abs(n - i))
        {
            stars += "*";
        }
        else
        {
            if (n - i >= 0)
            {
                stars += " ";
            }
        }
    }
    return stars;
}

int main()
{
    // 숫자 입력
    int n;
    string star_row;

    cin >> n;

    // 해결2.
    for (int i = 1; i <= n; i++)
    {
        star_row = make_star(n, i);
        cout << star_row << endl;
    }

    for (int i = n - 1; i >= 1; i--)
    {
        star_row = make_star(n, i);
        cout << star_row << endl;
    }

    return 0;
}

// 해결1. 포문 때려박기...
// // n*2 -1만큼 포문을 돌아야한다.
// for (int i = 1; i <= n * 2 - 1; i++)
// {
//     star_row = "";
//     // 각 한줄에 나타나는 별 찍기
//     for (int j = 1; j <= n * 2 - 1; j++)
//     {
//         if (n - i >= 0) // 증가
//         {
//             if (i > abs(n - j))
//             {
//                 star_row += "*";
//             }
//             else
//             {
//                 if (n - j >= 0)
//                 {
//                     star_row += " ";
//                 }
//             }
//         }
//         else // 감소
//         {
//             if (2 * n - i > abs(n - j))
//             {
//                 star_row += "*";
//             }
//             else
//             {
//                 if (n - j >= 0)
//                 {
//                     star_row += " ";
//                 }
//             }
//         }
//     }
//     cout << star_row << endl;
// }