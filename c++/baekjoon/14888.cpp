#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int low = 1000000000;
int high = -1000000000;
int num[12];
int arr[4];
int t;
vector<int> v;
int cal(int cnt, int a)
{
    if (a == 0)
    {
        return cnt + num[t];
    }
    else if (a == 1)
    {
        return cnt - num[t];
    }
    else if (a == 2)
    {
        return cnt * num[t];
    }
    else
    {
        return cnt / num[t];
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        cin >> num[i];
    }
    for (int i = 0; i < 4; i++)
    {
        int tmp;
        cin >> tmp;
        for (int j = 0; j < tmp; j++)
        {
            v.push_back(i);
        }
        arr[i] = tmp;
    }
    t = 1;
    int cnt = num[t];
    do
    {
        t = 1;
        cnt = num[t];
        cout << "일단들어와쓰\n";
        for (int i = 0; i < v.size(); i++)
        {
            for(int g=0;g<arr[v[i]];g++)
            {
                t++;
                cnt = cal(cnt, v[i]);
                
            }
            
        }
        cout << cnt <<"=cnt\n";
        low = min(cnt, low);
        high = max(cnt, high);

    } while (next_permutation(v.begin(), v.end()));
    cout << high << "\n"
         << low;

    return 0;
}
