#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
long long arr[3][10001];
int n;
long long dp[10001];
long long cnt;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    dp[1] = 1;
    dp[2] = 2;
    for(int i=3;i<=n;i++){
         dp[i] = dp[i-1]*2+1;
    }
    cout <<dp[n];
    return 0;
}
