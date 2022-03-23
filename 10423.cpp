#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int parent[1001];
int check[1001];
int cnt;
vector<int> ele;
vector<pair<int, pair<int, int> > > vec;
int find(int a)
{
    if (parent[a] == 0)
    {
        return a;
    }
    parent[a] = find(parent[a]);
    return parent[a];
}
void unite(int a, int b)
{
    a = find(a);
    b = find(b);
    parent[a] =b;
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n, m, k;
    cin >> n >> m >> k;
    for (int i = 0; i < k; i++)
    {
        int tmp;

        cin >> tmp;
        ele.push_back(tmp);
        
    }
    for(int i=0;i<ele.size();i++){
        for(int j=i+1;j<ele.size();j++){
            unite(ele[i],ele[j]);

        }
        break;
    }
    for (int i = 0; i < m; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        vec.push_back(make_pair(c, make_pair(a, b)));
    }
    sort(vec.begin(), vec.end(), greater<pair<int, pair<int, int>>>());
    // for(auto it:vec){
    //     cout <<it.first <<"  "<< it.second.first <<" "<<it.second.second <<"\n";
    // }
    cnt = k;
    int total = 0;
    while (true)
    {
        if (cnt == n)
        {
            break;
        }
        int a =vec.back().second.first;
        int b = vec.back().second.second;
        if (find(a) != find(b))
        {
            unite(a, b);
            total += vec.back().first;
            cnt++;
        }
        vec.pop_back();
    }
    cout << total; 

    return 0;
}
