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
int arr[101][101];
int visited[101][101];
int range[101][101];
int xi[4] ={-1,1,0,0};
int yi[4] = {0,0,-1,1};
int dist[101][101];
int rangeCnt;
int ans;
void firstBfs(int a,int b){
    visited[a][b] =1;
    range[a][b] = rangeCnt;
    queue<pair<int,int > >que;
    que.push(make_pair(a,b));
    while(!que.empty()){
        int x = que.front().first;
        int y = que.front().second;
        que.pop();
        for(int i=0;i<4;i++){
            int newX = x+xi[i];
            int newY = y+yi[i];
            if(newX>=1&&newX<=n&&newY>=1&&newY<=n){
                if(visited[newX][newY]){
                    continue;
                }
                visited[newX][newY] =1;
                if(arr[newX][newY]==1){
                    range[newX][newY] =rangeCnt;
                    que.push(make_pair(newX,newY));
                }
            }
        }
    }
}
void secondBfs(int a,int b){
    int oriRange = range[a][b];
    visited[a][b] =1;
    queue<pair<int,int> > que;
    que.push(make_pair(a,b));

    while(!que.empty()){

        int x = que.front().first;
        int y = que.front().second;
        que.pop();
        for(int i=0;i<4;i++){
            int newX = x+ xi[i];
            int newY = y+ yi[i];
            if(newX>=1 &&newX<=n&&newY>=1&&newY<=n){
                // cout<<newX<<":newX,"<<newY<<":newY\n";
                if(visited[newX][newY])continue;
                visited[newX][newY] =1;
                if(arr[newX][newY] ==1){
                    if(range[newX][newY] != oriRange){
                        if(ans ==0 ||ans >dist[x][y]+1){
                            ans=dist[x][y]+1;
                            // cout<<ans<< ":갱신된 ans,"<<a<<":a,"<<b<<":b, to"<<newX<<":newX,"<<newY<<":newY\n";
                        }
                    }
                }
                if(arr[newX][newY] ==0){
                    visited[newX][newY] =1;
                    dist[newX][newY] = dist[x][y] +1;
                    que.push(make_pair(newX,newY));
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
            cin >> arr[i][j];
            
        }
    }
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(arr[i][j] ==1){
                if(!visited[i][j]){
                    rangeCnt++;
                    firstBfs(i,j);
                }
            } 
        }
    }
    // for (int i = 1; i <= n; i++)
    // {
    //     for (int j = 1; j <= n; j++)
    //     {
    //         cout<<range[i][j] <<" ";
    //     }
    //     cout<<"\n";
    // }

    memset(visited,0,sizeof(visited));
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(arr[i][j] ==1){
                memset(visited,0,sizeof(visited));
                memset(dist,0,sizeof(dist));
                secondBfs(i,j);
            }
        }
    }
    cout<<ans-1;
    return 0;
}
