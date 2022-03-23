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
int arr[1501][1501];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    priority_queue<int, vector<int>, greater<int>> pq;
    set<int> st;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            int tmp;
            cin >> tmp;
            pq.push(tmp);
            if (pq.size() > n)
            {
                pq.pop();
            }
        }
    }
    cout << pq.top();
    return 0;
}
