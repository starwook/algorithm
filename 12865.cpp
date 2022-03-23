#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
vector<pair<int, int>> vec;
int n, k;
int w[101];
int v[101];
int dp[100001];

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    cin >> n >> k;
    for (int i = 1; i <= n; i++)
    {
        cin >> w[i] >> v[i];
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = k; j >= 1; j--)
        {
            if(j-w[i] >=0){
                dp[j] = max(dp[j-w[i]]+v[i],dp[j]);
            }
        }
    }
    
    
    cout<<dp[k];
    return 0;
}


