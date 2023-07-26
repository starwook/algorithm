#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[1000];
int t[1000];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    for(int i=1;i<=n;i++){
        cin>>arr[i];
    }
    fill(t,t+1000,1);
    for(int i=2;i<=n;i++){
        for(int j=1;j<i;j++){
            if(arr[i]>arr[j]){
                t[i] = max(t[i],t[j]+1);
            }
        }
    }
    int mx = 1;
    for(int i=1;i<=n;i++){
        mx = max(mx,t[i]);
    }
    cout<<mx;
    return 0;
}
