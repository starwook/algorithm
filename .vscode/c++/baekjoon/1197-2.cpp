#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
using namespace std;
int parent[100001];
vector<pair<pair<int, int>, int>> vec;
bool compare(const pair<pair<int, int>, int> &p1, const pair<pair<int, int>, int> &p2)
{
    if (p1.second == p2.second)
    {
        return p1.first.first < p2.first.first;
    }

    return p1.second > p2.second;
}
int find(int a)
{
    if (parent[a] == 0)
    {
        return a;
    }
    return parent[a] = find(parent[a]);
}
void unite(int a, int b)
{
    a = find(a);
    b = find(b);
    parent[b] = a;
}

int main()
{

    int v, e;
    cin >> v >> e;
    while (e--)
    {
        int a, b, c;
        cin >> a >> b >> c;
        vec.push_back(make_pair(make_pair(a, b), c));
    }
    sort(vec.begin(), vec.end(), compare);

    int cnt = 0;
    int total = 0;
    while (true)
    {
        if (cnt == v-1)
        {
            break;
        }
        int a = vec.back().first.first;
        int b = vec.back().first.second;
        if (!(find(a) == find(b)))
        {
            unite(a, b);
            total += vec.back().second;
            cnt++;
        }
        vec.pop_back();
    }
    cout << total;
    return 0;
}