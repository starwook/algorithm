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
int arr[301][21];
int sub[301][21];
int cnt[20];
int dp[301][21];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        int tmp;
        cin >> tmp;
        for (int j = 1; j <= m; j++)
        {
            cin >> arr[i][j];
        }
    }
    for (int i = 1; i <= m; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if (dp[j][i] < dp[j][i - 1])
            {
                dp[j][i] = dp[j][i - 1];
                cnt[i] = 0;
            }
            for (int t = 1; t <= j; t++)
            {
                if(dp[j][i] <dp[j-t][i-1] +arr[t][i]){
                    dp[j][i] = dp[j - t][i - 1] + arr[t][i];
                    cnt[i] = t;
                    cnt[i-1] = j-t;
                } 
            }
        }
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            cout << dp[i][j] << " ";
        }
        cout <<"\n";
    }
    for(int i=1;i<=m;i++){

    }
    cout << dp[n][m]<<"\n";
    return 0;
}
