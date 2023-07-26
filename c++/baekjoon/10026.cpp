#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#include <set>
#define GREEN 'G'
#define RED 'R'
#define BLUE 'B'
using namespace std;
int n;
char arr[101][101];
int visited[101][101];
int origin;
int colorBlind;
int x[4] = {-1, 1, 0, 0};
int y[4] = {0, 0, -1, 1};
int dfs(int r,int c,char chr){
    visited[r][c] =1;
    int tmpCnt =1;
    for(int i=0;i<4;i++){
        int newR = r+x[i];
        int newC = c+y[i];
        if(newR>=1&&newR<=n&&newC>=0&&newC<=n){
            if(!visited[newR][newC] && arr[newR][newC] ==chr){
                tmpCnt+= dfs(newR,newC,chr);
            }
        }
    }
    return tmpCnt;

}
int main()
{
    cin>>n;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin>>arr[i][j];
        }
    }
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(!visited[i][j]){
                origin++;
                dfs(i,j,arr[i][j]);
            }
        }
    }
    memset(visited,0,sizeof(visited));
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(arr[i][j] == RED){
                arr[i][j] = GREEN;
            }
        }
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if (!visited[i][j])
            {
                colorBlind++;
                dfs(i, j, arr[i][j]);
            }
        }
    }
    cout<< origin <<" "<<colorBlind;

    return 0;
}
