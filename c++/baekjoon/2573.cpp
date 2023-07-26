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
int arr[301][301];
int nowChanged[301][301];
int visited[301][301];
int xi[4] ={-1,1,0,0};
int yi[4] ={0,0,-1,1};
int n,m;
int cnt;
int iceCnt;
bool oneRemain;
bool twoDevided =false;
void lowIce(int a,int b){
    if(nowChanged[a][b]){
        return;
    }
    for(int i=0;i<4;i++){
        int x = a +xi[i];
        int y = b +yi[i];
        if(x>=1&&x<=n&&y>=1&&y<=m){
            if(arr[x][y] >=1){
                arr[x][y]--;
                if(arr[x][y] ==0){
                    nowChanged[x][y] =1;
                }
            }
        }
    }
}
void bfs(int a,int b){
    queue<pair<int,int> > que;
    que.push(make_pair(a,b));
    visited[a][b] =1;
    while(!que.empty()){
        int oldx = que.front().first;
        int oldy = que.front().second;
        que.pop();
        for(int i=0;i<4;i++){
            int x = oldx+xi[i];
            int y = oldy+yi[i];
            if (x >= 1 && x <= n && y >= 1 && y <= m)
            {
                if(arr[x][y] >=1){
                    // cout << visited[x][y]<<" visited,"<<x << "," << y << "\n";
                    if(!visited[x][y]){
                        
                        visited[x][y] =1;
                        que.push(make_pair(x,y));
                    }
                }
            }
        }
    }


}
void show(){
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            cout <<arr[i][j]<<" ";
        }
        cout<<"\n";
    }
}
int main()
{
    cin >>n>>m;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cin >>arr[i][j];
        }
    }
   
    while(true){
        
        memset(visited,0,sizeof(visited));
        memset(nowChanged, 0, sizeof(nowChanged));
        oneRemain =false;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (arr[i][j] >= 1)
                {
                    oneRemain =true;
                }
            }
        }
        if(!oneRemain){
            break;
        }
        cnt++;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (arr[i][j] == 0)
                {
                    lowIce(i, j);
                }
            }
        }
        iceCnt =0;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (arr[i][j] >= 1)
                {
                    if(!visited[i][j]){
                        iceCnt++;
                        bfs(i, j);
                    }
                }
            }
        }
        // cout <<iceCnt<<":iceCnt\n";
        if (iceCnt >= 2)
        {
            twoDevided = true;
            break;
        }
    }
    if(twoDevided){
        cout <<cnt;
    }
    else{
        cout <<"0";
    }
    // cout << "\n";
    // show();
    return 0;
}
