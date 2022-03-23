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
int arr[101][101];
const int INF= 987654321;
int avail[101][101];
int n, m;
set<int> city;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < 101; i++)
    {
        for (int j = 0; j < 101; j++)
        {
            if (i == j)
            {
                arr[i][j] = 0;
            }
            else
            {
                arr[i][j] = INF;
            }
        }
    }
    for (int i = 0; i < m; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        arr[a][b] = min(arr[a][b],c);
        avail[a][b] =1;
    }

    for (auto i =1;i<=n;i++)
    {
        int standard = i;
        for (auto j =1;j <= n; j++)
        {
            int change = j;
            for (auto t = 1; t <= n; t++)
            {
                int end = t;
                if(avail[change][standard]&&avail[standard][end]){
                    avail[change][end] =1;
                    if (arr[change][end] > arr[change][standard] + arr[standard][end])
                    {
                        arr[change][end] = arr[change][standard] + arr[standard][end];
                    }
                }
            }
        }
    }
    for (auto i = 1; i <= n; i++)
    {
        for (auto j =1;j<=n;j++)
        {
            if(arr[i][j] == INF){
                arr[i][j] =0;
            }
            cout<< arr[i][j] <<" ";
            
        }
        cout <<"\n";
    }

    return 0;
}
