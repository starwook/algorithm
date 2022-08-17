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
vector<int> vec[100001];
int f,s;
int n,m,k;
int parent[100001];
vector<pair<int,int> >pq;
void bfs(int a ,int b){
    for(int i=0;i<vec[b].size();i++){
        vec[a].push_back(vec[b][i]);
        bfs(a,vec[b][i]);
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin>>n>>m>>k;
    for(int i=1;i<=m;i++){
        int a,b;
        
        cin>>a>>b;
        pq.push_back(make_pair(a,b));
        vec[a].push_back(b);
        vec[b].push_back(a);
    }
    f = pq[k-1].first;
    s = pq[k-1].second;
    bfs(f,vec[f][0]);
    bfs(s,vec[s][0]);
    return 0;
}
