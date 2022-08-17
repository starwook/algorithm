#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[1000][3];
int arr1[1000][3];
int dp(int n,int c){
    if(n ==0){
        if(c==0){
            return arr[0][0];
        }
        else if(c==1){
            return arr[0][1];
        }
        else{
            return arr[0][2];
        }
    }
    if( arr1[n][c] !=1000000){
        // cout << n<<" "<<c<<"already exist\n";
        return arr1[n][c];
    }
    if(c ==0){
        // cout <<"case 0\n";
        arr1[n][c] = arr[n][c] +min(dp(n-1,1),dp(n-1,2));
    }
    else if(c ==1){
        //cout <<"case 1\n";
        arr1[n][c] = arr[n][c] +min(dp(n-1,0),dp(n-1,2));
    }
    else{
        //cout <<"case 2\n";
        arr1[n][c] = arr[n][c] +min(dp(n-1,0),dp(n-1,1));
    }

    return arr1[n][c];
    

}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    int total = 0;
    for(int i=0;i<n;i++){
        arr1[i][0] = 1000000;
        arr1[i][1] = 1000000;
        arr1[i][2] = 1000000;
    }
    for(int i=0;i<n;i++){
        cin >>arr[i][0];
        cin >>arr[i][1];
        cin >>arr[i][2];
    }
    total = min(dp(n-1,0),min(dp(n-1,1),dp(n-1,2)));
    cout <<total;


    return 0;
}
