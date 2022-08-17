#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int parent[100001];
int height[100001];
int n;
void unite(int a, int b)
{
    if (height[a] > height[b])
    {
        parent[b] = a;
        height[a]++;
    }
    else if (height[b] > height[a])
    {
        parent[a] = b;
        height[b]++;
    }
    else
    {
        parent[a] = b;
        height[b]++;
    }
}
vector<pair<int, int>> pq;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n;
    for (int i = 1; i < n; i++)
    {
        int a, b;
        cin >> a >> b;
        pq.push_back(make_pair(a, b));
    }
    for (auto e : pq)
    {
        height[e.first]++;
        height[e.second]++;
    }
    int q;
    cin >> q;
    for (int i = 0; i < q; i++)
    {
        int tmp, tmp1;
        cin >> tmp >> tmp1;
        if (tmp == 1)
        {
            
            if (height[tmp1] >= 2)
            {
                cout << "yes\n";
            }
            else
            {
                cout << "no\n";
            }
        }
        else
        {
            
            
                cout << "yes\n";
            
        }
    }

    return 0;
}
