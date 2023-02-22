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
int arr[101][101];
int outAir[101][101];
int zeroVisited[101][101];
bool blocked = true;
int n,m;
int ans =0;
int x[4] ={-1,1,0,0};
int y[4] = {0,0,-1,1};
int cheezeCount =0;
int count =0;
vector<pair<int,int> >vec;
void bfs(int r,int c){
    queue<pair<int,int> > que;
    que.push(make_pair(r,c));
    while(!que.empty()){
        int xIndex= que.front().first;
        int yIndex = que.front().second;
        que.pop();
        if (zeroVisited[xIndex][yIndex])
        {
            continue;
        }
        zeroVisited[xIndex][yIndex] = 1;
        for(int i=0;i<4;i++){
            int newX =xIndex+x[i];
            int newY =yIndex+ y[i]; 
            if(newX>=1&&newX<=n &&newY>=1&&newY<=m){
                if(arr[newX][newY]==1){
                    outAir[newX][newY]++;
                }
                if(arr[newX][newY]==0 && zeroVisited[newX][newY] ==0){
                    que.push(make_pair(newX,newY));
                }
            }
        }
        
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin>>n>>m;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cin >>arr[i][j];
            if(arr[i][j]){
                cheezeCount++;
            }
        }
    }
    while(cheezeCount>0){
        memset(zeroVisited,0,sizeof(zeroVisited));
        memset(outAir,0,sizeof(outAir));
        bfs(1,1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(outAir[i][j] >=2){
                    arr[i][j] =0;
                    cheezeCount--;
                }
            }
        }
        ans++;
        
    }
    cout<<ans;
    
    // for (int i = 1; i <= n; i++)
    // {
    //     for (int j = 1; j <= m; j++)
    //     {
    //         cout<< zeroBlocked[i][j]<<" ";
    //     }
    //     cout<<"\n";
    // }
    return 0;
}
