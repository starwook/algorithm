#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#define INF  1e12
using namespace std;
int n,m,d;
long long arr[200001];
long long dp[200001];
long long last;

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n,m;
    cin >>n>>m>>d;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>arr[i*m+j];
        }
    }
    for(int i=0;i<m;i++){
        dp[i] = arr[i];
        dp[i] = 0;
    }
    for(int i = m;i<n*m;i++){
        dp[i] = -INF;
        int x = i/m;
        int y = i%m;
        for(int j= x-d;j<=x-1;j++){
            for(int t = y-d;t<y+d;t++){
                if(j>=0 && t>=0 &&t<m){
                    if(x-j + abs(y-t)<=d){
                        dp[i] = max(dp[i], arr[i] * arr[j*m+t] + dp[j*m+t]);
                    }
                }
            }
        }
    }
    last = dp[n*m-1];
    for(int i= n*m-1;i>=n*m -m;i--){
        last = max(last,dp[i]);

    }
    // for (int i = 0; i < n; i++)
    // {
    //     for (int j = 0; j < m; j++)
    //     {
    //         cout << dp2[i * m + j] << " ";
    //     }
    //     cout << "\n";
    // }
    // for(int i=0;i<n;i++){
    //     for(int j=0;j<m;j++){
    //         cout <<dp[i*m+j]<<" ";
    //     }
    //     cout <<"\n";
    // }
    cout <<last;
    return 0;
}
