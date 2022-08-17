#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int v, e;
int visited[20001];
int dist[20001];
vector<vector<pair<int, int>>> vec;
void dj(int a)
{
   

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    dist[a] = 0;
    pq.push(make_pair(0, a));
    while (!pq.empty())
    {
        int f = pq.top().first;  //경유점 ~최종점까지의 거리
        int s = pq.top().second; // 경유점
        pq.pop();
        if (f > dist[s])
        { // 이미 정해진 기준점까지의 거리보다 새로 들어온 거리가 더 크다면
            continue;
        }
        for (int i = 0; i < vec[s].size(); i++)
        {
            int x = vec[s][i].first;  //s에서 갈 수 있는 곳 x
            int y = vec[s][i].second; //s와 x의 거리
            if (dist[s] + y < dist[x])
            { //원래 지금 최종점까지 가는 거리보다 경유점
                dist[x] = dist[s] + y;
                pq.push(make_pair(dist[x], x));
            }
        }
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> v >> e;
    int start;
    cin >> start;
    vec.resize(v + 1);
    fill(dist, dist + v + 1, 9999999);
    for (int i = 0; i < e; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        vec[a].push_back(make_pair(b, c));
    }
    dj(start);
    for (int i = 1; i <= v; i++)
    {
        if (dist[i] == 9999999)
        {
            cout << "INF\n";
        }
        else
        {
            cout << dist[i] << "\n";
        }
    }

    return 0;
}
