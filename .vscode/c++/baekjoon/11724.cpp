#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;

int parent[1001];
int height[1001];
int find(int a){
    if(parent[a] ==0){
        return a;
    }
    else return parent[a] = find(parent[a]);
}
void unite(int a,int b){
    if(height[a]>height[b]){
        parent[b] =a;
        
    }
    else if(height[b]>height[a]){
        parent[a] =b;
        
    }
    else{
        parent[a] =b;
        height[b]++;
    }

}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n,m;
    cin>>n>>m;
    for(int i=0;i<m;i++){
        int u,v;
        cin>>u>>v;
        if(find(u)!= find(v)){
    
            unite(find(u),find(v));
        }

    }
    int cnt =0;
    for(int i=1;i<=n;i++){
        if(parent[i] == 0){
            cnt++;
        }

    }
    cout <<cnt++;


    return 0;
}
