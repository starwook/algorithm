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
int n,k;
long long ans;
long long arr[201][201];
#define module 1000000000
int main()
{
    cin>>n>>k;
    for(int i=0;i<=k;i++){
        arr[1][i] =i;
    }
    for(int i=2;i<=n;i++){
        for(int j=1;j<=k;j++){
            arr[i][j] = (arr[i-1][j] + arr[i][j-1])%module;
        }
    }
    cout<<arr[n][k];
    return 0;
}
