#include <cstdio>
using namespace std;

int map[15][15];
int total = 0;

void Input()
{
    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            scanf("%d", &map[i][j]);
            if (map[i][j])
                total++;
        }
    }
}

int ans = 0;

bool Check(int place, int num)
{
    int r = place / 10;
    int c = place % 10;
    for (int i = r; i < r + num; i++)
    {
        for (int j = c; j < c + num; j++)
        {
            if (map[i][j] == 0)
                return false;
        }
    }
    return true;
}

void Attach(int place, int num, int paper)
{
    int r = place / 10;
    int c = place % 10;
    for (int i = r; i < r + num; i++)
    {
        for (int j = c; j < c + num; j++)
        {
            map[i][j] = paper;
        }
    }
}

int paper[] = {0, 5, 5, 5, 5, 5};

void DFS(int place, int used, int cnt)
{
    if (used >= ans)
        return;
    if (cnt == 0)
    {
        ans = used;
        return;
    }
    if (place >= 100)
        return;

    int r = place / 10;
    int c = place % 10;
    if (map[r][c] == 1)
    {
        for (int i = 5; i >= 1; i--)
        {
            if (paper[i] == 0)
                continue;
            if (Check(place, i))
            {
                Attach(place, i, 0);
                paper[i]--;
                DFS(place + i, used + 1, cnt - i * i);
                paper[i]++;
                Attach(place, i, 1);
            }
        }
    }
    else
    {
        DFS(place + 1, used, cnt);
    }
}
int main()
{
    //freopen("sample_input.txt", "r", stdin);
    Input();

    ans = 0x7ffffff;
    DFS(0, 0, total);
    printf("%d\n", (ans == 0x7ffffff) ? -1 : ans);
}