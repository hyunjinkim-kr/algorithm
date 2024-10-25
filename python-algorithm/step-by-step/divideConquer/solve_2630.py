import sys

# 문제 : 색종이 만들기

# 해결책 : 가장 최소단위 사각형에 대해 판별하고, 가로세로가 2등분 되기 전의 네 곳에 대해 동일한 색인지 확인한다.
#
# - N : 정사각형 색종이의 한 변 길이
# - array : 색종이의 형태가 저장되는 2차원배열
# - x : 행
# - y : 열
# - size : 탐색하는 종이의 범위
# - white : 흰색 (0) 정사각형의 개수
# - blue : 파란색 (1) 정사각형의 개수
#
## 알고리즘 설명
# 1. N 과 N 길이의 색종이 내용을 입력받아 array에 저장한다.
# 2. 색종이 사이즈가 1인경우, x,y에 해당하는 array의 숫자가 0이면 [1,0]을, 1이면 [0,1]을 리턴한다. 사이즈가 1이 아닌경우, 아래 과정을 반복한다.
#  2-1 사이즈를 2로 나눈후, 초기 크기의 4등분 크기의 사각형에 대해 재귀하며 계산한다.
#  2-2 각 사각형의 결과가 모두 같은경우, 리턴된 배열의 0번째 값이 1이면 흰색, 1번째 값이 1이면 파란색을 리턴한다.
#    e.g) 0일떄 return [1,0]
#  2-3 모두 같지 않은경우 white에 모든 사각형의 0번째 값을 합하고, blue에 모든 사각형의 1번째 값을 합하여 리턴한다.
# 3. white 와 blue를 출력한다.
#
#
# -- 시간복잡도 O(N^2)


def main():
    n = int(sys.stdin.readline())  # 입력받을 숫자의 개수

    # n줄에 걸쳐서 2차원 리스트 입력 받기
    array = []
    for _ in range(n):
        split_input = sys.stdin.readline().split()
        mapped_input = map(int, split_input)
        list_input = list(mapped_input)
        array.append(list_input)

    # 문제 해결
    result = solve(array, n)

    # 결과 출력
    print(result[0])
    print(result[1])


def solve(array, n):
    return solve_inner(array, 0, 0, n)


# 분할정복 함수
def solve_inner(array, x, y, size):
    # 현재 영역이 모두 같은 값인지 확인하는 함수
    if size == 1:
        if array[x][y] == 0:
            return [1, 0]  # 하얀색 (0)
        else:
            return [0, 1]  # 파란색 (1)
    # 4등분으로 나누어 재귀 호출
    half_size = size // 2
    result1 = solve_inner(array, x, y, half_size)  # 왼쪽 위
    result2 = solve_inner(array, x, y + half_size, half_size)  # 오른쪽 위
    result3 = solve_inner(array, x + half_size, y, half_size)  # 왼쪽 아래
    result4 = solve_inner(array, x + half_size, y + half_size, half_size)  # 오른쪽 아래
    # 네 부분에서 얻은 결과를 합산
    white = result1[0] + result2[0] + result3[0] + result4[0]
    blue = result1[1] + result2[1] + result3[1] + result4[1]

    # 만약 4개의 구역이 모두 동일하다면, 그 구역을 하나로 합칠 수 있음
    if result1 == result2 == result3 == result4:
        # 만약 4개의 하위 구역이 모두 하얀색 혹은 파란색일 경우
        if result1[0] == 1:  # 모두 하얀색(0)
            return [1, 0]
        elif result1[1] == 1:  # 모두 파란색(1)
            return [0, 1]

    # 그렇지 않으면 그대로 합산된 결과를 반환
    return [white, blue]


if __name__ == "__main__":
    main()
