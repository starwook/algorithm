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
int rise[1001];
int derise[1001];
int dp[1001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    for(int i=1;i<=n;i++){
        cin >>arr[i];
    }
    fill(rise,rise+1001,1);
    fill(derise,derise+1001,1);
    for(int i=1;i<=n;i++){
        for(int j=1;j<i;j++){
            if(arr[i]>arr[j]){
                rise[i] = max(rise[i],rise[j]+1);
            }
        }
        
    }
    for (int i = n; i >= 1; i--)
    {
        for (int j = n; j > i; j--)
        {
            if (arr[i] > arr[j])
            {
                derise[i] = max(derise[i], derise[j] + 1);
            }
        }
    }
    for(int i=1;i<=n;i++){
        dp[i] = rise[i]+derise[i]-1;
        // cout <<rise[i]<<" ";
    }
    // cout <<"\n";
    int mx = dp[1];
    for (int i = 1; i <= n; i++)
    {
        // cout << derise[i] << " ";
        mx = max(mx,dp[i]);
    }
    cout<<mx;
    return 0;
}
