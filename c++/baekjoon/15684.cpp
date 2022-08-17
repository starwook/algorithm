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
int par[2500];
int partotal[2500];
int arr[50][50];
int x[4] ={-1,1,0,0};
int y[4] = {0,0,-1,1};
int visited[50][50];
int height[2500];
bool moved =false;
int n, l,r;
int ans =0;
int found(int a){
    if(par[a] == a){
        return a;
    }
    else{
        return par[a] = found(par[a]);
    }
}
void unite(int a,int b){
    if(height[a]>height[b]){
        par[b] =a;
        height[a]+= height[b];
    }
    else{
        par[a]=b;
        height[b]+= height[a];
    }
}
void bfs(int row,int col){
    visited[row][col] =1;
    for(int i=0;i<4;i++){
        int xi = row+x[i];
        int yi = col+y[i];
        if(xi >=0 &&xi<n&&yi>=0&&yi<n){
            if(!visited[xi][yi]){
                int dif = abs(arr[row][col] -arr[xi][yi]);
                // cout << dif<<"=dif\n";
                if(dif>=l && dif<=r){
                    moved = true;
                    int a = found(row*n+col);
                    int b = found(xi*n+yi);
                    if( a!=b){
                        unite(a,b);
                    }
                    bfs(xi,yi);
                }
            }
        }
    }
}


int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin>>n>>l>>r;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin >>arr[i][j];
            par[i*n+j] =i*n+j;
        }
    }
    
    while(true){
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                height[i * n + j] = 1;
                visited[i][j] =0;
                partotal[i*n+j]=0;
                par[i*n+j]=i*n+j;
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                bfs(i, j);
            }
        }
        if (moved)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    partotal[found(i * n+j)] +=arr[i][j];
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = partotal[found(i*n+j)]/height[found(i*n+j)];
                }
            }
            ans++;
            moved =false;
        }
        else{
            break;
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         cout<<arr[i][j] <<" ";
        //     }
        //     cout<<"\n";
        // }
    }
    cout<<ans;
    return 0;
}
