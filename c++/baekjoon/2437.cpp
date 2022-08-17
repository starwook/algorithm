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
int arr[1001];
vector<int> vec[1001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    int total=0;
    for(int i=1;i<=n;i++){
        cin>>arr[i];
    
    }
    sort(arr,arr+n+1);
    int ans =1;
    for(int i=1;i<=n;i++){
        if(arr[i] >ans){
            break;
        }
        ans +=arr[i];
    }
    cout<<ans;

    return 0;
}
