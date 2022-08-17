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
char arr[1001][1001];
int n, m;
vector<pair<int,int > >vec;
int cnt = 99999999;
int visited[1001][1001];
int how[1001][1001];
bool found = false;
int bfs(int r,int c)
{
    
    
    int first =1;
    queue<pair<pair< int, int> ,int > > q;
    q.push(make_pair(make_pair(r,c),0));
    visited[r][c] =1;
    while(!q.empty()){
        int a = q.front().first.first;
        int b = q.front().first.second;
        int c = q.front().second;
        how[a][b] = ++cnt;
        
        for(int i=0;i<=4;i++){
            int x = a+row[i];
            int y = b+col[i];
            if(x>=1&&x<=n&&y>=0&&y<=m){
                if(!visited[x][y]){
                    if(arr[x][y] == '0'){
                        visited[x][y] =1;
                        how[x][y] = first++;
                        q.push(make_pair(make_pair(x, y),c));
                    }
                    else{
                        if(c==0){
                            visited[x][y] =1;
                            how[x][y] = first++;
                            q.push(make_pair(make_pair(x, y), 1));
                        }
                    }
                }
            }
        }
        q.pop();
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
            if(arr[i][j] =='1'){
                vec.push_back(make_pair(i,j));
            }
        }
    } 
    bfs(1,1);
    if(found){
        cout << cnt;
    }
    else{
        cout <<"-1";
    }
    

    return 0;
}
