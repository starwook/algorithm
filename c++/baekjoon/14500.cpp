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

int visited[501][501];
int x[4] ={-1,1,0,0};
int y[4] = {0,0,-1,1};
int ans =0;
int n,m;
int ext(int r,int c){
    int tmp =0;
    int ans =0;
    for(int j=0;j<4;j++){
        for (int i = 0; i < 4; i++)
        {
            if(i==j){
                continue;
            }
            int xi = r + x[i];
            int yi = c + y[i];
            if (xi >= 1 && xi <= n && yi >= 1 && yi <= m)
            {
                if (!visited[xi][yi])
                {
                    tmp += arr[xi][yi];
                }
            }
        }
        ans = max(ans, tmp);
        tmp = 0;
    }
    return ans;
}
int dfs(int r,int c,int t,int g){
    if(t==4){
        return arr[r][c];
    }
    int tmp=0;
    for(int i=0;i<4;i++){
        int xi = r+x[i];
        int yi = c+y[i];
        if(xi >=1 &&xi<=n &&yi>=1&&yi<=m){
            if(!visited[xi][yi]){
                visited[xi][yi] =1;
                tmp = max(tmp,dfs(xi,yi,t+1,g));
                visited[xi][yi] =0;
            }
        }
    }
    return arr[r][c]+g+tmp;
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>m;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cin >>arr[i][j];
        }
    }
    
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            visited[i][j] =1;
            ans = max(ans,dfs(i,j,1,0));
            visited[i][j] =0;
            ans = max(ans,arr[i][j] +ext(i,j));
        }
    }
    cout<<ans;
    return 0;
}
