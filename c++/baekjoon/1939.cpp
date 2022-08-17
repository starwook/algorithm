#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[10001];
int height[10001];
struct edge
{
    int u, v;
    int c;
};
bool compare(const edge &p1, const edge &p2)
{
    return p1.c > p2.c;
}

int find(int tt)
{
    if (arr[tt] == -1)
    {
        return tt;
    }
    else
    {
        return arr[tt] = find(arr[tt]);
    }
}
void unite(int a, int b)
{
    int g, p;
    g = find(a);
    p = find(b);

    if (height[g] > height[p])
    {
        arr[p] = g;
        
    }
    else if (height[p] > height[g])
    {
        arr[g] = p;
        
    }
    else
    {
        arr[p] = g;
        height[g]++;
        
    }
}
vector<edge> ed;

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    fill(arr, arr + 10001, -1);
    int n, m;
    cin >> n >> m;
    int st, end;

    for (int i = 0; i < m; i++)
    {
        int x, y, z;
        cin >> x >> y >> z;
        edge tmp;
        tmp.u = x;
        tmp.v = y;
        tmp.c = z;
        ed.push_back(tmp);
    }
    cin >> st >> end;
    sort(ed.begin(), ed.end(), compare);
    bool t = false;
    bool t1 = false;
    for (auto e : ed)
    {
        
        int u = e.u;
        int v = e.v;
        if (find(e.u) != find(e.v))
        { // 다른 트리라면
            unite(u, v);
        }
        if (u == st || v == st)
        {
           
            t = true;
        }
        if (u == end || v == end)
        {
            
            t1 = true;
        }
        if (t && t1)
        {
            
            if (find(st) == find(end))
            {
                cout << e.c;
                break;
            }
        }
    }

    return 0;
}
