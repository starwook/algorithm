#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int arr[21][21];
int n;
int check[21];
int total = 0;
vector<int> vec;
int cnt = 999999999;
int checking()
{
    // for(int i=0;i<vec.size();i++){
    //     cout <<vec[i]<<" ";
    // }
    // cout <<"\n";
    int tmp = 0;
    int tmp1 = 0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if (check[i] && check[j])
            {
                // cout << i << " " << j << " 같은팀\n";
                tmp += arr[i][j];
            }
            if (!check[i] && !check[j])
            {
                // cout << i << " " << j << " 다른팀 \n";
                tmp1 += arr[i][j];
            }
        }
    }
    // cout <<tmp<<" = tmp\n";
    // cout<<tmp <<" "<<tmp1 <<"\n";
    return abs(tmp - tmp1);
}
void combi(int a, int b)
{
    if (b == n / 2)
    {
        // for (int i = 1; i < n; i++)
        // {
        //     if (check[i])
        //     {
        //         cout << i << " ";
        //     }
        // }
        // cout<<"현재배열\n";
        int tmp = checking();
        cnt = min(tmp, cnt);
        return;
    }
    for (int i = a; i <= n; i++)
    {
        check[i] = 1;
        combi(i + 1, b + 1);
        check[i] = 0;
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            cin >> arr[i][j];
            total += arr[i][j];
        }
    }
    int tmp = n / 2;
    combi(1, 0);
    cout << cnt;

    return 0;
}
