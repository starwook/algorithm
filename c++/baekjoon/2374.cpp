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
long long ans =0;
int n;
int checking(int a){
    int l =a;
    int r =a;
    while(l-1>=1){
        if(arr[a] ==arr[l-1]){
            l--;
        }
        else{
            break;
        }
    }
    while(r+1<=n){
        if(arr[a] ==arr[r+1]){
            r++;
        }
        else{
            break;
        }
    }
    return r-l+1;
}
void seg(int a,int b){


}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);

     
    cin >>n;
    for(int i=1;i<=n;i++){
        cin >>arr[i];
    }
    seg(1,n);
    cout <<ans;


    return 0;
}
