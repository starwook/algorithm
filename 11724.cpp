#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int arr[1001];
int find(int a){
    if(arr[a] ==0){
        return a;
    }
    return arr[a] = find(arr[a]);
}
void unite(int a,int b){
    a = find(a);
    b = find(b);
    arr[a] = b;
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n,m;
    cin>>n>>m;
    int cnt =n;
    for(int i=0;i<m;i++){
        int tmp,tmp1;
        cin >>tmp>>tmp1;
        if(find(tmp) !=find(tmp1)){
            unite(tmp,tmp1);
            cnt--;
        }
    }
    cout <<cnt;

    return 0;
}
