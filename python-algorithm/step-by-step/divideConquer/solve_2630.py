import sys

# 결과를 저장할 전역 변수 (하얀색 0과 파란색 1의 개수)
white = 0
blue = 0


def main():
    n = int(sys.stdin.readline())  # 입력받을 숫자의 개수

    # n줄에 걸쳐서 2차원 리스트 입력 받기
    array = []
    for _ in range(n):
        array.append(list(map(int, sys.stdin.readline().split())))

    # 문제 해결
    solve(array, 0, 0, n)

    # 결과 출력
    print(white)
    print(blue)


# 분할정복 함수
def solve(array, x, y, size):
    global white, blue

    # 현재 영역이 모두 같은 값인지 확인하는 함수
    if is_uniform(array, x, y, size):
        if array[x][y] == 0:
            white += 1  # 하얀색 (0)
        else:
            blue += 1  # 파란색 (1)
    else:
        # 4등분으로 나누어 재귀 호출
        half_size = size // 2
        solve(array, x, y, half_size)  # 왼쪽 위
        solve(array, x, y + half_size, half_size)  # 오른쪽 위
        solve(array, x + half_size, y, half_size)  # 왼쪽 아래
        solve(array, x + half_size, y + half_size, half_size)  # 오른쪽 아래


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
