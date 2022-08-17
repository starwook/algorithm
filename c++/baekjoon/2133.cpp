#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int n;
long long dp[31];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    dp[1] =0;
    dp[2] = 3;
    dp[3] = 0;
    dp[4] = (3*3) + 2;
    if(n>=5){
        for (int i = 5; i <= n; i++)
        {
            if(!i%4){
                dp[i] = dp[i-4] *11 + 2*3*dp[i-6];
            }
            else if(!i%2){
                dp[i] = dp[i-2] *3 +2*dp[i-4];
            }
            else
            { //홀수라면
                dp[i] = 0;
            }
        }
    }
    cout<<dp[n];
    return 0;
}
