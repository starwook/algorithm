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
char arr[1000][1000];
int dp[1000][1000];
int n,m,answer;
int main()
{
    cin >>n>>m;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin >>arr[i][j];
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(arr[i][j]=='1'){
                dp[i][j] =1;
                if(i>0&&j>0){
                    int minValue =1000;
                    minValue = min(minValue,dp[i-1][j]);
                    minValue = min(minValue,dp[i-1][j-1]);
                    minValue = min(minValue,dp[i][j-1]);
                    dp[i][j] = minValue+1;
                    answer = max(answer,dp[i][j]);
                }
            }
        }
    }

    cout<< answer*answer;
    

    return 0;
}
