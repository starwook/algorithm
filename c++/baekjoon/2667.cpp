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
char arr[26][26];
int xi[4] ={-1,1,0,0};
int yi[4] = {0,0,-1,1};
int visited[26][26];
int total;
int n;
vector<int> vec;
void bfs(int r,int c,int cnt){
    
    queue<pair<int,int> > que;
    que.push(make_pair(r,c));
    visited[r][c] =1;
    while(!que.empty()){
        int x = que.front().first;
        int y = que.front().second;
        // cout << x <<"/"<< y<<"\n";
        for (int i = 0; i < 4; i++)
        {
            int newX = x + xi[i];
            int newY = y +yi[i];
            if(newX>=1&&newX<=n && newY>=1&&newY<=n){
                if(arr[newX][newY]=='1'&& !visited[newX][newY]){
                    visited[newX][newY]=1;
                    que.push(make_pair(newX,newY));
                    cnt++;
                }
            }
        }
        que.pop();
    }
    vec.push_back(cnt);
}
int main()
{
    cin >>n;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin>>arr[i][j];
        }
    }
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(arr[i][j]=='1'&&!visited[i][j]){
                bfs(i,j,1);
                total++;
            }
        }
    }
    cout<<total<<"\n";
    sort(vec.begin(),vec.end());
    for(int i=0;i<vec.size();i++){
        cout<<vec[i]<<"\n";
    }
    
    


    return 0;
}
