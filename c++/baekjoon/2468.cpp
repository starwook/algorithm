#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#include <set>
int arr[101][101];
int visited[101][101];
int xi[4] ={-1,1,0,0};
int yi[4] = {0,0,-1,1};
int waterHeight;
int n;
int ans=1;
using namespace std;
void bfs(int r,int c){
    queue<pair<int,int> > que;
    que.push(make_pair(r,c));
    visited[r][c] =1;
    while(!que.empty()){
        int x = que.front().first;
        int y = que.front().second;
        que.pop();
        for(int i=0;i<4;i++){
            int newX = x+xi[i];
            int newY = y+yi[i];
            if(newX>=1&&newX<=n&&newY>=1&&newY<=n){
                if(!visited[newX][newY]&&waterHeight<arr[newX][newY]){
                    que.push(make_pair(newX,newY));
                    visited[newX][newY] =1;
                }
            }
        } 
    }
}
int main()
{
    cin >>n;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin>>arr[i][j];
        }
    }
    for(int height=1;height<=100;height++){
        int cnt =0;
        waterHeight =height;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                visited[i][j] =0;
            }
        }
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if(!visited[i][j] && arr[i][j]>waterHeight){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        ans = max(ans,cnt);
    }
    cout<<ans;
    return 0;
}
