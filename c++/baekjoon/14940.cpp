#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[1001][1001];
int g[1001][1001];
int visited[1001][1001];
int n, m;
int x[4] = {-1, 1, 0, 0};
int y[4] = {0, 0, -1, 1};
int sr, sc;
void bfs(int r, int c, int cnt)
{
    g[r][c] = 0;
    visited[r][c] = 1;
    queue<pair<int, int> > pq;
    pq.push(make_pair(r, c));
    while (!pq.empty())
    {
        for (int i = 0; i < 4; i++)
        {
            int xi = pq.front().first + x[i];
            int yi = pq.front().second + y[i];
            if (xi >= 0 && xi < n && yi >= 0 && yi < m)
            {
                if (arr[xi][yi])
                {
                    if (!visited[xi][yi])
                    {
                        g[xi][yi] = g[pq.front().first][pq.front().second] + 1;
                        pq.push(make_pair(xi, yi));
                    }
                }
                visited[xi][yi] = 1;
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
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> arr[i][j];
            if (arr[i][j] == 2)
            {
                sr = i;
                sc = j;
            }
        }
    }
    bfs(sr, sc, 0);
    for(int i=0;i<n;i++){
        for(int j =0;j<m;j++){
            if(!arr[i][j]){
                cout <<"0 ";
            }
            else if(visited[i][j]){
                cout << g[i][j] <<" ";
            }
            else{
                cout <<"-1 ";
            }
            
            
        }
        cout <<"\n";
    }
    return 0;
}
