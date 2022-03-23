#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
using namespace std;
int parent[1000001];
int high[1000001];
int find(int a){
    if(parent[a] == -1){
        return a;
    }
    return parent[a] = find(parent[a]);
}
void unite(int a, int b){
    a = find(a);
    b = find(b);
    if(a==b){
        return;
    }
    if(high[a] > high[b]){
        parent[b] =a;
    }
    else if (high[a] <high[b]){
        parent[a] = b;
    }
    else{
        parent[b] =a;
        high[a] ++;
    }
}

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n,m;
    cin >>n>> m;
    fill(parent,parent+1000001,-1);
    for(int i=0;i<m;i++){
        int tmp;
        int a,b;
        cin>>tmp>>a>>b;
        if(!tmp){
            if(a!=b){
                unite(a, b);
            }
        }
        else{
            if(a == b){
                cout <<"YES\n";
            }
            else if(find(a)==find(b)){
                cout <<"YES\n";
            }
            else{
                cout <<"NO\n";
            }
        }


    }
    return 0;
}
