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
int arr[2001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>k;
    for(int i=1;i<=n;i++){
        cin >>arr[i];
    }
    int ans =0;
    int day =0;
    while(true){
        sort(arr, arr + n+1);
        int now =1;
        for(int i=1;i<=n-k;i++){
            if(arr[i] ==arr[now]){
                now =i;
            }
            else{
                break;
            }
        }
        if(arr[now+k] ==arr[now]){
            break;
        }
        ans+= arr[now+k]- arr[now];
        
        arr[now+k] =arr[now];
        day++;
        
    }
    cout << ans <<" "<<day;
    return 0;
}
