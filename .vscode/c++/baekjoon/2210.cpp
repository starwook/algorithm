#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
vector<int> t;
vector<int>::iterator it;
int x[4] = {-1,1,0,0};
int y[4] = {0,0,-1,1};
int visited[1000000];
int ans;

int arr[6][6];

void dfs(int r,int c,int sum,int n){
    if(n==6){
        if(visited[sum] ==0){
            ans++;
            visited[sum] = 1;
            

        }
        return;
    }
    for(int i=0;i<4;i++){
        int xi = r+x[i];
        int yi = c+y[i];
        if(xi>=0&&xi<5&&yi>=0&&yi<5){
            dfs(xi,yi,sum*10+arr[xi][yi],n+1);
        }
    }
}
int main()
{
    ans =0;
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
            cin >>arr[i][j];
        }
    }
    for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
            dfs(i,j,0,0);
        }
    }
    cout << ans;

    return 0;
}
