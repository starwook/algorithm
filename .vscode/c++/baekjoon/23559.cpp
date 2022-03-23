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
int n,x;
int arr[100001];
vector<pair<int ,int > > vec;
bool cmp(const pair<int,int>&a , const pair<int,int> &b){
    if(a.first ==b.first){
        return a.second >b.second;
    }
    return a.first >b.first;


}
bool desc(int a,int b){
    return a>b;
}
int cnt = 0;
int a_num,b_num;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>x;
    for(int i=1;i<=n;i++){
        int a,b;
        cin >>a>>b;
        arr[i] = a - b;
        cnt += b;
        x -=1000;
    }
    sort(arr+1,arr+n+1,desc);
    for(int i=1;i<=n;i++){
        if(arr[i]<=0){
            break;
        }
        if(x-4000 <0){
            break;
        }
        cnt+= arr[i];
        x = x-4000;
    }
    cout<<cnt;
    return 0;
}
