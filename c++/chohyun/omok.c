
#include <stdio.h>
#define BSIZE 10         // Board size
#define SQUARE_STONE "□" // 바탕색이 검정이면 이게 검은색
#define ROUND_STONE "●"
#define CROSS "┼"
#define SQAURE 1 // 배열에 저장하는 값
#define SQUARE 1 // 오타 수정 2021.5.21.
#define ROUND -1
int isValid(int data[BSIZE][BSIZE], int row, int col)
{
    if (row < 0 || col < 0 || row >= BSIZE || col >= BSIZE)
        return 0;
    if (data[row][col] == 0)
        return 1;
    else
        return 0;
}
int getPosition(int pos[2])
{
    printf("행번호와 열번호를 입력하세요: ");
    if (scanf("%d%d", &pos[0], &pos[1]) == 2)
        return 1;
    else
        return 0;
}

void draw(int data[BSIZE][BSIZE])
{
    for (int i = 0; i < 10; i++)
    {
        printf(" %d", i);
    }
    printf("\n");

    for (int i = 0; i < BSIZE; i++)
    {
        printf("%d", i);
        for (int j = 0; j < BSIZE; j++)
        {
            if (data[i][j] == 0)
            {
                printf(CROSS " ");
            }

            else if (data[i][j] == SQUARE)
            {
                printf(SQUARE_STONE " ");
            }
            else
            {
                printf(ROUND_STONE " ");
            }
        }
        printf("\n");
    }
}

int count_h(int data[BSIZE][BSIZE], int row, int col)
{
    int count = 1;
    int i = row;
    int j = col;

    if (data[i][j] == ROUND)
    {
        while (j - 1 >= 0 && data[i][j - 1] == ROUND)
        {
            count++;
            j--;
        }
        int i = row;
        int j = col;
        while (j + 1 < BSIZE && data[i][j + 1] == ROUND)
        {
            count++;
            j++;
        }

        return count;
    }
    else
    {
        while (j - 1 >= 0 && data[i][j - 1] == SQUARE)
        {
            count++;
            j--;
        }
        int i = row;
        int j = col;
        while (j + 1 < BSIZE && data[i][j + 1] == SQUARE)
        {
            count++;
            j++;
        }

        return count;
    }
}

int win(int data[BSIZE][BSIZE], int row, int col)
{
    if (count_h(data, row, col) == 5)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int main()
{

    int board[BSIZE][BSIZE] = {
        0,
    }; // 전부 0으로 초기화.
    int turn = ROUND;
    int pos[2]; // 0번은 행번호, 1번은 열번호
    // 먼저 빈 판을 그려준다.
    draw(board);
    while (getPosition(pos))
    {
        if (isValid(board, pos[0], pos[1]))
        {
            board[pos[0]][pos[1]] = turn;
            draw(board);

            if (win(board, pos[0], pos[1]))
            {

                if (turn == SQUARE)
                {
                    printf("흑(%s)이 이겼습니다.\n", SQUARE_STONE);
                }
                else
                {
                    printf("백(%s)이 이겼습니다.\n", ROUND_STONE);
                }
                return 0;
            }

            turn = -turn;
        }
        else
        {
            printf("놓을 수 없는 위치입니다.\n");
            continue;
        }
    }

    return 0;
}