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
#define land 'L'
#define sea 'W'
char map[51][51];
int visited[51][51];
int xi[4] = {-1,1,0,0};
int yi[4] = {0,0,-1,1};
int distanceMap[51][51];
int n, m;
int ans;
void bfs(int r,int c,int cnt){
    queue<pair<pair<int,int>,int > > que;
    que.push(make_pair(make_pair(r,c),cnt));
    visited[r][c] =1;
    while(!que.empty()){
        int x = que.front().first.first;
        int y = que.front().first.second;
        int distance = que.front().second;
        distanceMap[x][c] =distance;
        ans = max(ans,distance);
        que.pop();
        for(int i=0;i<4;i++){
            int newX = x+xi[i];
            int newY = y+yi[i];
            if(newX>=1&&newX<=n&&newY>=1&&newY<=m){
                if(!visited[newX][newY]&&map[newX][newY] ==land){
                    que.push(make_pair(make_pair(newX,newY),distance+1));
                    visited[newX][newY]=1;
                }
            }
        }
    }

}
void resetVisited(){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            visited[i][j]=0;
        }
    }
}
int main()
{
    cin>>n>>m;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cin >>map[i][j];
        }
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            if(map[i][j] ==land){
                resetVisited();
                bfs(i,j,0);
            }
        }
    }
    cout<<ans;

    return 0;
}
