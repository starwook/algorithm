#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int n, m;
int arr[9];
int ans[9];
int visited[9];
int tmp = -1;
vector<vector<int>> vec;
void dfs(int a, int b)
{
    if (b == m)
    {
        for (int i = 0; i < m; i++)
        {
            cout << ans[i] << " ";
        }
        cout << "\n";
    }
    for (int i = 0; i < n; i++)
    {
        if (!visited[i])
        {
            if (arr[i] == ans[b])
            {
                cout <<arr[i] <<" = "<< ans[b] <<"\n";
                continue;
            }

            ans[b] = arr[i];
            visited[i] = 1;
            dfs(i, b + 1);
            visited[i] = 0;
        }
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    sort(arr, arr + n);
    dfs(0, 0);
    return 0;
}
