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
const int INF = 987654321;
int dist[5001];
priority_queue<int> q;
vector<pair<int, int> > vec[5001];
tuple<int, int, int> tup[100001];
vector<pair<int, int>> example;
int from[5001];
int n, m, s, t;
int dijk(int a, int b)
{
    fill(dist, dist + 5001, INF);
    dist[s] = 0;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, a});

    while (!pq.empty())
    {
        int oridist = pq.top().first;
        int stand = pq.top().second;
        pq.pop();
        if (dist[stand] < oridist)
        {
            continue;
        }
        for (int i = 0; i < vec[stand].size(); i++)
        {
            int to = vec[stand][i].first;
            int cost = vec[stand][i].second;
            // if ((stand == example[b].first && to == example[b].second) || (stand == example[b].second && to == example[b].first))
            // {
            //     cost = 0;
            // }
            if (dist[to] > dist[stand] + cost)
            {
                from[to] = stand;
                dist[to] = dist[stand] + cost;
                pq.push({dist[to], to});
            }
        }
    }
    return dist[t];
}

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> m;
    int total = 0;
    for (int i = 0; i < m; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        example.push_back({a, b});
        vec[a].push_back(make_pair(b, c));
        vec[b].push_back(make_pair(a, c));
        total += c;
    }
    cin >> s >> t;
    int last = 0;
    for (int i = 0; i < m; i++)
    {
        last = max(last, total - dijk(s, i));
    }

    // for(int i=1;i<=n;i++){
    //     cout <<dist[i] <<" ";
    // }
    // cout<<"\n";
    // int trace = from[t];
    // vector<int> tracing;
    // tracing.push_back(t);
    // while(trace){
    //     tracing.push_back(trace);
    //     trace = from[trace];
    // }
    // priority_queue<int> last;
    // for(int i=tracing.size()-1;i>0;i--){
    //     // cout << tracing[i] << " " << tracing[i - 1] << "간의 거리 " << dist[tracing[i - 1]] - dist[tracing[i]] << "\n";
    //     last.push(dist[tracing[i-1]]-dist[tracing[i]]);
    // }

    // last.pop();
    // while(!last.empty()){
    //     total -=last.top();
    //     last.pop();
    // }

    cout << last;
    return 0;
}
