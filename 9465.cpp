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
int arr[3][100001];
int dp[3][100001];
int visited[3][100001];
int topdown(int a,int b){
    if(b<=0){
        return 0;
    }
    if(visited[a][b]){
        return dp[a][b];
    }
    else{
        
        if(a==1){
            dp[a][b] = max(topdown(2, b - 1), topdown(2, b - 2))+arr[a][b];
        }
        else{
            dp[a][b] = max(topdown(1, b - 1), topdown(1, b - 2))+arr[a][b];
        }
        visited[a][b] = 1;

        return dp[a][b];
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int t;
    cin >>t;
    for(int i=0;i<t;i++){
        cin >>n;
        for(int j=1;j<=2;j++){
            for(int g=1;g<=n;g++ ){
                cin >> arr[j][g];
            }
        }
        dp[1][1] = arr[1][1];
        dp[2][1] = arr[2][1];
        dp[1][2] = dp[2][1] + arr[1][2];
        dp[2][2] = dp[1][1] + arr[2][2];
        visited[1][1] = 1;
        visited[2][1] =1;

        cout << max(topdown(1,n), topdown(2,n)) << "\n";
        for(int t=0;t<3;t++){
            for(int j =0;j<100001;j++){
                dp[t][j] = 0;
                arr[t][j] =0;
                visited[t][j] =0;
            }
        }
    }
    
    return 0;
}
