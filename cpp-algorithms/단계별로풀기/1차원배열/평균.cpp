#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;
int main() {

    //여기서는, m만큼의 고정배열을 입력받고, n만큼의 값을 추가로 입력받을 것이다..
    // set<int> mySet;

    int m;
    double avg = 0.0;
    cin >> m;

    // 길이 m+1 짜리 배열을 만듬
    vector<int> A(m + 1);
    

    for (int i = 1; i <= m; i++) {
        int temp;
        std::cin >> temp;
        A[i] = temp;
    }
    // 배열의 최대값을 찾음
    auto maxElement = max_element(A.begin()+1, A.end());

    for (int i = 1; i <= m; i++) {
        // cout : 출력
        avg += A[i];
    }

    avg = avg * 100 / (double) m  / *maxElement;

    cout << avg;
    return 0;
}
