#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int n, e;
const int INF = 987654321;
int sToV1, sToV2, V1ToV2, V1ToN, V2ToN;
int N, E, v1, v2, res = INF;

int dist[801];
vector<pair<int, int> >  vec[801];
void dijk(int a)
{
    for (int j = 0; j <= n; j++)
    {
        dist[j] = INF;
    }

    priority_queue<pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> > > pq;
    dist[a] = 0;
    pq.push(make_pair(0, a));
    while (!pq.empty())
    {
        int curDist = pq.top().first;  //경유점 ~최종점까지의 거리
        int cur = pq.top().second; // 경유점
        pq.pop();
        for (int i = 0; i < vec[cur].size(); i++)
        {
            int next = vec[cur][i].first;  //s에서 갈 수 있는 곳 next
            int nextDist = vec[cur][i].second; //s와 x의 거리
            if (curDist + nextDist < dist[next])
            { //원래 지금 최종점까지 가는 거리보다 경유점
                dist[next] = curDist + nextDist;
                pq.push(make_pair(dist[next], next));
            }
        }
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> e;
    for (int i = 0; i < e; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        vec[a].push_back(make_pair(b, c));
        vec[b].push_back(make_pair(a, c));
    }
    int v1, v2;
    cin >> v1 >> v2;
    
    // for(int i=1;i<4;i++){
    //     for(int j=1;j<=n;j++){
    //         cout<<i<<"부터"<< j<<"까지 최단 경로 " << dist[i][j]<<"\n";
    //     }
    // }
    dijk(1);
    sToV1 = dist[v1];
    sToV2 = dist[v2];

    dijk(v1);
    V1ToV2 = dist[v2];
    V1ToN = dist[n];

    dijk(v2);
    V2ToN = dist[n];

    int res =INF;
    res = min(res, sToV1 + V1ToV2 + V2ToN);
    res = min(res, sToV2 + V1ToV2 + V1ToN);
    if (V1ToV2 == INF || res == INF)
        cout << -1;
    else
        cout << res;
    return 0;
}
