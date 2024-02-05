#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>

using namespace std;

int choosePivot(int start, int end){
    return start;
}

void swap(vector<int>& array, int copyIdx1, int copyIdx2){
    // 복사를 위한 변수
    int copy = array[copyIdx1];
    array[copyIdx1] = array[copyIdx2];
    array[copyIdx2] = copy;
}

void doQuickSort(vector<int>& array, int start, int end){
    // 정렬 시작
    // 1. 피벗을 선정한다.
    int pivot = choosePivot(start, end);


    if (start >= end) // 원소가 1개인 경우 그대로 두기
        return;
        
    // 수행 이전의 결과 출력
    for (int k = start; k <= end; k++) {
        cout << array[k] << " ";
    }
    cout << " 피벗: "<< pivot <<" 피벗 값 :" << array[pivot] << endl;

    // 왼쪽 포인터
    int i = start;
    // 오른쪽 포인터
    int j = end;
    
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
            swap(array,i,j);
        }
    }

    // 피벗 위치 변경
    swap(array,pivot,j);

    // 피벗을 기준으로 나뉜 두 부분에 대해 재귀 호출
    doQuickSort(array, start, j - 1);
    doQuickSort(array, j + 1, end);
}

bool validateCondition(const vector<int>& arr) {
    int n = arr.size();

    for (int i = 1; i < n; i++) {
        if (arr[i-1] > arr[i]) {
            // 조건을 만족하지 않는 경우가 하나라도 발견되면 false 반환
            return false;
        }
    }

    // 모든 i, j에 대해 조건을 만족하는 경우 true 반환
    return true;
}

int main() {
    // 시드 값 설정
    srand(time(0));

    // 1에서 100 사이의 랜덤한 길이 생성
    int length = rand() % 100 + 1;

    // 랜덤한 배열 생성 및 초기화
    vector<int> randomArray(length);

    // 배열에 랜덤한 숫자 채우기
    for (int i = 0; i < length; ++i) {
        randomArray[i] = rand() % 100 + 1;  // 1에서 100 사이의 랜덤한 숫자로 채우기
    }

    doQuickSort(randomArray, 0, randomArray.size() - 1);  // 배열의 시작 주소와 끝 인덱스 전달
    
    // 수행 이후의 결과 출력
    for (int k = 0; k < randomArray.size(); k++) {
        cout << randomArray[k] << " ";
    }
    cout << " 최종결과" << endl;
    
    // 조건 검증
    if (validateCondition(randomArray)) {
        cout << "배열이 조건을 만족합니다." << endl;
    } else {
        cout << "배열이 조건을 만족하지 않습니다." << endl;
    }

    return 0;
}
