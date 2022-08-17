#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int n, k;
int visited[9];
int cnt = 0;
vector<int> vec;
void check(int depth, int g)
{
    if (g < 500)
    {
        return;
    }
    if (depth == n)
    {
        cnt++;
        return;
    }
    for (int i = 0; i < vec.size(); i++)
    {
        if (!visited[i])
        {
            visited[i] = 1;
            g = g + vec[i] - k;
            // cout << i + 1 << " ";
            // cout << "\n"
            //      << depth + 1 << "=depth\n";
            check(depth + 1, g);
            g = g - vec[i] + k;
            visited[i] = 0;
        }
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> k;

    for (int i = 0; i < n; i++)
    {
        int tmp;
        cin >> tmp;
        vec.push_back(tmp);
    }
    // for(int i=0;i<vec.size();i++){
    //     cout << "벡터순서는 ";
    //     for (int j = 0; j < vec.size(); j++)
    //     {
    //         cout << vec[j] << " ";
    //     }
    //     cout << "\n";

    //     vec.push_back(vec[0]);
    //     vec.erase(vec.begin());
    // }
    check(0, 500);

    cout << cnt;
    return 0;
}
