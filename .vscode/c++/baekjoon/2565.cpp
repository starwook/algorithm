#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int dp[501];
int n;
vector<pair<int,int > > vec;
int dpf(int a){
    if(a == 0){
        return 1;
    }
    for(int i=a-1;i>=0;i--){
        if(vec[i].first< vec[a].first &&vec[i].second<vec[a].second){
            int tmp = dpf(i);
            dp[a] = max(dp[a],tmp+1);
        }
    }
    return dp[a];
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    for(int i=0;i<n;i++){
        int a,b;
        cin >>a>>b;
        vec.push_back(make_pair(a,b));
    }
    int result =0 ;
    fill(dp,dp+501,1);
    sort(vec.begin(),vec.end());
    for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(vec[i].second >vec[j].second){
                dp[i] = max(dp[i],dp[j]+1);
            }
        }
        result = max(result,dp[i]);
    }
    // for (int i = 0; i < n; i++)
    // {
    //     cout << vec[i].first << " "<<vec[i].second <<"\n";
    // }
    // for(int i=0;i<n;i++){
    //     cout<<dp[i]<<" ";
    // }
    cout <<n-result;
    return 0;
}
