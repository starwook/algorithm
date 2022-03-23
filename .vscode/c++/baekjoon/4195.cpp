#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <map>
using namespace std;
int parent[200001];
int high[200001];

map<string, int> mp;
map<string,int>::iterator it;
int find(int a){
    if(parent[a] == -1){
        return a;
    }
    return parent[a] = find(parent[a]);
}
void unite(int a,int b){
    a = find(a);
    b = find(b);
    if(a==b){
        cout <<high[a]<<"\n";
        return;
    }
    else{
        parent[a] = b;
        high[b] += high[a];
        cout << high[b] << "\n";
    }

}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int t;
    cin>>t;
    
    while(t--){
        int cnt = 1;
        mp.clear();
        int f;
        cin >> f;
        fill(parent,parent + 200001,-1);
        fill(high, high + 200001, 1);
        
        for(int i=0;i<f;i++){
            
            string a, b;
            cin>>a>>b;
            
            int tmp, tmp1;
            it = mp.find(a);
            if(it ==mp.end()){
                mp[a] = cnt;
                tmp = cnt;
                cnt++;
            }
            else{
                tmp = it->second;

            }
            it = mp.find(b);
            if (it == mp.end())
            {
                mp[b] =cnt; //insert는 pair를 또 따로 만들기 떄문에 make_pair는 메모리를 많이 잡아먹는다.
                tmp1 = cnt;
                cnt++;
            }
            else{
                tmp1 =it->second;
            }
            
            unite(tmp,tmp1);
            
        }
    }

    return 0;
}
