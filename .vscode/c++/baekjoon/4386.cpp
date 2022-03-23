#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int parent[101];
float ans = 0;
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
vector<pair<float, float> > vec;
vector<pair<pair<int, int>, float> > rv;

float cal(pair<float, float> p1, pair<float, float> p2)
{
    float a = abs(p1.first - p2.first);
    float b = abs(p1.second - p2.second);
    return sqrt(a * a + b * b);
}
bool compare(const pair<pair<int, int>, float> &p1, const pair<pair<int, int>, float> &p2)
{
    if (p1.second == p2.second){
        return p1.first.first <p2.first.first;
    }
    return p1.second >p2.second;
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        float a, b;
        cin >> a >> b;
        vec.push_back(make_pair(a, b));
    }
    for (int i = 0; i < vec.size(); i++)
    {
        for (int j = i + 1; j < vec.size(); j++)
        {
            rv.push_back(make_pair(make_pair(i + 1, j + 1), cal(vec[i], vec[j])));
        }
    }
    sort(rv.begin(),rv.end(),compare);
    int total =0;
    
    while(true){
        if (total == n-1)
        {
            break;
        }
        int a = rv.back().first.first;
        int b = rv.back().first.second;
        if(!(find(a) == find(b))){
            ans += rv.back().second;
            unite(a,b);
            total++;
            
        }
        if(total ==n-1){
            break;
        }
        rv.pop_back();

    }
    cout <<fixed;
    cout.precision(2);
    cout << ans;
    return 0;
}
