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
int arr[1001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    for(int i=1;i<=n;i++){
        cin >>arr[i];
    }
    sort(arr+1,arr+n+1);
    int cnt =0;
    for(int i=1;i<=n;i++){
        
        cnt += arr[i]*(n-i)+arr[i];
    }
    cout<<cnt;

    return 0;
}
