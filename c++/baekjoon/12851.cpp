#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#include <map>
using namespace std;
int n, k;
int visited[100001];
int dist[100001];
int arr[100001];
int minNum = -1;
int howMuch;
map<int, int> m;
void check(int x)
{
}
void bfs(int a)
{

    visited[a] = 1;
    queue<int> que;
    que.push(a);
    while (!que.empty())
    {
        int x = que.front();
        que.pop();
        
        visited[x] = 1;
        if (x == k)
        {
            if (minNum == -1)
            {
                minNum = dist[x];
                howMuch++;
            }
            else if (minNum == dist[x])
            {

                howMuch++;
            }
        }
        int nx = x + 1;
        if (nx == 8 || nx == 9)
        {
            cout <<nx <<":nx,"<< x << ":x," << dist[nx] << "\n";
        }
        if (nx < 50 && !visited[nx])
        {
            que.push(nx);
            if(!dist[nx]){
                dist[nx] = dist[x] + 1;
            }
            else{
                dist[nx] = min(dist[nx] ,dist[x]+1);
            }
        }
        nx = x - 1;
        if (nx == 8 || nx == 9)
        {
            cout << nx << ":nx," << x << ":x," << dist[nx] << "\n";
        }
        if (nx >= 0 && !visited[nx])
        {
            que.push(nx);
            if(!dist[nx]){
                dist[nx] = dist[x] + 1;
            }
            else
            {
                dist[nx] = min(dist[nx], dist[x] + 1);
            }
        }
        nx = x * 2;
        if (nx == 8 || nx == 9)
        {
            cout << nx << ":nx," << x << ":x," << dist[nx] << "\n";
        }
        if (nx < 50&& !visited[nx])
        {
            que.push(nx);
            if (!dist[nx])
            {
                dist[nx] = dist[x] + 1;
            }
            else
            {
                dist[nx] = min(dist[nx], dist[x] + 1);
            }
        }
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> k;
    if (n == k)
    {
        cout << "0\n1";
    }
    else
    {
        bfs(n);
        cout << minNum << "\n"
             << howMuch;
    }
    return 0;
}
