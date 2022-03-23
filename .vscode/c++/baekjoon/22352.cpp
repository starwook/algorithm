#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int be[31][31];
int af[31][31];
int visited[31][31];
int x[4] = {-1,1,0,0};
int y[4] = {0,0,-1,1};
int cnt;
int n,m;
void dfs(int r,int c,int a,int b){
    be[r][c] = b;
    for(int i=0;i<4;i++){
        int xi = r+x[i];
        int yi = c+y[i];
        if(xi>=1&&xi<=n&&yi>=1&&yi<=m){
            if(be[xi][yi] ==a){
                dfs(xi,yi,a,b);
            }
        }
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>m;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cin>>be[i][j];
        }
    }
     for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cin>>af[i][j];
        }
    }
    cnt =0;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(be[i][j]!=af[i][j]){
                cnt++;
                dfs(i,j,be[i][j],af[i][j]);
            }
        }
    }
    
    int bol = 1;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            if (be[i][j] != af[i][j])
            {
                bol = 0;
            }
        }
    }
    if (bol)
    {
        if (cnt == 1 || cnt == 0)
        {
            cout << "YES";
        }
        else
        {
            cout << "NO";
        }
    }
    else{
        cout <<"NO";
    }
    return 0;
}
