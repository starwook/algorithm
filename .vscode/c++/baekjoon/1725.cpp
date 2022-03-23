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
int arr[100001];
int seg(int s,int e){
    if(e<s){
        return 0;
    }
    if(s ==e){
        return arr[s];
    }
    int mid = (s+e)/2;
    int ret = max(seg(s,mid),seg(mid+1,e));
    int l = mid, r= mid;
    int now = arr[mid];
    int w = 1;
    int a,b;
    while(l>=s && r<=e){
        a =-1;
        b =-1;
        if(l>s){
            a = min(now, arr[l-1]);
        }
        if(r<e){
            b = min(now, arr[r+1]);
        }
        if(a >b){
            now = a ;
            l--;
        }
        else{
            now =b;
            r++;
        }
        w++;
        ret = max(ret,w*now);
    }
    return ret;
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    int sta = 1;
    for(int i=1;i<=n;i++){
        cin >>arr[i];
    }
    cout << seg(1,n);

    return 0;
}
