import sys


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
    if is_uniform(array, x, y, size):
        if array[x][y] == 0:
            return [1, 0]  # 하얀색 (0)
        else:
            return [0, 1]  # 파란색 (1)
    else:
        # 4등분으로 나누어 재귀 호출
        half_size = size // 2
        result1 = solve(array, x, y, half_size)  # 왼쪽 위
        result2 = solve(array, x, y + half_size, half_size)  # 오른쪽 위
        result3 = solve(array, x + half_size, y, half_size)  # 왼쪽 아래
        result4 = solve(array, x + half_size, y + half_size, half_size)  # 오른쪽 아래

        white = result1[0] + result2[0] + result3[0] + result4[0]
        blue = result1[1] + result2[1] + result3[1] + result4[1]

        return [white, blue]


# 현재 영역이 모두 같은 값으로 이루어져 있는지 확인하는 함수
def is_uniform(array, x, y, size):
    color = array[x][y]
    for i in range(x, x + size):
        for j in range(y, y + size):
            if array[i][j] != color:
                return False
    return True


if __name__ == "__main__":
    main()
