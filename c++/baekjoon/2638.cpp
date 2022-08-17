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
int arr[101][101];
int tmparr[101][101];
int n,m;
int ans =0;
int x[4] ={-1,1,0,0};
int y[4] = {0,0,-1,1};
int bf(int a, int b){
    if(arr[a][b] ==1){
        tmparr[a][b] =1;
        return 1;
    }
    else if(arr[a][b] ==0){

    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cin >>arr[i][j];
            if(arr[i][j]){
                tmparr[i][j] =1;
            }
        }
    }
    while(true){
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                bf(i,j);
            }
        }
       ans++;
    }
    cout<<ans;
    return 0;
}
