#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int k, n, f;
int check[901];
vector<int> vec[901];
int fri[901][901];
vector<int> now;
int par[901];
bool found = false;
// int find(int a){
//     if(par[a] == a){
//         return a;
//     }
//     else return par[a] = find(par[a]);
// }
// void unite(int a,int b){
//     if(a>b){
//         par[a] =b;
//     }
//     else{
//         par[b] =a;
//     }
// }
void bf(int inx, int sta)
{
    if(vec[inx].size()<k-1){
        return;
    }
    if (found)
    {
        return;
    }
    if (now.size() == k)
    {
        found = true;
        for (int i = 0; i < now.size(); i++)
        {
            cout << now[i] << "\n";
        }
        return;
    }
    for (int i = 0; i < now.size(); i++)
    {
    
        if (!fri[now[i]][inx])
        {
            return;
        }
    }
    now.push_back(inx);
    for (int i = 0; i < vec[inx].size(); i++)
    {
        int tmp = vec[inx][i];
        if (!check[tmp])
        {
            bf(tmp, sta + 1);
        }
    }
    now.pop_back();
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> k >> n >> f;
    for (int i = 1; i <= n; i++)
    {
        par[i] = i;
    }
    for (int i = 1; i <= f; i++)
    {
        int a, b;
        cin >> a >> b;
        // if(find(a) ==find(b)){
        //     int pa =find(a);
        //     int pb = find(b);
        //     unite(a,b);
        // }
        fri[a][b] = 1;
        fri[b][a] = 1;
        vec[a].push_back(b);
        vec[b].push_back(a);
    }
    for (int i = 1; i <= n; i++)
    {
        sort(vec[i].begin(), vec[i].end());
    }
    for (int i = 1; i <= n; i++)
    {
        bf(i, 0);
    }
    if (!found)
    {
        cout << "-1";
    }
    return 0;
}
