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
int arr[100001];
int n,k;
int minCnt = 100000;
priority_queue<pair<int,int> ,vector<pair<int,int> >,greater<pair<int,int> > > pq;
void dfs(int index,int cnt){
    if(index ==k){
        minCnt = min(minCnt,cnt);
        return;
    }
    if(arr[index] !=-1 && arr[index]<=cnt){
        return;
    }
    arr[index] = cnt;
    if(index-1>=1){
        dfs(index-1,cnt+1);
    }
    if(index+1<k){
        dfs(index+1,cnt+1);
    }
    if(index*2<=100001){
        dfs(index*2,cnt);
    }

}
int main()
{
    cin >>n>>k;
    memset(arr,-1,sizeof(arr));
    dfs(n,0);
    cout<<minCnt;


    return 0;
}
