#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int m, n, h;
int arr[101][101][101];
int xi[6] = {-1, 1, 0, 0, 0, 0};
int yi[6] = {0, 0, -1, 1, 0, 0};
int zi[6] = {0, 0, 0, 0, -1, 1};
int visited[101][101][101];
int cnt;
int ans;
struct edge
{
    int xx, yy, zz;
};
queue<edge> pq;

void bfs()
{

    int tmp = pq.size();
    cnt = 0;
    ans = 0;
    while (!pq.empty())
    {
        int h1 = pq.front().xx;
        int i1 = pq.front().yy;
        int j1 = pq.front().zz;
        visited[h1][i1][j1] = 1;
        for (int i = 0; i < 6; i++)
        {
            int x = h1 + xi[i];
            int y = i1 + yi[i];
            int z = j1 + zi[i];
            if (x > 0 && x <= h && y > 0 && y <= n && z > 0 && z <= m)
            {

                if (!visited[x][y][z])
                {
                    if (arr[x][y][z] == 0)
                    {
                        arr[x][y][z] = 1;
                        edge ti;
                        ti.xx = x;
                        ti.yy = y;
                        ti.zz = z;
                        pq.push(ti);
                        cnt++;
                    }
                    visited[x][y][z] = 1;
                }
            }
        }
        pq.pop();
        tmp--;
        if (tmp == 0)
        {
            if (cnt != 0)
            {
                tmp = cnt;
                cnt = 0;
                ans++;
            }
        }
    }
    for (int b = 1; b <= h; b++)
    {
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {

                if (!visited[b][i][j]&&arr[b][i][j]==0)
                {
                    ans = -1;
                }
            }
        }
    }

    cout << ans;
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> m >> n >> h;
    bool first = true;
    for (int b = 1; b <= h; b++)
    {
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                cin >> arr[b][i][j];
                if (arr[b][i][j] == 1)
                {
                    edge ti;
                    ti.xx = b;
                    ti.yy = i;
                    ti.zz = j;
                    pq.push(ti);
                }
                else if (arr[b][i][j] == 0)
                {
                    first = false;
                }
            }
        }
    }
    if (first)
    {
        cout << "0";
    }
    else
    {
        bfs();
    }

    return 0;
}
