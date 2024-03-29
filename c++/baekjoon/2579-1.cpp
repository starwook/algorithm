#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[301];
int dp[301];
int n;
int high;

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    high =0;
    cin>>n;
    for(int i=1;i<=n;i++){
        cin>>arr[i];
    }
    high = 0;
    dp[1] = arr[1];
    dp[2] = arr[1]+arr[2];
    dp[3] = max(arr[1]+arr[3],arr[2]+arr[3]);
    for(int i=4;i<=n;i++){
        dp[i] = arr[i]+ max(dp[i-3]+arr[i-1],dp[i-2]);
        high = max(high,dp[i]);

    }
    cout <<dp[n];

    return 0;
}
