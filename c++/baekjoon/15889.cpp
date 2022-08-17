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
int n;
int arr[30001];
int dis[30000];
vector<pair<int, int> > vec;
bool found = false;
bool cmp(const pair<int, int> &a, const pair<int, int> &b)
{
    if (a.first == b.first)
    {
        return a.second > b.second;
    }
    return a.first < b.first;
}
void bf(int a){
    int next =a;
    int tmp = vec[a].first+vec[a].second; //현재 좌표 + 사거리 최대 = 갈 수 있는 곳
    // cout << "현재 최대 사거리는  ->" << tmp << " \n";
    if(tmp >=arr[n]){
        // cout<<tmp<<"=현재 사거리, "<<arr[n]<<" = 최종목표 ,찾았다\n";
        found =true;
        return;
    }
    for(int i=a;i<vec.size();i++){
        if(tmp >= vec[i].first){
            // cout<<i<<" 검사중\n";
            if(tmp < vec[i].first+vec[i].second){
                next = i;
                // cout<<"다음 후보는 ->"<<next<<" \n";
            }
        }
    }
    if(next ==a){
        return;
    }
    else{
        bf(next);
        return;
    }
    return;

}

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        cin >> arr[i];
    }
    sort(arr + 1, arr + n + 1);
    if (n > 1)
    {
        for (int i = 1; i <n; i++)
        {
            cin >> dis[i];
            vec.push_back(make_pair(arr[i], dis[i]));
        }
    }
    sort(vec.begin(), vec.end(), cmp);
    for(int i=0;i<vec.size();i++){
        // cout<<vec[i].first<<","<<vec[i].second<<"\n";
    }
    if(n==1){
        found = true;
    }
    else{
        bf(0);
    }
    if(found){
        cout<<"권병장님, 중대장님이 찾으십니다";
    }
    else{
        cout <<"엄마 나 전역 늦어질 것 같아";
    }
    return 0;
}
