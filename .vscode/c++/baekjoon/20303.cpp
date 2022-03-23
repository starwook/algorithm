#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[30001]; 
int height[30001];
int cost[30001];
int dp[30001];
int find(int a){
    if(arr[a] == 0){
        return a;
    }
    else{
        return arr[a] = find(arr[a]);
    }
}
bool compare (const pair<int, int>& p1,const pair<int, int>& p2){
    if(p1.second == p2.second){
        return p1.first<p2.first;
    }
    else{
        return p1.second > p2.second;
    }
}
void unite(int u,int v){
    int a = find(u);
    int b = find(v);
    if(height[a]>height[b]){
        cost[a] +=cost[b];
        arr[b] = a;
        height[a]++;
    }
    else if(height[b]>height[a]){
        cost[b] +=cost[a];
        arr[a] = b;
        height[b]++;
    }
    else{
        cost[a] +=cost[b];
        arr[b] = a;
        height[a]++;
    }
}
int n,m,k;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin>>n>>m>>k;
    for(int i=1;i<=n;i++){
        cin>>cost[i];
    }
    for(int i=0;i<m;i++){
        int a,b;
        cin>>a>>b;
        if(find(a) !=find(b)){
            unite(a,b);
        }
    }
    vector<pair<int, int> > pq;
    for(int i=1;i<=n;i++){
        if(arr[i] == 0){
            pq.push_back(make_pair(height[i]+1,cost[i]));
        }
    }
  
    
    sort(pq.begin(),pq.end(),compare);
   
    int cnt =pq.size();
    

    for(int i=0;i<cnt;i++){
        int reali = i+1;
        for(int j=k-1;j-pq[i].first>=0;j--){
            dp[j] = max(dp[j],dp[j-pq[i].first]+pq[i].second);
        }
    }

    cout << dp[k-1];

    return 0;

}
