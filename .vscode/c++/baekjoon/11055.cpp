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
int arr[1001];
int dp[1001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    for(int i=1;i<=n;i++){
        cin >>arr[i];
        dp[i] = arr[i];
    }
    for (int i = 2; i <= n; i++)
    {
        for(int j=1;j<i;j++){
            if(arr[i] >arr[j]){
                dp[i] = max(dp[i],arr[i] +dp[j]);
            }
        }
    }
    int mx = dp[1];
    for(int i=1;i<=n;i++){
        mx = max(mx,dp[i]);
    }
    cout<<mx;
    return 0;
}
