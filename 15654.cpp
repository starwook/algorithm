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
int ans[9];
int visited[9];
int n, m;
void dfs(int b){
    if(b==m){
        for(int i=0;i<m;i++){
            cout <<ans[i] <<" ";
        }
        cout <<"\n";
        return;
    }
    
    for(int i=0;i<n;i++){
        if(!visited[i]){
            visited[i] =1;
            ans[b] =arr[i];
            dfs(b+1);
            visited[i] =0;
        }
    }
    
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> m;
    for(int i=0;i<n;i++){
       cin >>arr[i];
    }
    sort(arr,arr+n);
    dfs(0);
    return 0;
}
