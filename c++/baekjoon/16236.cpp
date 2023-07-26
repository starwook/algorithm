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
int n,m;
int sharkSize =2;
int eatCnt;
int cnt;
int xi[4] = {-1,1,0,0};
int yi[4] ={0,0,-1,1};
int arr[21][21];
int dist[21][21];
int visited[21][21];
int eatX,eatY;
int a, b;
void eat(){
    arr[eatX][eatY] = 0;
    cnt += dist[eatX][eatY];
    // cout<<dist[eatX][eatY]<<" :dist, "<<eatX<<":eatX, "<<eatY<<":eatY\n";
    a = eatX;
    b = eatY;
    eatCnt++;
    if(eatCnt ==sharkSize){
        sharkSize++;
        eatCnt =0;
    }
}
void bfs(int a,int b){
    queue<pair<int,int > > que;
    que.push(make_pair(a,b));
    visited[a][b]=1;
    while(!que.empty()){
        int oldX = que.front().first;
        int oldY = que.front().second;
        que.pop();
        for(int i=0;i<4;i++){
            int x = oldX+xi[i];
            int y = oldY+yi[i];
            if(x>=1&&x<=n&&y>=1&&y<=n){
                if(visited[x][y])continue;
                visited[x][y] =1;
                dist[x][y] = dist[oldX][oldY]+1;
                if(arr[x][y]<sharkSize ){
                    que.push(make_pair(x, y));
                    if(arr[x][y] !=0){
                        if (eatX == 0 && eatY == 0)
                        {
                            eatX = x;
                            eatY = y;
                        }
                        else
                        {
                            if (dist[eatX][eatY] > dist[x][y])
                            {
                                
                                eatX = x;
                                eatY = y;
                            }
                            else if (dist[eatX][eatY] == dist[x][y])
                            {
                                if (eatX > x)
                                {
                                    eatX = x;
                                    eatY = y;
                                }
                                else if (eatX == x)
                                {
                                    if (eatY > y)
                                    {
                                        
                                        eatX = x;
                                        eatY = y;
                                    }
                                }
                            }
                        }
                    }
                    // cout << x << ":x," << y << ":y\n";
                   
                }
                else if(arr[x][y] ==sharkSize){
                    que.push(make_pair(x,y));
                }
            }

        }
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    
    cin >>n;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin >>arr[i][j];
            if(arr[i][j] ==9){
                a =i;
                b =j;
            }
        }
    }
    while(true){
        // cout <<sharkSize<<":sharkSize, "<<eatCnt<<": eatCnt\n";
        memset(visited,0,sizeof(visited));
        memset(dist,0,sizeof(dist));
        arr[a][b] =0;
        bfs(a, b);
        if (eatX == 0 && eatY==0){
            break;
        }
        eat();
        eatX =0;eatY =0;
    }
    cout <<cnt;

    

    return 0;
}
