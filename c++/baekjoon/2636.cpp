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

#define notInOne 1;
#define inOne (2);
int r, c;
int arr[101][101];
int visited[101][101];
int oneStatus[101][101];
int xi[4] ={-1,1,0,0};
int yi[4] = {0,0,-1,1};
int cnt;
bool stop =false;
void oneBfs(int a, int b)
{

    queue<pair<int, int> > que;
    que.push(make_pair(a, b));
    visited[a][b]=1;
    while (!que.empty())
    {
        int oldx = que.front().first;
        int oldy = que.front().second;
        
        visited[oldx][oldy] =1;
        que.pop();
        for (int i = 0; i < 4; i++)
        {
            int x = oldx + xi[i];
            int y = oldy + yi[i];
            // cout << x << "," << y << "\n";
            if (x >= 1 && x <= r && y >= 1 && y <= c)
            {
                
                if(!visited[x][y]){
                    visited[x][y] =1;
                    if(arr[x][y] == 0){
                        oneStatus[x][y] =1;
                        que.push(make_pair(x,y));
                    }
                    if(arr[x][y] ==1){
                        arr[x][y] = 2;
                    }
                }
            }
        }
    }
}
int main()
{
    cin >>r>>c;
    for(int i=1;i<=r;i++){
        for(int j=1;j<=c;j++){
            cin >>arr[i][j];
        }
    }

    // while(!stop){
        
    // }
    for (int i = 1; i <= r; i++)
    {
        for (int j = 1; j <= c; j++)
        {
            if (i == 1 || i == r || j == 1 || j == c)
            {
                oneStatus[i][j] = 1;
            }
        }
    }
    int oneCnt =0;
    int tmp;
    tmp = oneCnt;
    while(true){
        
        
        bool stop = false;
        memset(visited,0,sizeof(visited));
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(arr[i][j] ==1 || arr[i][j] ==2){
                    stop = true;
                    oneCnt++;
                }
            }
        }
        // cout << oneCnt << ":oneCnt\n";
        if(!stop){
            
            break;
        }
        else{
            tmp = oneCnt;
        }
        oneBfs(1,1);
        cnt++;
        for (int i = 1; i <= r; i++)
        {
            for (int j = 1; j <= c; j++)
            {
                // cout << arr[i][j] << " ";
                if(arr[i][j] ==2){
                    arr[i][j] =0;
                }
            }
            // cout << "\n";
        }
        // cout <<"\n";
        oneCnt =0;
    }
   
    cout <<cnt <<"\n"<<tmp;
    

    
    

   
    return 0;
}
