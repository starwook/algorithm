#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[1000001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n,k,m;
    cin >>n>>k>>m;
    int high =0;
    for(int i=0;i<n;i++){
        cin>>arr[i];
        high = max(high,arr[i]);
    }
    int e =high-k;
    int s =1;
    int p =-1;
    while(s<=e){
        if(s>e){
            break;
        }
        int total =0;
        int mid = (s+e)/2;
        for(int i=0;i<n;i++){
            if(k*2 <=arr[i]){
                total +=(arr[i]-k*2)/mid;
            }
            else if(k<arr[i]){
                total +=(arr[i]-k)/mid;
                
            }
        }
        if(total>=m){
            p = mid;
            s = mid+1;
        }
        else if(total <m){
            e = mid - 1;
        }
    }
    cout <<p;
    


    return 0;
}
