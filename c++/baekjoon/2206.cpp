#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <tuple>
using namespace std;
int row[4] = {-1, 1, 0, 0};
int col[4] = {0, 0, -1, 1};
int visited[1001][1001];
int arr[1001][1001];
int n,m;
int way;
int bfs(int r, int c){
    way =-1;

    queue<pair<int,int> > que;
    int turn =1;
    que.push(make_pair(r,c));
    while(!que.empty()){
        r = que.front().first;
        c = que.front().second;
        if(r == n &&c ==m){
            if(way =-1){
                
            }
        }
        if(r>=1 &&r<=n &&c>=1&&c<=m){
            if(!visited[r][c]){
                



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
            cin >>arr[i][j];
        }
    }
    cout <<bfs(1,1);

    return 0;
}
