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
int arr[200001];
int gcd(int a, int b){
    if(b==0){
        return a;
    }
    else{
        return gcd(b,a%b);
    }

}
int seg(int a,int b,int c){
    if(a>b){
        return 0;
    }
    if(a==b){
        return arr[a];
    }
    if(c ==0){
        //왼쪽 오른쪽 나누기
        int mid;
        if((a+b)%2 ==0){
            mid = (a+b)/2-1;
        }
        else{
            mid = (a + b) / 2;
        }
        
        int l = seg(a, mid, 1) + seg(mid + 1, b, 0);
        int r = seg(a, mid, 0) + seg(mid + 1, b, 1); 
        
        return max(l,r);
    }
    else{
        int g = gcd(arr[a],arr[a+1]);
        for(int i=a+2;i<=b;i++){
            g = gcd(g,arr[i]);
        }
        return g;
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin>>n;
    for(int i=1;i<=n;i++){
        cin >>arr[i];
    }
    cout<< seg(1,n,0);

    return 0;
}
