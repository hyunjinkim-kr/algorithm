#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <algorithm>

using namespace std;

enum PivotPolicy {
    Naive,
    MedianOfThree,
};

void swap(vector<int>& arr, int l, int r) {
    int tmp = arr[l];
    arr[l] = arr[r];
    arr[r] = tmp;
}

int choosePivot(vector<int>& arr, int start, int end, PivotPolicy policy) {
    switch (policy) {
    case Naive:
        return start;
    case MedianOfThree:
        int mid = start + (end - start) / 2; 

        if ((arr[start] >= arr[mid] && arr[start] <= arr[end]) || (arr[start] <= arr[mid] && arr[start] >= arr[end])) 
            return start;
        else if ((arr[mid] >= arr[start] && arr[mid] <= arr[end]) || (arr[mid] <= arr[start] && arr[mid] >= arr[end])) 
            return mid;
        else
            return end;

        // TODO: 이거 ㅄ임
        // return middle;
    Default:
        return start;
    }
}

void quickSort(vector<int>& arr, int start, int end) {
    if (start >= end) // 원소가 1개인 경우 리턴
        return;

    int pivot = choosePivot(arr, start, end, MedianOfThree);
    int pivotVal = arr[pivot];

    // 왼쪽 포인터
    int i = start;
    // 오른쪽 포인터
    int j = end;

    // 피벗을 기준으로 양쪽으로 나누기
    while (i < j) {
        // 피벗보다 큰 값을 찾으면 멈추기
        while (i <= end && arr[i] <= arr[pivot]) {
            i++;
        }

        // 피벗보다 작은 값을 찾으면 멈추기
        while (i < j && arr[j] >= arr[pivot]) {
            j--;
        }

        // 교차되지 않은 상태라면 값을 교환
        if (i < j) {
            swap(arr, i, j);
        }
    }
    
    int bound;
    if (i < pivot)
        bound = i;
    else
        bound = max(0, i - 1);

    swap(arr, pivot, bound);
       
    // 피벗을 기준으로 나뉜 두 부분에 대해 재귀 호출
    quickSort(arr, start, bound - 1);
    quickSort(arr, bound + 1, end);
}

bool validate(const vector<int>& v) {
    vector<int> target = v, expected = v;
    quickSort(target, 0, target.size() - 1);
    std::sort(expected.begin(), expected.end());
    return (target == expected);
}

void test() {
    for (int t = 0; t < 1000000; ++t) {
        // 시드 값 설정
        srand(time(0));

        // 1에서 7 사이의 랜덤한 길이 생성
        int length = rand() % 7 + 1;

        // 랜덤한 배열 생성 및 초기화
        vector<int> org(length);

        // 배열에 랜덤한 숫자 채우기
        for (int i = 0; i < length; ++i) {
            org[i] = rand() % 10 + 1;  // 1에서 10 사이의 랜덤한 숫자로 채우기
        }
 
        if (!validate(org)) {
            for (int i = 0; i < length; i++) {
                cout << org[i] << " ";
            }
            cout << endl;
            exit(134);
        }
    }
}

int main() {
    test();
    /*vector<int> debugged = { 7,6,1,4,3,1 };
    quickSort(debugged, 0, debugged.size() - 1);
    for (auto e : debugged) {
        cout << e << " ";
    }*/
    return 0;
}
