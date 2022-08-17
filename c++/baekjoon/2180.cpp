#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
vector<pair<int, int> > pq;
bool compare(const pair<int, int> &a, const pair<int, int> &b)
{
    if (a.first == b.first)
    {
        return a.second > b.second;
    }
    return a.first < b.first;
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int tmp, tmp1;
        cin >> tmp >> tmp1;
        if (tmp1 != 0)
        {
            pq.push_back(make_pair(tmp, tmp1));
        }
    }

    sort(pq.begin(), pq.end(), compare);
    int total = 0;
    int time = 0;
    int size = pq.size();

    for (int i = 0; i < size; i++)
    {
        
        int t = pq.back().first * time + pq.back().second;
        total += t;
        total %= 40000;
        time = total;
        pq.pop_back();
    }
    cout << total;

    return 0;
}
