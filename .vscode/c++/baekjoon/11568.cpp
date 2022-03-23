#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int n;
int arr[1001];
int dp[1001];
vector<int> vec;
vector<int> tmp;
int cnt =0;
int dpf(int a,int b){
    if (b == 0)
    {
        return 0;
    }
    if(dp[a]){
        return dp[a];
    }
    if(arr[b]<arr[a]){
        dp[a] = dpf(b,b-1) +1;
    }
    else{
        dp[a] = dpf(a,b-1);
    }
    return dp[a];
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    for(int i=1;i<=n;i++){
        cin >>arr[n];
    }
    dpf(n,n-1);
    for(int i=0;i<=n;i++){
        cout <<dp[i] <<" ";
    }
    cout <<cnt;
    return 0;
}
