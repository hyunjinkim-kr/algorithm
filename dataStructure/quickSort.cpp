#include <iostream>
#include <vector>

using namespace std;

int choosePivot(int start, int end){
    return start;
}

void doQuickSort(vector<int>& array, int start, int end){
    // 정렬 시작
    // 1. 피벗을 선정한다.
    int pivot = choosePivot(start, end);

    // 왼쪽 포인터
    int i = start;
    // 오른쪽 포인터
    int j = end;
    // 복사를 위한 변수
    int copy;

    if (start >= end) // 원소가 1개인 경우 그대로 두기
        return;
        
    // 수행 이전의 결과 출력
    for (int k = start; k <= end; k++) {
        cout << array[k] << " ";
    }
    cout << " 피벗: "<< pivot <<" 피벗 값 :" << array[pivot] << endl;


    // 피벗을 기준으로 양쪽으로 나누기
    while(i <= j) {
        // 피벗보다 큰 값을 찾으면 멈추기
        while(i <= end && array[i] <= array[pivot]) {
            i++;
        }

        // 피벗보다 작은 값을 찾으면 멈추기
        while(j >= start && array[j] > array[pivot]) {
            j--;
        }

        // 교차되지 않은 상태라면 값을 교환
        if(i < j) {
            copy = array[i];
            array[i] = array[j];
            array[j] = copy;
        }
    }

    // 피벗 위치 변경
    copy = array[j];
    array[j] = array[pivot];
    array[pivot] = copy;

    // 피벗을 기준으로 나뉜 두 부분에 대해 재귀 호출
    doQuickSort(array, start, j - 1);
    doQuickSort(array, j + 1, end);
}

int main() {
    // 퀵정렬 생성
    // 정렬할 배열 사이즈 입력
    int m, m2;

    cin >> m;

    // 정렬 위한 배열을 생성한다.
    vector<int> A(m);

    // 입력받은 숫자 만큼 반복
    for (int i = 0; i < m; i++) {
        cout << i+1 << "번째 숫자를 입력하세요: ";
        cin >> m2;
        A[i] = m2;
    }

    doQuickSort(A, 0, A.size() - 1);  // 배열의 시작 주소와 끝 인덱스 전달

    return 0;
}
