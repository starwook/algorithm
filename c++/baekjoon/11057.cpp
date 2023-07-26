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
int n;
int arr[1001][10];
int main()
{
    cin>>n;
    for(int i=0;i<10;i++){
        arr[1][i] =1;
    }
    for(int i=2;i<=n;i++){
        for(int j=0;j<10;j++){
            if(j==0){
                arr[i][j] =1;
                continue;
            }
            arr[i][j] = arr[i][j-1]+arr[i-1][j];
            arr[i][j] %=10007;
        }
    }
    int cnt=0;
    for(int i=0;i<10;i++){
        cnt+=arr[n][i];
        cnt%=10007;
    }
    cout<<cnt;
    return 0;
}
