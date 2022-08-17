#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[1001];
int height[1001];
int cnt;
int ans;
struct edge
{
    int u, v, c;
};
bool compare(const edge &p1, const edge &p2)
{
    return p1.c < p2.c;
}
vector<edge> ed;
int find(int a)
{
    if (arr[a] == -1)
    {
        return a;
    }
    else
    {
        return arr[a] = find(arr[a]);
    }
}
void unite(int a, int b)
{
    int t = find(a);
    int g = find(b);
    if (height[t] > height[g])
    {
        arr[g] = t;
    }
    else if (height[g] > height[t])
    {
        arr[t] = g;
    }
    else
    {
        arr[t] = g;
        height[g]++;
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n, m;
    cin >> n >> m;
    fill(arr, arr + 1001, -1);
    for (int i = 0; i < m; i++)
    {
        edge tmp;
        cin >> tmp.u >> tmp.v >> tmp.c;
        ed.push_back(tmp);
    }
    cnt = 0;
    ans = 0;
    sort(ed.begin(), ed.end(), compare);

    for (auto e : ed)
    {
        int a = e.u;
        int b = e.v;
        if (find(a) != find(b))
        {
            unite(a, b);
            cnt++;
            ans += e.c;
        }
        if (cnt == n - 1)
        {
            cout << ans;
            break;
        }
    }

    return 0;
}
