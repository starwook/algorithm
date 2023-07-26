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
int arr[10001];
int dp[10001][2];
int n;
int main()
{
    cin >>n;
    for(int i=1;i<=n;i++){
        cin>>arr[i];
    }
    dp[1][0] = 0;
    dp[1][1] = arr[1];
    for(int i=2;i<=n;i++){
        dp[i][0] = max(dp[i-1][1],dp[i-1][0]);
        dp[i][1] = max(arr[i-1]+dp[i-2][0],dp[i-2][1]) +arr[i];
    }
    cout<<max(dp[n][1],dp[n][0]);



    return 0;
}
