#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#include <set>
#include <map>
using namespace std;
bool cmp(const pair<int, int> &a, const pair<int, int> &b)
{
    if (a.second == b.second)
    {
        return a.first < b.first;
    }
    else
    {
        return a.second > b.second;
    }
}
int check[101];
int arr[101];
int n, k;
int turn[101];
vector<pair<int, int>> vec;
int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> k;
    int total = 0;
    for (int i = 1; i <= k; i++)
    {
        cin >> turn[i];
    }
    int tmpsize = 0;
    for (int i = 1; i <= k; i++)
    {
        int tmp = turn[i];
        if (check[tmp])
        {
            continue;
        }
        else if (tmpsize < n)
        {
            check[tmp] = 1;
            tmpsize++;
        }
        else
        {
            // vec.clear();
            // fill(arr, arr + n + 1, 0);
            // for (int j = i+1; j <=k; j++)
            // {
            //     if (arr[turn[j]])
            //     {
            //         continue;
            //     }
            //     arr[turn[j]] = j;
            // }
            // for (int t = 1; t <= k; t++)
            // {
            //     if (check[t])
            //     {
            //         if(arr[t]==0){
            //             arr[t] = 200;
            //         }
            //         vec.push_back(make_pair(t, arr[t]));
            //     }
            // }
            // sort(vec.begin(), vec.end(), cmp);
            // check[vec[0].first] = 0;
            // check[tmp] = 1;
            int lastinx, tmpinx = 0;
            for (int t = 1; t <= k; t++)
            {
                if (check[t])
                {
                    int inx = -1;
                    for (int j = i+1; j <= k; j++)
                    {
                        if (t == turn[j])
                        {
                            inx = j;
                            break;
                        }
                    }
                    if (inx > tmpinx)
                    {
                        lastinx = t;
                        tmpinx = inx;
                    }
                }
            }
            total++;
            check[lastinx] = 0;
            check[tmp] = 1;
        }
    }
    cout << total;
    return 0;
}
