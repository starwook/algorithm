#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int parent[1001];
int find(int a){
    if(parent[a] ==0){
        return a;
    }
    return parent[a] = find(parent[a]);
}
void unite(int a,int b){
    a = find(a);
    b = find(b);
    parent[a] = b;
}
vector <pair<int ,pair<int,int> > > vec;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n, m;
    cin>> n>> m;
    for(int i=0;i<m;i++){
        int a,b,c;
        cin >>a>>b>>c;
        vec.push_back(make_pair(c,make_pair(a,b)));
    }
    sort(vec.begin(), vec.end());
   
    
    int q;
    cin >>q;
    while(q--){
        fill(parent,parent+1001,0);
        int a,b;
        cin >>a>>b;
        unite(a,b);
        int cnt = 2;
        int total = 0;
        
        for (auto it:vec){
            if(cnt ==n){
                break;
            }
            int one = it.second.first;
            int two = it.second.second;
            if(find(one) != find(two)){
                unite(one,two);
                cnt++;
                total += it.first;
            }
        }
        cout <<total <<"\n"; 
    }
    return 0;
}
