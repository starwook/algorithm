#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int be[31][31];
int af[31][31];
int visited[31][31];
int x[4] = {-1, 1, 0, 0};
int y[4] = {0, 0, -1, 1};
int cnt;
int n, m;
void bfs(int r, int c, int a, int b)
{
    queue<pair<int, int> > pq;
    pq.push(make_pair(r, c));

    while (!pq.empty())
    {
        visited[pq.front().first][pq.front().second] = 1;
        be[pq.front().first][pq.front().second] = b;
        for (int i = 0; i < 4; i++)
        {
            int xi = pq.front().first + x[i];
            int yi = pq.front().second + y[i];
            if (xi >= 1 && xi <= n && yi >= 1 && yi <= m)
            {
                if (!visited[xi][yi])
                {
                    if (be[xi][yi] == a)
                    {
                        pq.push(make_pair(xi, yi));
                    }
                }
            }
        }
        pq.pop();
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            cin >> be[i][j];
        }
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            cin >> af[i][j];
        }
    }
    cnt = 0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            if (be[i][j] != af[i][j])
            {
                cnt++;
                bfs(i, j, be[i][j], af[i][j]);
            }
        }
    }
    int bol = 1;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            if (be[i][j] != af[i][j])
            {
                bol = 0;
            }
        }
    }
    if (bol)
    {
        if (cnt == 1 || cnt == 0)
        {
            cout << "YES";
        }
        else
        {
            cout << "NO";
        }
    }
    else{
        cout <<"NO";
    }

    return 0;
}
