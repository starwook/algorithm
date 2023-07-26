#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int parent[101];
int high[101];
int find(int a){
    if(parent[a] ==0){
        return a;
    }
    return parent[a] = find(parent[a]);
}
void unite(int a,int b){
    high[b] = high[a] +1;
    
    a = find(a);
    b = find(b);
    parent[a] =b;
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    int one,two;
    cin >>one>>two;
    int m;
    cin >>m;
    while(m--){
        int a, b;
        cin >>a>>b;
        unite(a,b);
    }
    if(find(one) != find(two)){
        cout <<"-1";
    }
    else{
        cout <<high[one]+high[two];
    }
    return 0;
}
