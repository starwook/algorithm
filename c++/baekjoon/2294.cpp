#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int price[101];
int arr[10001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n,k;
    cin>>n>>k;
    for(int i=1;i<=n;i++){
        cin >>price[i];
    }
    fill(arr,arr+10001,10001);
    sort(price+1,price+101,greater<int>());
    // for(int i=0;i<=n;i++){
    //     cout <<price[i] <<" ";
    // }
    bool find = true;
    if(k < price[n] ){
        find = false;
        
    }
    else{
        for (int i = 1; i <= k; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (i - price[j] == 0)
                {
                    arr[i] = 1;
                    break;
                }
                else if (i - price[j] >= 0 && arr[i-price[j]] !=10001 )
                {
                    arr[i] = min(arr[i], arr[i - price[j]] + 1);
                }
            }
        }
        // for(int i=1;i<=k;i++){
        //      cout <<arr[i]<<" ";
        // }
        if(arr[k]>=10001){
            find = false;
        }
        if(find){
            cout << arr[k];
        }
        else{
            cout << "-1";
        }
    }
    return 0;
}
