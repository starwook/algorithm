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

#define inf 987654321;
int n,m,start,to;
int visited[1001];
vector<pair<int,int> > vec[1001];
int main()
{
    cin >>n>>m;
   
    for(int i=0;i<m;i++){
        int a,b,c;
        cin >>a>>b>>c;
        vec[a].push_back(make_pair(b,c));
    }
    cin >>start>>to;
    for(int i=1;i<=n;i++){
        visited[i] = inf;
        // cout<<visited[i]<<" ";
    }
    
    visited[start]=0;
    priority_queue<pair<int,int > > pq;
    pq.push(make_pair(0,start)); //pq활용을 위해서~
    while(!pq.empty()){
        int cost = -pq.top().first;
        int toWhere = pq.top().second;
        pq.pop();
        // if(visited[toWhere]!=cost){ // 지금 중간 기점으로 하는 곳을 이미 방문했다면? 방문하지 않더라도 이미 크다면? (이전에 갱신된 곳이라면 visited[toWhere] = cost가됨) 
        //     continue;
        // }
        for(int i=0;i<vec[toWhere].size();i++){
            int next = vec[toWhere][i].first;
            int ncost = vec[toWhere][i].second +cost;
            if(visited[next] >ncost){
                visited[next] =ncost;
                pq.push(make_pair(-ncost,next));
            }
            
        }
    }
    
    cout<< visited[to];
    return 0;
}
