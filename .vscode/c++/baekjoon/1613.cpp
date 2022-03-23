#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#include <set>
using namespace std;
int dist[401][401];
int n, k;
const int INF = 987654321;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> k;
    for (int i = 0; i < 401; i++)
    {
        for (int j = 0; j < 401; j++)
        {
            if (i == j)
            {
                dist[i][j] = 0;
                continue;
            }
            dist[i][j] = INF;
        }
    }
    while (k--)
    {
        int a, b;
        cin >> a >> b;
        dist[a][b] = 1;
    }
    for (int k = 1; k <= n; k++)
    {
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                
                if (dist[i][j] > dist[i][k] + dist[k][j])
                {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    int s;
    cin >> s;
    while (s--)
    {
        int a, b;
        cin >> a >> b;
        if (dist[a][b] != INF) //있을때
        {
            cout << "-1\n";
        }
        else if(dist[a][b] ==INF &&dist[b][a] ==INF){
            cout <<"0\n";
        }
        else if(dist[b][a] !=INF){
            cout <<"1\n";
        }
        
    }
    return 0;
}
