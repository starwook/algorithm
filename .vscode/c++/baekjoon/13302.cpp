#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[101];
int dp[101][4];
int coupon[101];
int n, m;
void topdown(int a){
    if(!arr[a]){ //아무것도 없는 날

    }
    else{
        
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>m;
    for(int i=0;i<m;i++){
        int tmp;
        cin >>tmp;
        arr[tmp] =1;
    } 
    topdown(n);
    // if(!arr[1]){
    //     dp[1][1] =1;
    // }
    // for(int i=2;i<=n;i++){
    //     if(!arr[i]){
    //         if(i>=5){
    //             if (!arr[i - 1] && !arr[i - 2] && !arr[i - 3] && !arr[i - 4]){
    //                 dp[i][3] -=1;
    //                 dp[i][5] +=2;
    //                 coupon[i] =coupon[i-4]+2;
    //             }
    //             else{

    //             }
    //         }
    //         else (!arr[i-1] &&!arr[i-2]){ 
    //             dp[i][1] -=2;
    //             dp[i][3] +=1;
    //             coupon[i] =coupon[i-2]+1;
    //         }
    //     }
    //     else{
    //         continue;
    //     }
    // }

    return 0;
}
//10000 25000 37000
//하루 +3일 35000 쿠폰 1징  5일 37000 쿠폰 2장