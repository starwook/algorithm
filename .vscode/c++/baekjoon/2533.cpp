#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int r, c;
int arr[17][17];
int cnt = 0;
int dp[17][17];
int stat[17][17][4];
int n;
vector<pair<pair<int, int>, int>> status;
// int topdown(int a, int b)
// {
//     if (dp[a][b])
//     {
//         return dp[a][b];
//     }
//     else if (a <= 0 || b <= 1)
//     {
//         return 0;
//     }
//     else if (arr[a][b] == 1)
//     {
//         return 0;
//     }
//     else
//     {
//         arr[a][b] = topdown(a - 1, b - 1) + topdown(a - 1, b) + topdown(a, b - 1);
//         return arr[a][b];
//     }
// }
bool check(int a, int b)
{
    if (a <= n && b <= n && arr[a][b] != 1)
    {
        return true;
    }
    else
    {
        return false;
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            cin >> arr[i][j];
        }
    }
    dp[1][2] = 1;
    stat[1][2][1] = 1;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 2; j <= n; j++)
        {
            if (stat[i][j][1])
            {
                if (check(i, j + 1))
                {
                    stat[i][j + 1][1] += stat[i][j][1];
                }
                if (check(i + 1, j) && check(i, j + 1) && check(i + 1, j + 1))
                {
                    stat[i + 1][j + 1][3] += stat[i][j][1];
                }
            }
            if (stat[i][j][2])
            {
                if (check(i + 1, j))
                {
                    stat[i + 1][j][2] += stat[i][j][2];
                }
                if (check(i + 1, j) && check(i, j + 1) && check(i + 1, j + 1))
                {
                    stat[i + 1][j + 1][3] += stat[i][j][2];
                }
            }
            if (stat[i][j][3])
            {
                if (check(i, j + 1))
                {

                    stat[i][j + 1][1] += stat[i][j][3];
                }
                if (check(i + 1, j))
                {
                    stat[i + 1][j][2] += stat[i][j][3];
                }
                if (check(i + 1, j) && check(i, j + 1) && check(i + 1, j + 1))
                {
                    stat[i + 1][j + 1][3] += stat[i][j][3];
                }
            }
        }
    }
    cout << stat[n][n][1] + stat[n][n][2] + stat[n][n][3];

    return 0;
}
