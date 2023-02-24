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
int arr[100001][3];
int main()
{
    arr[1][0] =1;
    arr[1][1] =1;
    arr[1][2] =1;
    cin>>n;
    for(int i=2;i<=n;i++){
        arr[i][0] = arr[i-1][0]+arr[i-1][1]+arr[i-1][2];
        arr[i][0] %= 9901;
        arr[i][1] = arr[i-1][0]+arr[i-1][2];
        arr[i][1] %= 9901;
        arr[i][2] = arr[i-1][0]+arr[i-1][1];
        arr[i][2] %= 9901;
    }
    int ans =0;
    for(int i=0;i<3;i++){
        ans+=arr[n][i];
        ans %=9901;
    }
    cout<<ans;

    return 0;
}
