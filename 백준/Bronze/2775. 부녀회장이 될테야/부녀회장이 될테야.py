# 미리 0층과 각 층의 사람 수를 구해놓고 이용하는 방법
apt = [[0]*15 for _ in range(15)]

# 0층 초기화
for i in range(1, 15):
    apt[0][i] = i

# 나머지 층 수 계산
for i in range(1, 15):
    for j in range(1, 15):
        apt[i][j] = apt[i-1][j] + apt[i][j-1]

# 테스트 케이스 입력받아 출력
T = int(input())
for _ in range(T):
    k = int(input())
    n = int(input())
    print(apt[k][n])
