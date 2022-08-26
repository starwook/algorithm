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
int arr[501][501];
int dp[501][501];
int n, m;
int h;
int xi[4] = {-1, 1, 0, 0};
int yi[4] = {0, 0, -1, 1};
int dfs(int r, int c)
{
    //cout << r<< "= r,"<<c<<" = c,"<<" \n";
    if(r== n && c== m){
        //cout <<"도달";
        return 1;
    }
    if (dp[r][c] != -1)
    {
        return dp[r][c];
    }
    dp[r][c] = 0;
    for (int i = 0; i < 4; i++)
    {
        int newR = r + xi[i];
        int newC = c + yi[i];
        //cout << newR << " =newR, " << newC << " =newC\n";
        if(newR>0 && newR<=n &&newC >0 &&newC<=m){
            //cout << i << "=i\n";
            
            
            if(arr[r][c] > arr[newR][newC]){ 
                
                dp[r][c] += dfs(newR,newC);
            }
        }
    }
    return dp[r][c];
}
int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            cin >> arr[i][j];
            dp[i][j] =-1;
        }
    }
    //memset(arr,-1,sizeof(arr));
    memset(dp,-1,sizeof(dp));

    
    //cout<<endl;
    
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cout << dp[i][j] <<" ";
        }
        cout <<endl;
    }
    cout << dfs(1, 1);

    return 0;
}
