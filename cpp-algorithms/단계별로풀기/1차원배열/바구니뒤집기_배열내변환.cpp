#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;
int main() {

    //여기서는, m만큼의 고정배열을 입력받고, n만큼의 값을 추가로 입력받을 것이다..
    // set<int> mySet;

    int m, n, m2, n2, A2, B2;
    cin >> m >> n;

    // 길이 m+1 짜리 배열을 만듬
    vector<int> A(m + 1);
    
    // 배열에 값을 넣어준다.
    for (int i = 1; i <= m; i++) {
        A[i] = i;
    }

    for (int i = 1; i <= n; i++) {
        cin >> m2 >> n2;
        //mySet.insert(n % 42);

        //m부터 n까지 범위를 역순으로 바꿔야 한다. 
        // e.g) 1 2 3 4 5 에 2,4를 입력하면
        // 1 4 3 2 5 가 되어야 한다.
        int j = 0;
        while (m2 + j < n2 - j){   // 힌트 적용, for문 대신 while문 적용
            A2 = A[m2 + j]; //시작
            // B2 = A[n2 - i]; 
            // 끝은 따로 선언 하지 않고 해도 될듯.

            A[m2 + j] = A[n2 - j]; // 시작에 끝 값을
            A[n2 - j] = A2; // 끝에 시작 값을
            j++;
        }
    }

    for (int i = 1; i <= m; i++) {
        // cout : 출력
        cout << A[i] << " ";
    }
    return 0;
}
