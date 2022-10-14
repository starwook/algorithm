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
int maxDistance;
int endPoint;
int visited[10001];
int dist[10001];
int n;
vector<pair<int,int > > vec[10001];
void dfs(int a,int b){
    int maxNum = 0;
    if(visited[a]){
        return ;
    }
    if(maxDistance<b){
        maxDistance =b;
        endPoint =a;
    }
    visited[a] =1;
    for(int i=0;i<vec[a].size();i++){

        dfs(vec[a][i].first,b+vec[a][i].second);
    }

}
int main()
{
    cin >>n;
    for(int i=0;i<n-1;i++){
        int a,b,c;
        cin >>a>>b>>c;
        vec[a].push_back(make_pair(b,c));
        vec[b].push_back(make_pair(a,c));
    }
    dfs(1,0);
    memset(visited,0,sizeof(visited));
    dfs(endPoint,0);
    cout <<maxDistance;
    return 0;
}
