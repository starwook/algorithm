#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[1001][1001];
int x[4] = {1, 0};
int y[4] = {0, 1};
int n;
int visited[1001][1001];
int parent[180001];
int height[1000001];
struct edge
{
    int u,v,p;
};
bool compare(const edge &p1, const edge &p2)
{
    return p1.p < p2.p;
}
vector<edge> ed;
int check(int r,int c){
    return n*(r-1)+c;
}

void bfs(int a, int b)
{
    queue<pair<int, int> > pq;
    pq.push(make_pair(a, b));
    while(!pq.empty()){
        if (!visited[pq.front().first][pq.front().second])
        {
            for (int i = 0; i < 2; i++)
            {
                int xi = x[i] + pq.front().first;
                int yi = y[i] + pq.front().second;
                if (xi >= 1 && xi <= n && yi >= 1 && yi <= n)
                {
                    
                    pq.push(make_pair(xi, yi));
                    edge tmp;
                    tmp.u =check(pq.front().first,pq.front().second);
                    tmp.v = check(xi,yi);
                    tmp.p = abs(arr[pq.front().first][pq.front().second] - arr[xi][yi]);
                    ed.push_back(tmp);
                    
                }
            }
        }
        visited[pq.front().first][pq.front().second] = 1;
        
        pq.pop();
    

    }
 
}
int find(int a){
    if(parent[a] ==-1){
        return a;
    }
    else{
        return parent[a]= find(a);
    }

}
void unite(int a,int b){
    int u = find(a);
    int v = find(b);
    if(height[u]>height[v]){
        parent[v] = u;
    }
    else if(height[v]>height[u]){
        parent[u] = v;
    }
    else{
        parent[u] = v;
        height[v]++;
    }

}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    fill(parent,parent+180001,-1);

    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            cin >> arr[i][j];
        }
    }
    
    bfs(1, 1);
    
    
    
    for (int i=0; i<ed.size();i++)
    {
        if(find(ed[i].u) != find(ed[i].v)){
            unite(ed[i].u,ed[i].v);
        }
        if(find(1) == find(n*n)){
            cout <<ed[i].p;
            break;
        }
    }
    

    return 0;
}
