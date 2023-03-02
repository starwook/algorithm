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
int arr[501][501];
int visited[501][501];
int maxCnt =1;
int x[4] = {-1, 1, 0, 0};
int y[4] = {0, 0, -1, 1};
int dfs(int r,int c){
    visited[r][c]++;
    for(int i=0;i<4;i++){
        int newR = r+x[i];
        int newC = c+y[i];
        if(newR>=1&&newR<=n&&newC>=1&&newC<=n){
            if(arr[newR][newC]>arr[r][c]){
                if(!visited[newR][newC]){
                    visited[r][c] = max(visited[r][c],1+dfs(newR,newC));
                }
                else{
                    visited[r][c] = max(visited[r][c],1+visited[newR][newC]);
                }
                maxCnt = max(maxCnt,visited[r][c]);

            }
        }
    }
    return visited[r][c];

}
int main()
{
    cin>>n;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin >>arr[i][j];
        }
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if(!visited[i][j]){
                dfs(i,j);
            }
        }
    }
    // for (int i = 1; i <= n; i++)
    // {
    //     for (int j = 1; j <= n; j++)
    //     {
    //         cout<<visited[i][j]<<" ";
    //     }
    //     cout<<"\n";
    // }
    cout<<maxCnt;
    return 0;
}
