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
int n,m,s,e;
int arr[2001];
int dp[2001][2001];
int check(int a,int b){
    if(a>=b){
        return 1;
    }
    if(dp[a][b] ==-1){
        if(arr[a] ==arr[b]){
            dp[a][b] = check(a+1,b-1);
            return dp[a][b];

        }
        else{
            dp[a][b] = 0;
            return dp[a][b];
        }
    }
    else{
        return dp[a][b];
    }
    

}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n;
    for(int i=1;i<=n;i++){
        cin >>arr[i];
    }
    for(int i=1;i<=n;i++){
        
        for(int j=1;j<=n;j++){
            dp[i][j] =-1;
        }
    }
    for(int i=1;i<=n;i++){
        check(i,i);
    }
    cin>>m;
    for(int i=0;i<m;i++){
        cin >>s>>e;
        cout<<check(s,e)<<"\n";
    }
    return 0;
}
