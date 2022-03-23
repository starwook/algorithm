#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int arr[9];
int n, m;
int ans[9];
void dfs(int a,int b){
    if(b==m){
        for(int i=0;i<b;i++){
            cout <<ans[i]<<" ";
        }
        cout <<"\n";
        return;
    }
    for(int i=a;i<n;i++){
        ans[b] = arr[i];
        dfs(i,b+1);
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    
    cin >>n>>m;
    for(int i=0;i<n;i++){
        cin >>arr[i];
    }
    sort(arr,arr+n);
    dfs(0,0);
    return 0;
}
