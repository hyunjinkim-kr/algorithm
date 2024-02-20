#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

// 그대로 출력하기
using namespace std;

int main()
{
    string str;
    while (std::getline(std::cin, str))
    {
        // 입력 받은 문자열 출력
        std::cout << str << std::endl;
    }

    return 0;
}
