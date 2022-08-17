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
vector<int > vec[1000001];
int arr[1000001][2];
int visited [1000001];
int parent[1000001];
int height[1000001];
void dfs(int a){
    visited[a] =1;
    arr[a][1] = 1;
    for(int i=0;i<vec[a].size();i++){
        int tmp =vec[a][i];
        if(visited[tmp]){
            continue;
        }
        dfs(tmp);
        arr[a][1] += min(arr[vec[a][i]][0],arr[vec[a][i]][1]);
        arr[a][0] += arr[vec[a][i]][1];
    }
    
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    for(int i=0;i<n-1;i++){
        int a,b;
        cin >>a>>b;
        vec[a].push_back(b);
        vec[b].push_back(a);
    }
    dfs(1);
    cout <<min(arr[1][0],arr[1][1]);
    // for(int i=1;i<=n;i++){
    //     for(int j=0;j<vec[i].size();j++){
    //         cout <<vec[i][j] <<" ";
    //     }
    //     cout <<"\n";
    // }
    // for(int i=1;i<=n;i++){
    //     cout <<i <<" -> "<< arr[i][0] <<" " <<arr[i][1] <<"\n";
    // }
    return 0;
    
}
