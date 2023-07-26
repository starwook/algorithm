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
int n;
int arr[101];
long long dp[101][21];
int target;
int main()
{
    cin >>n;
    for(int i=1;i<=n;i++){
        cin >>arr[i];
    }
    dp[1][arr[1]] = 1;
    target = arr[n];
    for (int i = 2; i <n; i++)
    {
        for(int j=0;j<21;j++){
            if(dp[i-1][j]){
                long long minus = j-arr[i];
                long long plus = j+arr[i];
                if(minus>=0&&minus<=20){
                    dp[i][minus] +=dp[i-1][j];
                }
                if (plus >= 0 && plus <= 20)
                {
                    dp[i][plus] +=dp[i - 1][j];
                }
            }
        }
    }
    cout<<dp[n-1][target];
    return 0;
}
