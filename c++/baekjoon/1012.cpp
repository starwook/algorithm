#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int visited[51][51];
int be[51][51];
int row[4] = {-1, 1, 0, 0};
int col[4] = {0, 0, -1, 1};
int n, m, k;
int total = 0;
void dfs(int r, int c)
{

    for (int i = 0; i < 4; i++)
    {
        int x = r + row[i];
        int y = c + col[i];
        if (x >= 0 && x < n && y >= 0 && y < m)
        {
            if (be[x][y] == 1)
            {
                be[x][y] =0;
                dfs(x, y);
                
            }
        }
    }
    
}

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int t;
    cin >> t;
    while (t--)
    {

        for (int i = 0; i < 51; i++)
        {
            for (int j = 0; j < 51; j++)
            {
                be[i][j] = 0;
                visited[i][j] = 0;
            }
        }
        cin >> m >> n >> k;
        vector<pair<int, int> > vp;
        for (int i = 0; i < k; i++)
        {
            int a, b;
            cin >> a >> b;
            be[b][a] = 1;
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (be[i][j] == 1)
                {
                    total++;
                    dfs(i, j);
                }
            }
        }

        cout << total << "\n";
        total = 0;
    }

    return 0;
}
