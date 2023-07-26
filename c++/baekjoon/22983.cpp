#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int cnt = 0;
char arr[3001][3001];
int dp[3001][3001];
int check(int n,int m){
    if(n<=0 ||m<=0){
        return 0;
    }
    if(n==1 &&m==1){
        dp[n][m] =1;
        return 1;
    }
    if(dp[n][m]){
        return dp[n][m];
    }
    dp[n][m] = check(n-1,m)+check(n,m-1)-check(n-1,m-1)+1;
    if(n>1 &&m>1){
        if(arr[n][m] !=arr[n-1][m] &&arr[n][m] !=arr[n][m-1]){
            if(n==m){
                dp[n][m] +=n-1;
            }
            else{
                dp[n][m] += 1;
            }
        }
    }
    return dp[n][m];

}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n,m;
    cin>>n>>m;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cin >> arr[i][j];
        }
    }
    cout <<check(n,m);

    return 0;
}
