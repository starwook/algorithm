#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
char arr[101][101];
long long ar2[101][101];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            cin >> arr[i][j];
        }
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            ar2[i][j] = arr[i][j] - 48;
        }
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            ar2[i][j] += ar2[i][j - 1] + ar2[i - 1][j] - ar2[i - 1][j - 1];
        }
    } /*
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            cout << ar2[i][j] << " ";
        }
        cout << "\n";
    }*/
    int count = 0;

    for (int i = 1; i < n; i++)
    {
        for (int j = 1; j < m; j++)
        {
            count = max(count, ar2[i][j] * (ar2[i][m] - ar2[i][j]) * (ar2[n][m] - ar2[i][m]));

            count = max(count, ar2[i][j] * (ar2[n][j] - ar2[i][j]) * (ar2[n][m] - ar2[n][j]));
        }
    }
    for (int i = 1; i < n; i++)
    {
        count = max(count, ar2[n][1] * (ar2[i][m] - ar2[i][1]) * (ar2[n][m] - ar2[n][1] - (ar2[i][m] - ar2[i][1])));
    }
    for (int i = 1; i < m; i++)
    {
        count = max(count, ar2[1][m] * (ar2[n][i] - ar2[1][i]) * (ar2[n][m] - ar2[1][m] - (ar2[n][i] - ar2[1][i])));
    }
    for (int i = 1; i < m - 1; i++)
    {
        for (int j = i + 1; j < m; j++)
        {

            count = max(count, ar2[n][i] * (ar2[n][j] - ar2[n][i]) * (ar2[n][m] - ar2[n][j]));
        }
    }
    for (int i = 1; i < n - 1; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            count = max(count, ar2[i][m] * (ar2[j][m] - ar2[i][m]) * (ar2[n][m] - ar2[j][m]));
        }
    }

    cout << count;

    return 0;
}
